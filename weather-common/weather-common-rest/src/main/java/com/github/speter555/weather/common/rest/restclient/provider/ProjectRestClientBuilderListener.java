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
package com.github.speter555.weather.common.rest.restclient.provider;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import hu.icellmobilsoft.coffee.module.mp.restclient.provider.DefaultRestClientBuilderListener;

/**
 * Project level REST client listener
 *
 * @see DefaultRestClientBuilderListener
 *
 * @author speter555
 *
 */
public class ProjectRestClientBuilderListener extends DefaultRestClientBuilderListener {

    /**
     * Default constructor
     */
    public ProjectRestClientBuilderListener() {
        super();
    }

    @Override
    public void onNewBuilder(RestClientBuilder builder) {
        super.onNewBuilder(builder);
    }
}
