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
import org.ylzl.eden.spring.boot.integration.truelicense.manager.customizer.Conditional;
import org.ylzl.eden.spring.boot.integration.truelicense.manager.customizer.ConditionalUtils;

import java.util.List;

/**
 * 许可证校验服务
 *
 * @author gyl
 * @since 0.0.1
 */
@Slf4j
public class LicenseVerify {

  private final LicenseManager licenseManager;

  public LicenseVerify(LicenseManager licenseManager) {
    this.licenseManager = licenseManager;
  }

  public boolean verify() {
    try {
      licenseManager.verify();
    } catch (Exception e) {
      log.error("证书校验无效！异常：{}", e.getMessage(), e);
      return false;
    }
    return true;
  }

  public boolean verify(String key, String value) {
    LicenseContent licenseContent = null;
    try {
      licenseContent = licenseManager.verify();
    } catch (Exception e) {
      log.error("证书校验无效！异常：{}", e.getMessage(), e);
      return false;
    }
    LicenseContentExtra extra = (LicenseContentExtra) licenseContent.getExtra();
    if (extra != null) {
      List<Conditional> conditionals = extra.getConditionals();
      if (conditionals != null && !conditionals.isEmpty()) {
        for (Conditional conditional : conditionals) {
          if (conditional.getKey().equals(key)) {
            return ConditionalUtils.validate(conditional, value);
          }
        }
      }
    }
    return true;
  }
}
