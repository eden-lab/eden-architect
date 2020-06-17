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

package org.ylzl.eden.spring.boot.data.audit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.ylzl.eden.spring.boot.data.audit.event.PersistentAuditEvent;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 持久化审计事件数据仓库接口
 *
 * @author gyl
 * @since 1.0.0
 */
@NoRepositoryBean
public interface PersistenceAuditEventRepository<
        T extends PersistentAuditEvent, String extends Serializable>
    extends JpaRepository<T, String> {

  List<T> findByPrincipal(String principal);

  List<T> findByEventDateAfter(Date after);

  List<T> findByPrincipalAndEventDateAfter(String principal, Date after);

  List<T> findByPrincipalAndEventDateAfterAndEventType(String principal, Date after, String type);

  Page<T> findAllByEventDateBetween(Date fromDate, Date toDate, Pageable pageable);
}
