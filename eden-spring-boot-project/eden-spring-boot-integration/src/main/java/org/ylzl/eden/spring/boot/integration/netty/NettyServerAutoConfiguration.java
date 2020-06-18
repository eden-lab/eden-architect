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

package org.ylzl.eden.spring.boot.integration.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.ylzl.eden.spring.boot.commons.collections.CollectionUtils;
import org.ylzl.eden.spring.boot.integration.core.IntegrationConstants;
import org.ylzl.eden.spring.boot.integration.netty.bootstrap.NettyServer;

import java.util.List;

/**
 * Netty 服务端自动配置
 *
 * @author gyl
 * @since 1.0.0
 */
@ConditionalOnClass(ServerBootstrap.class)
@ConditionalOnExpression(NettyServerAutoConfiguration.EXP_NETTY_SERVER_ENABLED)
@EnableConfigurationProperties(NettyProperties.class)
@Slf4j
@Configuration
public class NettyServerAutoConfiguration {

  public static final String EXP_NETTY_SERVER_ENABLED =
      "${" + IntegrationConstants.PROP_PREFIX + ".netty.server.enabled:false}";

  private final NettyProperties.Server properties;

  public NettyServerAutoConfiguration(NettyProperties properties) {
    this.properties = properties.getServer();
  }

  @ConditionalOnMissingBean
  @Bean
  public NettyServer nettyServer(
      @Autowired(required = false) List<ChannelHandler> channelHandlers,
      @Autowired(required = false) List<ChannelFutureListener> channelFutureListeners) {
    NettyServer nettyServer =
        new NettyServer(properties.getName(), properties.getHost(), properties.getPort());
    if (properties.getBossThreads() != null) {
      nettyServer.setBossThreads(properties.getBossThreads());
    }
    if (properties.getWorkerThreads() != null) {
      nettyServer.setWorkerThreads(properties.getWorkerThreads());
    }
    if (CollectionUtils.isNotEmpty(channelHandlers)) {
      nettyServer.addAllChannelHandlers(channelHandlers);
    }
    if (CollectionUtils.isNotEmpty(channelFutureListeners)) {
      nettyServer.addAllChannelFutureListeners(channelFutureListeners);
    }
    if (properties.getAutoStartup()) {
      nettyServer.setAutoStartup(properties.getAutoStartup());
    }
    return nettyServer;
  }
}
