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
package com.github.speter555.weather.common.rest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

import com.github.speter555.weather.api.jakarta.system.ISystemRest;
import com.github.speter555.weather.common.core.logging.LogMethodEntryAndExit;
import com.github.speter555.weather.common.rest.action.EvictAction;
import hu.icellmobilsoft.coffee.rest.rest.BaseRestService;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;

/**
 * System rest endpoint implementations
 *
 * @author speter555
 * @since 0.1.0
 */
@Model
public class SystemRest extends BaseRestService implements ISystemRest {

    @Inject
    EvictAction evictAction;

    /**
     * Default constructor
     */
    public SystemRest() {
        // Default constructor for java 21
    }

    @Override
    @LogMethodEntryAndExit
    public String versionInfo() throws BaseException {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("META-INF/MANIFEST.MF");
            StringBuilder version = new StringBuilder();
            if (inputStream != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                String line;
                while ((line = br.readLine()) != null) {
                    version.append(line);
                    version.append("\n");
                }
            }
            return version.toString();
        } catch (Exception e) {
            throw baseExceptionWithLogging(e);
        }
    }

    @Override
    public List<String> evict() throws BaseException {
        return wrapNoParam(evictAction::evict, "evict");
    }
}
