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

package org.ylzl.eden.spring.boot.cloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.ylzl.eden.spring.boot.cloud.web.rest.authentication.AuthorizedClientHttpRequestInterceptor;
import org.ylzl.eden.spring.boot.framework.web.RestAutoConfiguration;
import org.ylzl.eden.spring.boot.security.jwt.JwtProperties;
import org.ylzl.eden.spring.boot.security.oauth2.OAuth2Properties;

import java.util.List;

/**
 * 基于负载均衡的 REST 自动配置
 *
 * @author gyl
 * @since 0.0.1
 */
@AutoConfigureAfter(RestAutoConfiguration.class)
@ConditionalOnClass({RestTemplate.class, LoadBalanced.class})
@Slf4j
@Configuration
public class LoadBalancedRestAutoConfiguration {

  public static final String BEAN_LB_REST_TEMPLATE = "loadBalancedRestTemplate";

  private static final String MSG_INJECT_REST_TEMPLATE = "Autowired loadBalanced RestTemplate";

  @ConditionalOnMissingBean(name = BEAN_LB_REST_TEMPLATE)
  @LoadBalanced
  @Bean
  public RestTemplate loadBalancedRestTemplate(
      ClientHttpRequestFactory clientHttpRequestFactory,
      @Autowired(required = false) OAuth2Properties oAuth2Properties,
      @Autowired(required = false) JwtProperties jwtProperties) {
    log.debug(MSG_INJECT_REST_TEMPLATE);
    RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
    List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
    ClientHttpRequestInterceptor authorizedInterceptor =
        new AuthorizedClientHttpRequestInterceptor(oAuth2Properties, jwtProperties);
    interceptors.add(authorizedInterceptor);
    return restTemplate;
  }
}
