/*
 * Copyright 2013-2023 the original author or authors.
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

package org.springframework.cloud.gateway.server.mvc;

import java.net.URI;
import java.util.function.BiFunction;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

public interface ProxyExchange {

	RequestBuilder request(ServerRequest serverRequest);

	ServerResponse exchange(Request request);

	interface Request {

		HttpHeaders getHttpHeaders();

		HttpMethod getMethod();

		URI getUri();

		ServerRequest getServerRequest();

		BiFunction<HttpHeaders, ServerResponse, HttpHeaders> getResponseHeadersFilter();

	}

	interface RequestBuilder {

		RequestBuilder headers(HttpHeaders httpHeaders);

		RequestBuilder method(HttpMethod method);

		RequestBuilder uri(URI uri);

		RequestBuilder responseHeadersFilter(
				BiFunction<HttpHeaders, ServerResponse, HttpHeaders> responseHeadersFilter);

		Request build();

	}

}
