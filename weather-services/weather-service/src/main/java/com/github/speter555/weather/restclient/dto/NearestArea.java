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
 * NearestArea
 *
 * @author speter555
 * @since 0.1.0
 */
@SuppressWarnings("java:S100")
public class NearestArea {

    private List<LangValue> areaName;
    private List<LangValue> country;
    private String latitude;
    private String longitude;
    private String population;
    private List<LangValue> region;
    private List<LangValue> weatherUrl;

    public List<LangValue> getAreaName() {
        return areaName;
    }

    public void setAreaName(List<LangValue> areaName) {
        this.areaName = areaName;
    }

    public List<LangValue> getCountry() {
        return country;
    }

    public void setCountry(List<LangValue> country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<LangValue> getRegion() {
        return region;
    }

    public void setRegion(List<LangValue> region) {
        this.region = region;
    }

    public List<LangValue> getWeatherUrl() {
        return weatherUrl;
    }

    public void setWeatherUrl(List<LangValue> weatherUrl) {
        this.weatherUrl = weatherUrl;
    }
}
