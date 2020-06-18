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

package org.ylzl.eden.spring.boot.cloud.profile;

import com.netflix.zuul.ZuulFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.ylzl.eden.spring.boot.cloud.configserver.ConfigServerProperties;
import org.ylzl.eden.spring.boot.cloud.profile.endpoint.ProfileEndpoint;

/**
 * Profile 端点自动配置
 *
 * @author gyl
 * @since 1.0.0
 */
@ConditionalOnBean({RouteLocator.class, DiscoveryClient.class})
@ConditionalOnClass(ZuulFilter.class)
@Slf4j
@Configuration
public class ProfileEndpointAutoConfiguration {

  private static final String MSG_AUTOWIRED_PROFILE_ENDPOINT = "Autowired Profile Endpoint";

  @ConditionalOnAvailableEndpoint
  @ConditionalOnMissingBean
  @Bean
  public ProfileEndpoint profileEndpoint(
      Environment env,
      ProfileProperties profileProperties,
      ConfigServerProperties configServerProperties) {
    log.debug(MSG_AUTOWIRED_PROFILE_ENDPOINT);
    return new ProfileEndpoint(env, profileProperties, configServerProperties);
  }
}
