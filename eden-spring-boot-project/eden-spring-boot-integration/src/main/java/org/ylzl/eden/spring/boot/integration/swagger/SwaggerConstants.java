/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ylzl.eden.spring.boot.integration.swagger;

import lombok.experimental.UtilityClass;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.web.Swagger2Controller;

/**
 * Swagger 常量定义
 *
 * @author gyl
 * @since 0.0.1
 */
@UtilityClass
public final class SwaggerConstants {

  public static final String DEFAULT_URL = Swagger2Controller.DEFAULT_URL;

  public static final String RESOURCES_URL = "/swagger-resources";

  public static final String RESOURCES_CONF_URL = RESOURCES_URL + "/configuration";

  public static final String VERSION = DocumentationType.SWAGGER_2.getVersion();
}
