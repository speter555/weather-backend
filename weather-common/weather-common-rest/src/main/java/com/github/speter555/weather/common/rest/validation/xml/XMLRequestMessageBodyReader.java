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
package com.github.speter555.weather.common.rest.validation.xml;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.ext.Provider;

import hu.icellmobilsoft.coffee.dto.common.commonservice.BaseRequestType;
import hu.icellmobilsoft.coffee.rest.validation.xml.XmlMessageBodyReaderBase;

/**
 * MessageBodyReader for xml requests
 *
 * @author speter555
 * @since 0.1.0
 */
@Provider
@Dependent
@Consumes({ MediaType.APPLICATION_XML, MediaType.TEXT_XML })
@Priority(Priorities.ENTITY_CODER)
public class XMLRequestMessageBodyReader extends XmlMessageBodyReaderBase<BaseRequestType> {

    /**
     * Default constructor
     */
    public XMLRequestMessageBodyReader() {
        // Default constructor for java 21
    }
}
