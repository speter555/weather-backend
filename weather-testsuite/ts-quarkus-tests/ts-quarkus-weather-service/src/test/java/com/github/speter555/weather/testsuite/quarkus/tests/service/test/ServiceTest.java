/*-
 * #%L
 * weather
 * %%
 * Copyright (C) 2025 speter555
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
package com.github.speter555.weather.testsuite.quarkus.tests.service.test;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.speter555.weather.api.jakarta.system.ISystemRest;
import com.github.speter555.weather.api.jakarta.weather.IWeatherCityRest;
import com.github.speter555.weather.dto.weather.weather.WeatherCityResponse;
import com.github.speter555.weather.testsuite.quarkus.tests.service.test.dto.HealthDto;
import hu.icellmobilsoft.coffee.dto.common.commonservice.ContextType;
import hu.icellmobilsoft.coffee.dto.common.commonservice.FunctionCodeType;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;
import hu.icellmobilsoft.coffee.se.util.string.RandomUtil;
import hu.icellmobilsoft.coffee.tool.utils.date.DateUtil;
import hu.icellmobilsoft.coffee.tool.utils.json.JsonUtil;
import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class ServiceTest {

    /**
     * Server url like: http://localhost:8083
     */
    @TestHTTPResource
    URL url;

    @Test
    void testPositiveFromDb() throws BaseException {
        String city = "Teszt2";
        WeatherCityResponse weatherCityResponse = getRestClient(IWeatherCityRest.class).getWeatherCity(city);
        Assertions.assertNotNull(weatherCityResponse);
        Assertions.assertEquals(FunctionCodeType.OK, weatherCityResponse.getFuncCode());
        Assertions.assertEquals(city, weatherCityResponse.getCity());
        Assertions.assertEquals("Teszt", weatherCityResponse.getDescription());
        Assertions.assertEquals(10, weatherCityResponse.getTemperature());
    }

    @Test
    void testPositiveFromDbExpiredData() throws BaseException {
        String city = "Eger";
        WeatherCityResponse weatherCityResponse = getRestClient(IWeatherCityRest.class).getWeatherCity(city);
        Assertions.assertNotNull(weatherCityResponse);
        Assertions.assertEquals(FunctionCodeType.OK, weatherCityResponse.getFuncCode());
        Assertions.assertEquals(city, weatherCityResponse.getCity());
        Assertions.assertTrue(StringUtils.isNotBlank(weatherCityResponse.getDescription()));
        Assertions.assertNotEquals(-999, weatherCityResponse.getTemperature());
    }

    @Test
    void testPositiveFromWttrIn() throws BaseException {
        String city = "Budapest";
        WeatherCityResponse weatherCityResponse = getRestClient(IWeatherCityRest.class).getWeatherCity(city);
        Assertions.assertNotNull(weatherCityResponse);
        Assertions.assertEquals(FunctionCodeType.OK, weatherCityResponse.getFuncCode());
        Assertions.assertEquals(city, weatherCityResponse.getCity());
        Assertions.assertTrue(StringUtils.isNotBlank(weatherCityResponse.getDescription()));
    }

    @Test
    @DisplayName("Testing /q/health")
    void testHealthCheck() throws Exception {

        String status = HealthCheckResponse.Status.UP.name();

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL("http://localhost:9001/q/health").openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Reading the response if the request is successful
            Assertions.assertEquals(HttpURLConnection.HTTP_OK, connection.getResponseCode());

            // Displaying the response

            // Converting JSON content from the response into a Java object
            HealthDto myObject = JsonUtil.toObject(new InputStreamReader(connection.getInputStream()), HealthDto.class);
            Assertions.assertEquals(status, myObject.getStatus());

        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    @Test
    @DisplayName("Testing 200 response at call /versionInfo over RestClient")
    void versionInfo() throws BaseException {
        String testResponse = RestClientBuilder.newBuilder().baseUrl(url).build(ISystemRest.class).versionInfo();
        Assertions.assertNotNull(testResponse);
    }

    private <T> T getRestClient(Class<T> restClientClass) {
        return RestClientBuilder.newBuilder().baseUrl(url).build(restClientClass);
    }

    private static ContextType createContext() {
        ContextType context = new ContextType();
        context.setRequestId(RandomUtil.generateId());
        context.setTimestamp(DateUtil.nowUTCTruncatedToMillis());
        return context;
    }
}
