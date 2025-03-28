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

import hu.icellmobilsoft.coffee.tool.utils.json.JsonUtil;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;

import com.github.speter555.weather.common.reactive.message.WeatherReactiveMessageConstants;
import com.github.speter555.weather.dto.weather.weather.WeatherCityResponse;
import hu.icellmobilsoft.coffee.dto.common.commonservice.ContextType;
import hu.icellmobilsoft.coffee.rest.action.AbstractBaseAction;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;
import hu.icellmobilsoft.coffee.se.util.string.RandomUtil;
import hu.icellmobilsoft.coffee.tool.utils.date.DateUtil;
import hu.icellmobilsoft.coffee.tool.utils.validation.ParamValidatorUtil;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

/**
 * Get weather by city
 *
 * @author speter555
 * @since 0.1.0
 */
@Model
public class WeatherCityAction extends AbstractBaseAction {

    @Inject
    WeatherCityResponseCache weatherCityResponseCache;

    @Inject
    @Channel(WeatherReactiveMessageConstants.Channel.LOGGING_CHANNEL)
    Emitter<String> emitter;

    @Override
    public ContextType createContext() {
        return new ContextType().withRequestId(RandomUtil.generateId()).withTimestamp(DateUtil.nowUTC());
    }

    /**
     * Get weather by city
     *
     * @param city
     *            city
     * @return weather data
     * @throws BaseException
     *             in case of error
     */
    public WeatherCityResponse getWeatherCity(String city) throws BaseException {
        ParamValidatorUtil.requireNonBlank(city, "city");
        WeatherCityResponse response = new WeatherCityResponse();
        WeatherCityResponse cacheResult = weatherCityResponseCache.get(city);
        response.setCity(cacheResult.getCity());
        response.setDescription(cacheResult.getDescription());
        response.setTemperature(cacheResult.getTemperature());
        handleSuccessResultType(response);

        emitter.send(Message.of(JsonUtil.toJson(cacheResult)));
        return response;
    }
}
