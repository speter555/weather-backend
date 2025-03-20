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
package com.github.speter555.weather.common.rest.restclient.exception;

import hu.icellmobilsoft.coffee.se.api.exception.BaseException;

/**
 * Special Exception for MP rest client base exception at http 500 and hold message from response
 * 
 * @author speter555
 * @since 0.11.0
 */
public class MPRestClientBaseException extends BaseException {

    /**
     * Constructor
     *
     * @param faultTypeEnum
     *            original faulType from response
     * @param message
     *            original message from response
     */
    public MPRestClientBaseException(Enum<?> faultTypeEnum, String message) {
        super(faultTypeEnum, message);
    }
}
