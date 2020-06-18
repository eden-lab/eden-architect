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

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.ylzl.eden.spring.boot.integration.core.IntegrationConstants;
import org.ylzl.eden.spring.boot.integration.netty.channel.ChannelOptions;

/**
 * Metrics 配置属性
 *
 * @author gyl
 * @since 1.0.0
 */
@Getter
@Setter
@ConfigurationProperties(prefix = IntegrationConstants.PROP_PREFIX + ".netty")
public final class NettyProperties {

  private final Client client = new Client();

  private final Server server = new Server();

  @Getter
  @Setter
  public static final class Client {

    private Boolean enabled = NettyDefaults.Client.enabled;

    private Boolean autoStartup = NettyDefaults.Client.autoStartup;

    private String name;

    private String host = NettyDefaults.Client.host;

    private Integer port = NettyDefaults.Client.port;

    private Integer channelThreads = NettyDefaults.Client.channelThreads;
  }

  @Getter
  @Setter
  public static final class Server {

    private Boolean enabled = NettyDefaults.Server.enabled;

    private Boolean autoStartup = NettyDefaults.Server.autoStartup;

    private String name;

    private String host = NettyDefaults.Server.host;

    private Integer port = NettyDefaults.Server.port;

    private Integer bossThreads = NettyDefaults.Server.bossThreads;

    private Integer workerThreads = NettyDefaults.Server.workerThreads;

    @NestedConfigurationProperty private ChannelOptions channelOptions;

    @NestedConfigurationProperty private ChannelOptions childChannelOptions;
  }
}
