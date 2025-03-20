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
package com.github.speter555.weather.api.jakarta.weather;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.speter555.weather.api.jakarta.path.WeatherServicePath;
import com.github.speter555.weather.dto.weather.weather.WeatherCityResponse;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;

/**
 * REST endpoint for /weather/{city}
 *
 * @author speter555
 * @since 0.1.0
 */
@Tag(name = "Get weather by city ", description = "Get weather by city")
@Path(WeatherServicePath.WEATHER)
public interface IWeatherCityRest {

    /**
     * Get weather by city
     *
     * @param city
     *            city
     * @return Weather data
     * @throws BaseException
     *             in case of error
     */
    @Operation(summary = "Get weather by city", description = "Query the path parameter city from wttr.in app with cache")
    @GET
    @Path(WeatherServicePath.CITY)
    @Produces({ MediaType.APPLICATION_JSON })
    WeatherCityResponse getWeatherCity(@PathParam(WeatherServicePath.PARAM_CITY) String city) throws BaseException;
}
