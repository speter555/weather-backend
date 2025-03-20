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
package com.github.speter555.weather.api.jakarta.system;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;

import com.github.speter555.weather.api.jakarta.path.ServicePath;
import hu.icellmobilsoft.coffee.se.api.exception.BaseException;

/**
 * REST endpoint for system service functions.
 *
 * @author speter555
 * @since 0.1.0
 */
@Path("")
public interface ISystemRest {

    /**
     * Version info
     * 
     * @return version infos in plain text
     * @throws BaseException
     *             if any error occurs
     */
    @Operation(hidden = true)
    @GET
    @Path(ServicePath.VERSION_INFO)
    @Produces(MediaType.TEXT_PLAIN)
    String versionInfo() throws BaseException;

    /**
     * Evict caches
     *
     * @return evicted elements
     * @throws BaseException
     *             if any error occurs
     */
    @Operation(hidden = true)
    @GET
    @Path(ServicePath.EVICT)
    @Produces(MediaType.TEXT_PLAIN)
    List<String> evict() throws BaseException;
}
