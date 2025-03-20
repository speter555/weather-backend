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
package com.github.speter555.weather.service;

import java.util.Optional;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

import com.github.speter555.weather.common.jpa.service.ProjectBaseService;
import com.github.speter555.weather.model.Weather;
import com.github.speter555.weather.repository.WeatherRepository;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;

/**
 * Jpa service of {@link Weather}
 *
 * @author speter555
 * @since 0.1.0
 */
@Model
public class WeatherService extends ProjectBaseService<Weather> {

    @Inject
    WeatherRepository repository;

    /**
     * Get Weather by city into Optional
     *
     * @param city
     *            weather data's city
     * @return Optional Weather element
     * @throws BaseException
     *             in case of error
     */
    public Optional<Weather> findOptionalLastWeatherByCity(String city) throws BaseException {
        return wrapOptional(repository::findLastWeatherByCity, city, "findOptionalLastWeatherByCity", "city");
    }
}
