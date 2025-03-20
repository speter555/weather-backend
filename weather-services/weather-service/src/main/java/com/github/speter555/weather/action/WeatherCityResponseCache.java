/*-
 * #%L
 * Weather-backend
 * %%
 * Copyright (C) 2025 i-Cell Mobilsoft Zrt.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.github.speter555.weather.action;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.github.speter555.weather.common.core.evictable.Evictable;
import com.github.speter555.weather.dto.weather.weather.WeatherCityResponse;
import com.github.speter555.weather.model.Weatherreport;
import com.github.speter555.weather.restclient.dto.CurrentCondition;
import com.github.speter555.weather.restclient.dto.WeatherResponse;
import com.github.speter555.weather.restclient.wttrinapi.WttrInRestClient;
import com.github.speter555.weather.service.WeatherreportService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import hu.icellmobilsoft.coffee.dto.exception.InvalidParameterException;
import hu.icellmobilsoft.coffee.dto.exception.ServiceUnavailableException;
import hu.icellmobilsoft.coffee.jpa.helper.TransactionHelper;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;
import hu.icellmobilsoft.coffee.tool.utils.date.DateUtil;
import hu.icellmobilsoft.coffee.tool.utils.validation.ParamValidatorUtil;

/**
 * {@link WeatherCityResponse} cache
 */
@ApplicationScoped
public class WeatherCityResponseCache implements Evictable {

    @Inject
    WeatherreportService weatherreportService;

    @Inject
    TransactionHelper transactionHelper;

    @Inject
    @RestClient
    WttrInRestClient restClient;

    private final LoadingCache<String, WeatherCityResponse> cache = CacheBuilder.from("expireAfterWrite=30m").build(new CacheLoader<>() {

        @Override
        public WeatherCityResponse load(String city) throws Exception {
            return init(city);
        }

    });

    /**
     * Return searched element from cache
     *
     * @param city
     *            cache key
     * @return a found element
     * @throws BaseException
     *             in case of error, {@link ServiceUnavailableException} if wttr.in is not working well, {@link InvalidParameterException} if the city
     *             parameter is blank {@link hu.icellmobilsoft.coffee.dto.exception.TechnicalException} in case of database error
     */
    public WeatherCityResponse get(String city) throws BaseException {
        ParamValidatorUtil.requireNonBlank(city, "city");
        try {
            return cache.get(city);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof BaseException baseException) {
                throw baseException;
            } else {
                throw new ServiceUnavailableException(MessageFormat.format("Error reading from cache: [{0}]", city), e);
            }
        }
    }

    private WeatherCityResponse init(String city) throws BaseException {
        ParamValidatorUtil.requireNonBlank(city, "city");
        Optional<Weatherreport> weatherOptional = weatherreportService.findOptionalLastWeatherByCity(city);
        Weatherreport weatherreport = weatherOptional.orElse(null);
        if (weatherreport == null || Duration.between(weatherreport.getRetrievedAt(), DateUtil.nowUTC().toLocalDateTime()).toMinutes() >= 30) {
            weatherreport = getWeatherAndSave(city);
        }
        return new WeatherCityResponse().withCity(city).withDescription(weatherreport.getDescription()).withTemperature(weatherreport.getTemperature());
    }

    private Weatherreport getWeatherAndSave(final String city) throws BaseException {
        var now = DateUtil.nowUTC().toLocalDateTime();
        WeatherResponse weatherResponse = restClient.getWeatherByCity(city, "j2");
        if (weatherResponse.getCurrent_condition().isEmpty() || weatherResponse.getCurrent_condition().get(0).getWeatherDesc().isEmpty()) {
            throw new ServiceUnavailableException("current condition is empty OR weather description is empty");
        }
        CurrentCondition currentCondition = weatherResponse.getCurrent_condition().get(0);
        Weatherreport weatherreport = new Weatherreport();
        weatherreport.setCity(city);
        weatherreport.setDescription(currentCondition.getWeatherDesc().get(0).getValue());
        weatherreport.setTemperature(Integer.parseInt(currentCondition.getTemp_C()));
        weatherreport.setRetrievedAt(now);
        return transactionHelper.executeWithTransaction(() -> weatherreportService.save(weatherreport));
    }

    @Override
    public void evict() {
        cache.invalidateAll();
    }
}
