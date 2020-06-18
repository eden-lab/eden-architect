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

package org.ylzl.eden.spring.boot.integration.ftpclient;

import org.ylzl.eden.spring.boot.commons.env.CharsetConstants;

/**
 * FTPClient 默认属性
 *
 * @author gyl
 * @since 1.0.0
 */
public class FTPClientDefaults {

  public static final boolean enabled = false;

  public static final String host = null;

  public static final int port = 21;

  public static final String username = null;

  public static final String password = null;

  public static final int connectTimeOut = 5000;

  public static final int dataTimeout = 60000;

  public static final String controlEncoding = CharsetConstants.UTF_8_NAME;

  public static final int controlKeepAliveReplyTimeout = 1000;

  public static final int bufferSize = 2 << 10;

  public static final int fileType = 2;

  public static final boolean useEPSVwithIPv4 = false;

  public static final boolean passiveMode = true;
}
