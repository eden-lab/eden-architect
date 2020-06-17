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

package org.ylzl.eden.spring.boot.security.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.ylzl.eden.spring.boot.security.web.authentication.UnauthorizedEntryPointAdapter;

/**
 * Web 安全自动配置
 *
 * @author gyl
 * @since 1.0.0
 */
@Slf4j
@Configuration
public class WebSecurityAutoConfiguration {

  public static final String MSG_INJECT_AUTH_ENTRY_POINT =
      "Autowired AuthenticationEntryPoint (UnauthorizedEntryPointAdapter)";

  @ConditionalOnMissingBean
  @Bean
  public AuthenticationEntryPoint authenticationEntryPoint() {
    log.debug(MSG_INJECT_AUTH_ENTRY_POINT);
    return new UnauthorizedEntryPointAdapter();
  }
}
