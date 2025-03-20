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

import jakarta.annotation.Priority;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Alternative;
import jakarta.interceptor.Interceptor;

import hu.icellmobilsoft.coffee.rest.exception.DefaultExceptionMessageTranslator;

/**
 * Exception translator implementation for exception throwing
 *
 * @author speter555
 *
 */
@Dependent
@Alternative
@Priority(Interceptor.Priority.APPLICATION + 10)
public class ExceptionMessageTranslator extends DefaultExceptionMessageTranslator {

    /**
     * Default constructor
     */
    public ExceptionMessageTranslator() {
        // Default constructor for java 21
    }

}
