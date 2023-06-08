package com.ecommerce.httpclient;


import com.ecommerce.exception.RestHttpClientException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.apache.logging.log4j.core.util.Builder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jmoore2 on 5/16/17.
 */
public class HttpRequest {

    private String baseUrl;
    private String pathName;
    private HttpHeaders httpHeader;
    private Map<String, Object> queryParameters;
    private Object requestBodyToPost;

    private HttpRequest(String baseUrl,
                        String pathName,
                        HttpHeaders httpHeader,
                        Map<String, Object> queryParameters,
                        Object requestBodyToPost) {
        this.baseUrl = baseUrl;
        this.pathName = pathName;
        this.httpHeader = httpHeader;
        this.queryParameters = queryParameters;
        this.requestBodyToPost = requestBodyToPost;
    }

    private String getBaseUrl() {
        return baseUrl;
    }

    private String getPathName() {
        return (pathName != null) ? pathName : StringUtils.EMPTY;
    }

    private Map<String, Object> getQueryParameters() {
        return queryParameters;
    }

    private Object getRequestBodyToPost() {
        return requestBodyToPost;
    }

    public HttpHeaders getHttpHeader() {
        return httpHeader;
    }

    public String getDecodedUrl() {
        URI uri = getUri();
        try {
            return URLDecoder.decode(uri.toString(), StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RestHttpClientException(
                    "Could not successfully decode the following url: " + uri.toString(), e);
        }
    }

    private URI getUri() {
        try {
            URIBuilder builder = new URIBuilder(getBaseUrl() + getPathName());
            if (getQueryParameters() != null) {
                for (Map.Entry<String, Object> param : getQueryParameters().entrySet()) {
                    String value = (param.getValue() == null) ? null :
                            String.valueOf(param.getValue());
                    builder.addParameter(param.getKey(), value);
                }
            }
            return builder.build();
        } catch (URISyntaxException e) {
            throw new RestHttpClientException("Could not successfully build URI", e);
        }
    }

    public HttpEntity<Object> getHttpEntity() {
        if (getHttpHeader() == null && getRequestBodyToPost() != null) {
            return new HttpEntity<>(getRequestBodyToPost());
        } else if (getHttpHeader() != null && getRequestBodyToPost() == null) {
            return new HttpEntity<>(getHttpHeader());
        } else {
            return new HttpEntity<>(requestBodyToPost, httpHeader);
        }
    }

    public static class HttpRequestBuilder implements Builder<HttpRequest> {

        private String baseUrl;
        private String pathName;
        private HttpHeaders httpHeaders = new HttpHeaders();
        private Map<String, Object> queryParameters = new HashMap<>();
        private Object requestBodyToPost;
        private HttpEntity<Object> httpEntity;

        private static final String BEARER_AUTHENTICATION_HEADER = "Bearer";
        private static final String BASIC_AUTHENTICATION_HEADER = "Basic";

        public HttpRequestBuilder(String baseUrl) {
            this.baseUrl = baseUrl;
        }

        public static HttpRequestBuilder createRequestBuilder(String baseUrl) {
            return new HttpRequestBuilder(baseUrl);
        }

        public HttpRequestBuilder withPath(String pathName) {
            this.pathName = pathName;
            return this;
        }

        public HttpRequestBuilder withHeader(String headerName, String headerValue) {
            httpHeaders.add(headerName, headerValue);
            return this;
        }

        public HttpRequestBuilder withBearerAuthorizationHeader(String authorizationToken) {
            String authorizationHeader = BEARER_AUTHENTICATION_HEADER + " " + authorizationToken;
            httpHeaders.add("Authorization", authorizationHeader);
            return this;
        }

        public HttpRequestBuilder withBasicAuthorizationHeader(String username, String password) {
            String authorizationHeader = BASIC_AUTHENTICATION_HEADER
                    + " " + getAuthorization(username, password);
            httpHeaders.add("Authorization", authorizationHeader);
            return this;
        }

        public HttpRequestBuilder withContentTypeMediaTypeJson() {
            this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            return this;
        }

        public HttpRequestBuilder withOctetStream() {
            this.httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return this;
        }

        public HttpRequestBuilder withParams(Map<String, Object> params) {
            queryParameters = params;
            return this;
        }

        public HttpRequestBuilder withQueryParameters(String key, String value) {
            queryParameters.put(key, value);
            return this;
        }

        public HttpRequestBuilder withRequestBodyToPost(Object requestBodyToPost) {
            this.requestBodyToPost = requestBodyToPost;
            return this;
        }

        private String getAuthorization(String user, String password) {
            try {
                byte[] bytes = Base64.encodeBase64((user + ":" + password)
                        .getBytes("UTF-8"));
                return new String(bytes);
            } catch (UnsupportedEncodingException e) {
                throw new RestHttpClientException(
                        "Could not successfully encode the following password: "
                                + user + " " + password, e);
            }
        }

        @Override
        public HttpRequest build() {
            return new HttpRequest(
                    baseUrl,
                    pathName,
                    httpHeaders,
                    queryParameters,
                    requestBodyToPost);
        }
    }
}

