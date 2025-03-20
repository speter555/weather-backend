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
package com.github.speter555.weather.common.rest.locale;

import java.util.Locale;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;
import jakarta.interceptor.Interceptor;

import org.apache.commons.lang3.StringUtils;
import org.apache.deltaspike.core.impl.message.DefaultLocaleResolver;

import com.github.speter555.weather.common.rest.header.ProjectHeader;
import hu.icellmobilsoft.coffee.cdi.logger.AppLogger;
import hu.icellmobilsoft.coffee.cdi.logger.ThisLogger;

/**
 * Locale resolver by header {@value ProjectHeader#HEADER_LANGUAGE} value
 *
 * @author speter555
 *
 */
@Dependent
@Alternative
@Priority(Interceptor.Priority.APPLICATION + 10)
public class ProjectLocaleResolver extends DefaultLocaleResolver {

    /**
     * Default language
     */
    public static final String DEFAULT_LANGUAGE = "en";

    /**
     * Project header
     */
    @Inject
    ProjectHeader header;

    /**
     * Logger
     */
    @Inject
    @ThisLogger
    AppLogger log;

    /**
     * Default constructor
     */
    public ProjectLocaleResolver() {
        // Default constructor for java 21
    }

    @Override
    public Locale getLocale() {
        if (header != null) {
            log.debug("header language: [{0}]", header.getLanguage());
            String language = header.getLanguage();
            if (StringUtils.isNotBlank(language)) {
                return new Locale(language);
            }
        }
        return new Locale(DEFAULT_LANGUAGE);
    }

}
