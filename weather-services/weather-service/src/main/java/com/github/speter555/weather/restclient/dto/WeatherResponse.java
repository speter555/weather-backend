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
package com.github.speter555.weather.restclient.dto;

import java.util.List;

/**
 * WeatherResponse
 *
 * @author speter555
 * @since 0.1.0
 */
@SuppressWarnings("java:S100")
public class WeatherResponse {

    private List<CurrentCondition> current_condition;
    private List<NearestArea> nearest_area;
    private List<Request> request;
    private List<Weather> weather;

    public List<CurrentCondition> getCurrent_condition() {
        return current_condition;
    }

    public void setCurrent_condition(List<CurrentCondition> current_condition) {
        this.current_condition = current_condition;
    }

    public List<NearestArea> getNearest_area() {
        return nearest_area;
    }

    public void setNearest_area(List<NearestArea> nearest_area) {
        this.nearest_area = nearest_area;
    }

    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
