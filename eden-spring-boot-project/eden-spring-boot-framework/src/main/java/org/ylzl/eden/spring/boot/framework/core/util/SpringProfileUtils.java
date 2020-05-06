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

package org.ylzl.eden.spring.boot.framework.core.util;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;
import org.ylzl.eden.spring.boot.framework.core.ProfileConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring Profile 工具类
 *
 * @author gyl
 * @since 0.0.1
 */
public class SpringProfileUtils {

  private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";

  private SpringProfileUtils() {}

  public static void addDefaultProfile(SpringApplication app) {
    Map<String, Object> defProperties = new HashMap<>();
    defProperties.put(SPRING_PROFILE_DEFAULT, ProfileConstants.SPRING_PROFILE_DEVELOPMENT);
    app.setDefaultProperties(defProperties);
  }

  public static String[] getActiveProfiles(Environment env) {
    String[] profiles = env.getActiveProfiles();
    if (profiles.length == 0) {
      return env.getDefaultProfiles();
    }
    return profiles;
  }
}
