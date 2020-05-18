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
package org.ylzl.eden.spring.boot.cloud.zuul;

import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Zuul 属性默认值
 *
 * @author gyl
 * @since 1.0.0
 */
@UtilityClass
public final class ZuulDefaults {

  public static class AccessControl {

    public static final boolean enabled = true;

    public static final Map<String, List<String>> authorizedMicroservicesEndpoints =
        Collections.emptyMap();
  }

  public static class RateLimiting {

    public static final String defaultIncludePattern = null;

    public static final int durationInSeconds = 3_600;

    public static final boolean enabled = true;

    public static final long limit = 100_000L;
  }
}
