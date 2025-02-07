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

package org.ylzl.eden.idempotent.spring.boot.env;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.TimeUnit;

/**
 * 幂等请求配置
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 2.4.13
 */
@Getter
@Setter
@ConfigurationProperties(prefix = IdempotentProperties.PREFIX)
public class IdempotentProperties {

	public static final String PREFIX = "idempotent";

	private final Token token = new Token();

	private final TimeToLive ttl = new TimeToLive();

	@Getter
	@Setter
	public static class Token {

		public static final String PREFIX = "idempotent.token";

		private String prefix = "idempotent:token";

		private long ttl = 10L;

		private TimeUnit timeUnit = TimeUnit.SECONDS;

		private String tokenName = "idempotent";
	}

	@Getter
	@Setter
	public static class TimeToLive {

		public static final String PREFIX = "idempotent.ttl";

		private String prefix = "idempotent:ttl";
	}
}
