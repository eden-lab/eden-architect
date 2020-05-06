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

package org.ylzl.eden.spring.boot.integration.truelicense.manager;

import de.schlichtherle.license.LicenseContent;
import de.schlichtherle.license.LicenseManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StopWatch;
import org.ylzl.eden.spring.boot.commons.lang.time.DateUtils;
import org.ylzl.eden.spring.boot.integration.truelicense.TrueLicenseProperties;

import java.io.File;

/**
 * 许可证安装服务
 *
 * @author gyl
 * @since 0.0.1
 */
@Slf4j
public class LicenseInstall implements InitializingBean {

  private final TrueLicenseProperties trueLicenseProperties;

  private final LicenseManager licenseManager;

  public LicenseInstall(
      TrueLicenseProperties trueLicenseProperties, LicenseManager licenseManager) {
    this.trueLicenseProperties = trueLicenseProperties;
    this.licenseManager = licenseManager;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    log.debug("开始安装证书");
    StopWatch watch = new StopWatch();
    watch.start();
    install();
    watch.stop();
    log.debug("证书安装耗时 {} 毫秒", watch.getTotalTimeMillis());
  }

  public LicenseContent install() throws Exception {
    File file = new File(trueLicenseProperties.getLicensePath());
    LicenseContent licenseContent;
    try {
      licenseManager.uninstall();
      licenseContent = licenseManager.install(file);
    } catch (Exception e) {
      log.error("证书安装失败！异常：{}", e.getMessage(), e);
      throw e;
    }
    log.info(
        "证书安装成功，有效期：{} ～ {}",
        DateUtils.toDateTimeString(licenseContent.getNotBefore()),
        DateUtils.toDateTimeString(licenseContent.getNotAfter()));
    return licenseContent;
  }
}
