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
package com.github.speter555.weather.common.rest.action;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

import com.github.speter555.weather.common.core.evictable.Evictable;
import hu.icellmobilsoft.coffee.cdi.util.ProxyUtils;
import hu.icellmobilsoft.coffee.configuration.ApplicationConfiguration;

/**
 * {@link Evictable} service handling action class
 *
 * @author speter555
 * @since 0.1.0
 */
@Model
public class EvictAction extends BaseAction {

    @Inject
    ApplicationConfiguration applicationConfiguration;

    @Any
    @Inject
    Instance<Evictable> evictables;

    /**
     * Default constructor
     */
    public EvictAction() {
        // Default constructor for java 21
    }

    /**
     * Evict operation. Collect and iterate over all {@link Evictable} interface's implementation.
     *
     * @return list of evected class names, that collect {@link Evictable} implementations class names.
     */
    public List<String> evict() {

        List<String> evicted = new ArrayList<>();

        applicationConfiguration.clear();
        evicted.add(getName(applicationConfiguration));

        if (!evictables.isUnsatisfied()) {
            evictables.forEach(evictable -> {
                evictable.evict();
                evicted.add(getName(evictable));
            });
        }

        return evicted;
    }

    private String getName(Object evictable) {
        return ProxyUtils.getUnproxiedClass(evictable.getClass()).getName();
    }

}
