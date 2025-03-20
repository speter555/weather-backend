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
package com.github.speter555.weather.common.rest.exception;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.ext.Provider;

import hu.icellmobilsoft.coffee.rest.exception.DefaultBaseExceptionMapper;

/**
 * Exception mapper for handled exception throwing
 *
 * @author speter555
 *
 */
@Provider
@Dependent
public class RestExceptionMapper extends DefaultBaseExceptionMapper {

    /**
     * Default constructor
     */
    public RestExceptionMapper() {
        // Default constructor for java 21
    }
}
