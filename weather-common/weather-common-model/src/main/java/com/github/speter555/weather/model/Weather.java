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
package com.github.speter555.weather.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import hu.icellmobilsoft.coffee.model.base.AbstractIdentifiedEntity;

/**
 * Weather element in database
 *
 * @author speter555
 * @since 0.1.0
 */
@Entity
@Table(name = "WEATHER")
public class Weather extends AbstractIdentifiedEntity {

    /**
     * City
     */
    @NotNull
    @Column(name = "CITY", nullable = false, updatable = false)
    private String city;

    /**
     * Temperature
     */
    @NotNull
    @Column(name = "TEMPERATURE", nullable = false, updatable = false)
    private int temperature;

    /**
     * Description
     */
    @NotNull
    @Column(name = "DESCRIPTION", nullable = false, updatable = false)
    private String description;

    /**
     * Retrieved At
     */
    @NotNull
    @Column(name = "RETRIEVED_AT", nullable = false, updatable = false)
    private LocalDateTime retrievedAt;

    /**
     * Getter of city
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter of city
     *
     * @param city
     *            city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter of temperature
     *
     * @return temperature
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Setter of temperature
     *
     * @param temperature
     *            temperature
     */
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    /**
     * Getter of description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter of description
     *
     * @param description
     *            description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter of retrievedAt
     *
     * @return retrievedAt
     */
    public LocalDateTime getRetrievedAt() {
        return retrievedAt;
    }

    /**
     * Setter of retrievedAt
     *
     * @param retrievedAt
     *            retrieved at
     */
    public void setRetrievedAt(LocalDateTime retrievedAt) {
        this.retrievedAt = retrievedAt;
    }
}
