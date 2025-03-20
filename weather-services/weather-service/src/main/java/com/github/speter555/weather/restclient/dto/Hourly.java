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
 * Hourly
 *
 * @author speter555
 * @since 0.1.0
 */
public class Hourly {
    private String DewPointC;
    private String DewPointF;
    private String FeelsLikeC;
    private String FeelsLikeF;
    private String HeatIndexC;
    private String HeatIndexF;
    private String WindChillC;
    private String WindChillF;
    private String WindGustKmph;
    private String WindGustMiles;
    private String chanceoffog;
    private String chanceoffrost;
    private String chanceofhightemp;
    private String chanceofovercast;
    private String chanceofrain;
    private String chanceofremdry;
    private String chanceofsnow;
    private String chanceofsunshine;
    private String chanceofthunder;
    private String chanceofwindy;
    private String cloudcover;
    private String diffRad;
    private String humidity;
    private List<LangValue> lang_hu;
    private String precipInches;
    private String precipMM;
    private String pressure;
    private String pressureInches;
    private String shortRad;
    private String tempC;
    private String tempF;
    private String time;
    private String uvIndex;
    private String visibility;
    private String visibilityMiles;
    private String weatherCode;
    private List<LangValue> weatherDesc;
    private List<LangValue> weatherIconUrl;
    private String winddir16Point;
    private String winddirDegree;
    private String windspeedKmph;
    private String windspeedMiles;

    public String getWindGustMiles() {
        return WindGustMiles;
    }

    public void setWindGustMiles(String windGustMiles) {
        WindGustMiles = windGustMiles;
    }

    public String getDewPointC() {
        return DewPointC;
    }

    public void setDewPointC(String dewPointC) {
        DewPointC = dewPointC;
    }

    public String getDewPointF() {
        return DewPointF;
    }

    public void setDewPointF(String dewPointF) {
        DewPointF = dewPointF;
    }

    public String getFeelsLikeC() {
        return FeelsLikeC;
    }

    public void setFeelsLikeC(String feelsLikeC) {
        FeelsLikeC = feelsLikeC;
    }

    public String getFeelsLikeF() {
        return FeelsLikeF;
    }

    public void setFeelsLikeF(String feelsLikeF) {
        FeelsLikeF = feelsLikeF;
    }

    public String getHeatIndexC() {
        return HeatIndexC;
    }

    public void setHeatIndexC(String heatIndexC) {
        HeatIndexC = heatIndexC;
    }

    public String getHeatIndexF() {
        return HeatIndexF;
    }

    public void setHeatIndexF(String heatIndexF) {
        HeatIndexF = heatIndexF;
    }

    public String getWindChillC() {
        return WindChillC;
    }

    public void setWindChillC(String windChillC) {
        WindChillC = windChillC;
    }

    public String getWindChillF() {
        return WindChillF;
    }

    public void setWindChillF(String windChillF) {
        WindChillF = windChillF;
    }

    public String getWindGustKmph() {
        return WindGustKmph;
    }

    public void setWindGustKmph(String windGustKmph) {
        WindGustKmph = windGustKmph;
    }

    public String getChanceoffog() {
        return chanceoffog;
    }

    public void setChanceoffog(String chanceoffog) {
        this.chanceoffog = chanceoffog;
    }

    public String getChanceoffrost() {
        return chanceoffrost;
    }

    public void setChanceoffrost(String chanceoffrost) {
        this.chanceoffrost = chanceoffrost;
    }

    public String getChanceofhightemp() {
        return chanceofhightemp;
    }

    public void setChanceofhightemp(String chanceofhightemp) {
        this.chanceofhightemp = chanceofhightemp;
    }

    public String getChanceofovercast() {
        return chanceofovercast;
    }

    public void setChanceofovercast(String chanceofovercast) {
        this.chanceofovercast = chanceofovercast;
    }

    public String getChanceofrain() {
        return chanceofrain;
    }

    public void setChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
    }

    public String getChanceofremdry() {
        return chanceofremdry;
    }

    public void setChanceofremdry(String chanceofremdry) {
        this.chanceofremdry = chanceofremdry;
    }

    public String getChanceofsnow() {
        return chanceofsnow;
    }

    public void setChanceofsnow(String chanceofsnow) {
        this.chanceofsnow = chanceofsnow;
    }

    public String getChanceofsunshine() {
        return chanceofsunshine;
    }

    public void setChanceofsunshine(String chanceofsunshine) {
        this.chanceofsunshine = chanceofsunshine;
    }

    public String getChanceofthunder() {
        return chanceofthunder;
    }

    public void setChanceofthunder(String chanceofthunder) {
        this.chanceofthunder = chanceofthunder;
    }

    public String getChanceofwindy() {
        return chanceofwindy;
    }

    public void setChanceofwindy(String chanceofwindy) {
        this.chanceofwindy = chanceofwindy;
    }

    public String getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    public String getDiffRad() {
        return diffRad;
    }

    public void setDiffRad(String diffRad) {
        this.diffRad = diffRad;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public List<LangValue> getLang_hu() {
        return lang_hu;
    }

    public void setLang_hu(List<LangValue> lang_hu) {
        this.lang_hu = lang_hu;
    }

    public String getPrecipInches() {
        return precipInches;
    }

    public void setPrecipInches(String precipInches) {
        this.precipInches = precipInches;
    }

    public String getPrecipMM() {
        return precipMM;
    }

    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getPressureInches() {
        return pressureInches;
    }

    public void setPressureInches(String pressureInches) {
        this.pressureInches = pressureInches;
    }

    public String getShortRad() {
        return shortRad;
    }

    public void setShortRad(String shortRad) {
        this.shortRad = shortRad;
    }

    public String getTempC() {
        return tempC;
    }

    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public String getTempF() {
        return tempF;
    }

    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getVisibilityMiles() {
        return visibilityMiles;
    }

    public void setVisibilityMiles(String visibilityMiles) {
        this.visibilityMiles = visibilityMiles;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public List<LangValue> getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(List<LangValue> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public List<LangValue> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(List<LangValue> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public String getWinddir16Point() {
        return winddir16Point;
    }

    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    public String getWinddirDegree() {
        return winddirDegree;
    }

    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }
}
