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
package com.github.speter555.weather.rest;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

import com.github.speter555.weather.action.WeatherCityAction;
import com.github.speter555.weather.api.jakarta.weather.IWeatherCityRest;
import com.github.speter555.weather.dto.weather.weather.WeatherCityResponse;
import hu.icellmobilsoft.coffee.rest.rest.BaseRestService;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;

/**
 * Implementation of REST endpoint for /weather/{city}
 *
 * @author speter555
 * @since 0.1.0
 */
@Model
public class WeatherCityRest extends BaseRestService implements IWeatherCityRest {

    @Inject
    WeatherCityAction weatherCityAction;

    /**
     * Default constructor
     */
    public WeatherCityRest() {
        // Default constructor for java 21
    }

    @Override
    public WeatherCityResponse getWeatherCity(String city) throws BaseException {
        return wrapPathParam1(weatherCityAction::getWeatherCity, city, "getWeatherCity", "city");
    }
}
