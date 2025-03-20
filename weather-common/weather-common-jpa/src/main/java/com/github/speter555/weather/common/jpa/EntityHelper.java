/*-
 * #%L
 * Sampler
 * %%
 * Copyright (C) 2022 i-Cell Mobilsoft Zrt.
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
package com.github.speter555.weather.common.jpa;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

import hu.icellmobilsoft.coffee.model.base.annotation.CurrentUser;
import io.quarkus.arc.Unremovable;

/**
 * Entity helper class
 *
 * @author speter555
 * @since 0.1.0
 */
@Named
@Dependent
public class EntityHelper extends hu.icellmobilsoft.coffee.jpa.sql.entity.EntityHelper {

    /**
     * Default system user identifier
     */
    public static final String DEFAULT_SYSTEM_USER = "0";

    /**
     * Audit user producer
     *
     * @return customerUser id
     */
    @Unremovable
    @Produces
    @CurrentUser
    public String currentUser() {
        return DEFAULT_SYSTEM_USER;
    }
}
