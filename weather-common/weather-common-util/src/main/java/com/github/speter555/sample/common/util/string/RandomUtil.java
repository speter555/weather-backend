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
package com.github.speter555.sample.common.util.string;

/**
 * Random generating utilities.
 *
 * @author speter555
 * @since 0.1.0
 */
public class RandomUtil extends hu.icellmobilsoft.coffee.tool.utils.string.RandomUtil {

    /**
     * Private constructor
     */
    private RandomUtil() {
        // Default constructor for java 21
    }

    /**
     * Generates random 48 characters long token.
     *
     * @return token string
     */
    public static String generateToken() {
        return hu.icellmobilsoft.coffee.tool.utils.string.RandomUtil.generateToken();
    }
}
