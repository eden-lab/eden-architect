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

package org.ylzl.eden.spring.boot.framework.mail;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.mail.Session;

/**
 * 邮件发送自动配置
 *
 * @author gyl
 * @since 0.0.1
 */
@EnableConfigurationProperties(EnhancedMailProperties.class)
@Configuration
public class EnhancedMailSenderAutoConfiguration extends MailSenderAutoConfiguration {

  public EnhancedMailSenderAutoConfiguration(
      EnhancedMailProperties properties, ObjectProvider<Session> sessionProvider) {
    super(properties, sessionProvider);
  }
}
