/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ylzl.eden.data.duplicate.builder;

import org.ylzl.eden.data.duplicate.config.DuplicateFilterConfig;

/**
 * 数据去重过滤构建器抽象
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.x
 */
public abstract class AbstractDuplicateFilterBuilder implements DuplicateFilterBuilder {

	private DuplicateFilterConfig config = new DuplicateFilterConfig();

	/**
	 * 设置数据去重过滤配置
	 *
	 * @param config 数据去重过滤配置
	 * @return DataDuplicateFilterBuilder
	 */
	@Override
	public DuplicateFilterBuilder config(DuplicateFilterConfig config) {
		this.config = config;
		return this;
	}

	/**
	 * 获取数据去重过滤配置
	 *
	 * @return 数据去重过滤配置
	 */
	protected DuplicateFilterConfig getConfig() {
		return config;
	}
}
