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

package org.ylzl.eden.common.cache.exception;

import org.ylzl.eden.commons.lang.MessageFormatUtils;

import java.util.concurrent.Callable;

/**
 * 加载 Value 异常
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
public class ValueRetrievalException extends RuntimeException {

	public ValueRetrievalException(Object key, Callable<?> loader, Throwable ex) {
		super(MessageFormatUtils.format("Value for key '{}' could not be loaded using '{}'", key, loader), ex);
	}
}
