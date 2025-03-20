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
/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.github.speter555.weather.common.rest.locale;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Alternative;
import jakarta.interceptor.Interceptor;

import org.apache.deltaspike.core.api.message.MessageContext;
import org.apache.deltaspike.core.impl.message.DefaultMessageResolver;
import org.apache.deltaspike.core.util.message.ClassUtils;

/**
 * {@code MessageResolver} for resolving localized messages with custom fallback locale logic
 *
 * @author speter555
 * @since 0.1.0
 */
@Dependent
@Alternative
@Priority(Interceptor.Priority.APPLICATION + 10)
public class ProjectMessageResolver extends DefaultMessageResolver {

    /**
     * Resource bundle controller
     */
    private final ResourceBundleControl resourceBundleControl = new ResourceBundleControl();

    /**
     * Default constructor
     */
    public ProjectMessageResolver() {
        // Default constructor for java 21
    }

    @Override
    public String getMessage(MessageContext messageContext, String messageTemplate, String category) {
        // we can use {{ as escaping for now
        if (messageTemplate.startsWith("{{")) {
            // in which case we just cut of the first '{'
            return messageTemplate.substring(1);
        }

        if (messageTemplate.startsWith("{") && messageTemplate.endsWith("}")) {
            String resourceKey = messageTemplate.substring(1, messageTemplate.length() - 1);

            List<String> messageSources = getMessageSources(messageContext);

            if (messageSources == null || messageSources.isEmpty()) {
                // using {} without a bundle is always an error
                return null;
            }

            // NOTE deltaspike do not handle the concurrent message read, so there have to create a copy list that won't be generated
            // ConcurrentModificationException. Under high load can be that more faultTypes are created in 1 service instance
            List<String> copy = new ArrayList<>(messageSources);
            Iterator<String> messageSourceIterator = copy.iterator();

            Locale locale = messageContext.getLocale();

            String currentMessageSource;
            while (messageSourceIterator.hasNext()) {
                currentMessageSource = messageSourceIterator.next();

                try {
                    // this is the line we want to override from the DefaultMessageResolver
                    ResourceBundle messageBundle = getResourceBundle(locale, currentMessageSource);

                    if (category != null && category.length() > 0) {
                        try {
                            return messageBundle.getString(resourceKey + "_" + category);
                        } catch (MissingResourceException e) {
                            // we fallback on the version without the category
                            return messageBundle.getString(resourceKey);
                        }
                    }

                    return messageBundle.getString(resourceKey);
                } catch (MissingResourceException e) {
                    if (!messageSourceIterator.hasNext()) {
                        return null;
                    }
                }
            }
        }

        return messageTemplate;
    }

    private ResourceBundle getResourceBundle(Locale locale, String currentMessageSource) {
        return ResourceBundle.getBundle(currentMessageSource, locale, ClassUtils.getClassLoader(null), resourceBundleControl);
    }

    /**
     * Inner class for resource bundle control
     */
    private static class ResourceBundleControl extends ResourceBundle.Control {
        @Override
        public Locale getFallbackLocale(String baseName, Locale locale) {
            return isDefault(locale) ? null : getDefaultLocale();
        }

        private boolean isDefault(Locale locale) {
            return locale.toString().equals(ProjectLocaleResolver.DEFAULT_LANGUAGE.toLowerCase());
        }

        private Locale getDefaultLocale() {
            return new Locale(ProjectLocaleResolver.DEFAULT_LANGUAGE);
        }
    }
}
