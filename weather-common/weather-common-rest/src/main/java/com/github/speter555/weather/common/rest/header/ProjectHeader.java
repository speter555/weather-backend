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
package com.github.speter555.weather.common.rest.header;

import java.util.List;
import java.util.Map;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.MultivaluedMap;

import org.apache.commons.lang3.StringUtils;

import com.github.speter555.weather.api.jakarta.dto.constant.IHttpHeaderConstant;
import hu.icellmobilsoft.coffee.se.logging.Logger;

/**
 * Project header class
 *
 * @author speter555
 * @since 0.1.0
 */
public class ProjectHeader implements IHttpHeaderConstant {

    private String language;

    /**
     * Default constructor
     */
    public ProjectHeader() {
        // Default constructor for java 21
    }

    /**
     * Create ProjectHeader instance from {@link ContainerRequestContext}
     *
     * @param requestContext
     *            {@link ContainerRequestContext} instance
     * @return ProjectHeader instance
     */
    public static ProjectHeader readHeaders(ContainerRequestContext requestContext) {
        ProjectHeader projectHeader = new ProjectHeader();
        if (requestContext != null) {
            projectHeader = readHeaders(requestContext.getHeaders());
            fillProjectHeaderFromCookie(projectHeader, requestContext.getCookies());
            fillProjectHeaderFromQueryParameter(projectHeader, requestContext.getUriInfo().getQueryParameters());
        }
        return projectHeader;
    }

    /**
     * Create ProjectHeader instance from MultivaluedMap
     *
     * @param headerMap
     *            input
     * @return ProjectHeader instance
     */
    private static ProjectHeader readHeaders(MultivaluedMap<String, String> headerMap) {
        ProjectHeader projectHeader = new ProjectHeader();
        if (headerMap != null) {
            projectHeader.setLanguage(getHeaderValue(headerMap, HEADER_LANGUAGE, false));
        }
        return projectHeader;
    }

    private static void fillProjectHeaderFromCookie(ProjectHeader projectHeader, Map<String, Cookie> cookieMap) {
        if (projectHeader != null && cookieMap != null) {
            if (StringUtils.isBlank(projectHeader.getLanguage())) {
                projectHeader.setLanguage(getCookieValue(cookieMap, HEADER_LANGUAGE, false));
            }

        }
    }

    private static void fillProjectHeaderFromQueryParameter(ProjectHeader projectHeader, MultivaluedMap<String, String> queryParameterMap) {
        if (projectHeader != null && queryParameterMap != null) {
            if (StringUtils.isBlank(projectHeader.getLanguage())) {
                projectHeader.setLanguage(getFirstQueryParameterValue(queryParameterMap, HEADER_LANGUAGE, false));
            }
        }
    }

    /**
     * Get value for key in MultivaluedMap
     *
     * @param headerMap
     *            input
     * @param key
     *            which key
     * @param required
     *            when key is not in headers and it is true, then create warn log message, else create debug message
     * @return key value in input
     */
    private static String getHeaderValue(MultivaluedMap<String, String> headerMap, String key, boolean required) {
        Logger log = Logger.getLogger(ProjectHeader.class);
        try {
            if (headerMap == null) {
                return null;
            }

            List<String> values = headerMap.get(key);
            if (values == null || values.isEmpty()) {
                String msg = "Request header doesnt contain (" + key + ") key";
                if (required) {
                    log.warn(msg);
                } else {
                    log.debug(msg);
                }
                return null;
            } else {
                return values.get(0);
            }
        } catch (Exception e) {
            log.warn("Error in getHeaderValue(" + key + ")", e);
            return null;
        }
    }

    private static String getCookieValue(Map<String, Cookie> cookieMap, String key, boolean required) {
        Logger log = Logger.getLogger(ProjectHeader.class);
        try {
            if (cookieMap == null) {
                return null;
            }

            Cookie cookie = cookieMap.get(key);
            if (cookie == null || StringUtils.isBlank(cookie.getValue())) {
                String msg = "Request query parameter doesnt contain (" + key + ") key";
                if (required) {
                    log.warn(msg);
                } else {
                    log.debug(msg);
                }
                return null;
            } else {
                return cookie.getValue();
            }
        } catch (Exception e) {
            log.warn("Error in getFirstQueryParameterValue(" + key + ")", e);
            return null;
        }
    }

    private static String getFirstQueryParameterValue(MultivaluedMap<String, String> queryParameter, String key, boolean required) {
        Logger log = Logger.getLogger(ProjectHeader.class);
        try {
            if (queryParameter == null) {
                return null;
            }

            List<String> values = queryParameter.get(key);
            if (values == null || values.isEmpty()) {
                String msg = "Request query parameter doesnt contain (" + key + ") key";
                if (required) {
                    log.warn(msg);
                } else {
                    log.debug(msg);
                }
                return null;
            } else {
                return values.get(0);
            }
        } catch (Exception e) {
            log.warn("Error in getFirstQueryParameterValue(" + key + ")", e);
            return null;
        }
    }

    /**
     * Getter of language
     *
     * @return language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Setter of language
     *
     * @param language
     *            language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

}
