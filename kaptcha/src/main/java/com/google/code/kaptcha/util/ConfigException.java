/**
 * Copyright 2015-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.code.kaptcha.util;

/**
 * {@link ConfigException} is used to indicate an error in configuration
 * properties.
 */
public class ConfigException extends RuntimeException {
    private static final long serialVersionUID = 6937416954897707291L;

    public ConfigException(String paramName, String paramValue, Throwable cause) {
        super("Invalid value '" + paramValue + "' for config parameter '"
                + paramName + "'.", cause);
    }

    public ConfigException(String paramName, String paramValue, String message) {
        super("Invalid value '" + paramValue + "' for config parameter '"
                + paramName + "'. " + message);
    }
}
