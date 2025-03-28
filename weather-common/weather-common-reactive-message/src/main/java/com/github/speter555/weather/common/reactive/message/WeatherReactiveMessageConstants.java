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
package com.github.speter555.weather.common.reactive.message;

/**
 * Project Reactive message constants
 */
public interface WeatherReactiveMessageConstants {

    /**
     * Channels constants
     */
    interface Channel {

        /**
         * Logging chanel
         */
        String LOGGING_CHANNEL = "logging";

        /**
         * Logging chanel Consumer
         */
        String LOGGING_CONSUMER_CHANNEL = "logging-consumer";
    }
}
