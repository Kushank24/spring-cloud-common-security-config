/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cloud.common.security;

import org.springframework.cloud.common.security.support.OnSecurityDisabled;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

/**
 * Spring Security {@link WebSecurityConfigurer} simply ingoring all paths
 * conditionally if security is not enabled.
 *
 * @author Janne Valkealahti
 *
 */
@Configuration
@Conditional(OnSecurityDisabled.class)
public class IgnoreAllSecurityConfiguration implements WebSecurityConfigurer<WebSecurity> {

	@Override
	public void init(WebSecurity builder) throws Exception {
	}

	@Override
	public void configure(WebSecurity builder) throws Exception {
		builder.ignoring().antMatchers("/**");
	}
}