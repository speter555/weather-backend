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
 * Weather
 *
 * @author speter555
 * @since 0.1.0
 */
public class Weather {
    private List<Astronomy> astronomy;
    private String avgtempC;
    private String avgtempF;
    private String date;
    private List<Hourly> hourly;
    private String maxtempC;
    private String maxtempF;
    private String mintempC;
    private String mintempF;
    private String sunHour;
    private String totalSnow_cm;
    private String uvIndex;

    public List<Astronomy> getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(List<Astronomy> astronomy) {
        this.astronomy = astronomy;
    }

    public String getAvgtempC() {
        return avgtempC;
    }

    public void setAvgtempC(String avgtempC) {
        this.avgtempC = avgtempC;
    }

    public String getAvgtempF() {
        return avgtempF;
    }

    public void setAvgtempF(String avgtempF) {
        this.avgtempF = avgtempF;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }

    public String getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
    }

    public String getMaxtempF() {
        return maxtempF;
    }

    public void setMaxtempF(String maxtempF) {
        this.maxtempF = maxtempF;
    }

    public String getMintempC() {
        return mintempC;
    }

    public void setMintempC(String mintempC) {
        this.mintempC = mintempC;
    }

    public String getMintempF() {
        return mintempF;
    }

    public void setMintempF(String mintempF) {
        this.mintempF = mintempF;
    }

    public String getSunHour() {
        return sunHour;
    }

    public void setSunHour(String sunHour) {
        this.sunHour = sunHour;
    }

    public String getTotalSnow_cm() {
        return totalSnow_cm;
    }

    public void setTotalSnow_cm(String totalSnow_cm) {
        this.totalSnow_cm = totalSnow_cm;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }
}
