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

package org.ylzl.eden.spring.boot.security.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.ylzl.eden.spring.boot.security.core.SecurityConstants;

/**
 * JWT 配置属性
 *
 * @author gyl
 * @since 0.0.1
 */
@Getter
@Setter
@ConfigurationProperties(prefix = SecurityConstants.PROP_PREFIX + ".jwt")
public class JwtProperties {

  private final Authentication authentication = new Authentication();

  private final Authorization authorization = new Authorization();

  @Getter
  @Setter
  public static class Authentication {

    private String base64Secret = JwtDefaults.Authentication.base64Secret;

    private String secret = JwtDefaults.Authentication.secret;

    private long tokenValidityInSeconds = JwtDefaults.Authentication.tokenValidityInSeconds;

    private long tokenValidityInSecondsForRememberMe =
        JwtDefaults.Authentication.tokenValidityInSecondsForRememberMe;
  }

  @Getter
  @Setter
  public static class Authorization {

    private String header = JwtDefaults.Authorization.header;

    private final Server server = new Server();

    @Getter
    @Setter
    public static class Server {

      private Boolean enabled = JwtDefaults.Authorization.Server.enabled;
    }
  }
}
