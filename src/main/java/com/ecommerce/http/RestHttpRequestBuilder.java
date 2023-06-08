package com.ecommerce.http;

import com.ecommerce.exception.RestHttpClientException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.builder.Builder;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;

import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class RestHttpRequestBuilder {

    private final HttpRequestBase httpRequestBase;
    private final HttpClientBuilder httpClientBuilder;
    private HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase;

    private RestHttpRequestBuilder(HttpRequestBase httpRequestBase,
                                   HttpClientBuilder httpClientBuilder,
                                   HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase) {
        this.httpRequestBase = httpRequestBase;
        this.httpClientBuilder = httpClientBuilder;
        this.httpEntityEnclosingRequestBase = httpEntityEnclosingRequestBase;
    }

    public HttpRequestBase getHttpRequestBase() {
        return httpRequestBase;
    }

    public HttpClientBuilder getHttpClientBuilder() {
        return httpClientBuilder;
    }

    public HttpEntityEnclosingRequestBase getHttpEntityEnclosingRequestBase() {
        return httpEntityEnclosingRequestBase;
    }

    public static class RestHttpRequest implements Builder<RestHttpRequestBuilder> {

        private HttpRequestBase httpRequestBase;
        private HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        private HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase;

        RestHttpRequest(HttpRequestBase httpRequestBase) {
            this.httpRequestBase = httpRequestBase;
        }

        RestHttpRequest(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase) {
            this.httpEntityEnclosingRequestBase = httpEntityEnclosingRequestBase;
        }

        public static RestHttpRequest buildGetRequest(String uri) {
            HttpRequestBase httpRequestBase = new HttpGet(uri);
            return new RestHttpRequest(httpRequestBase);
        }

        public static RestHttpRequest buildPostRequest(String uri) {
            HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase = new HttpPost(uri);
            return new RestHttpRequest(httpEntityEnclosingRequestBase);
        }

        public RestHttpRequest addBasicCredentials(String username, String password) {
            httpRequestBase.addHeader("Authorization", "Basic " + getAuthorization(username, password));
            return this;
        }

        public RestHttpRequest addApplicationJsonContentType() {
            httpRequestBase.setHeader("Content-Type", "application/json");
            return this;
        }

        public RestHttpRequest addHeader(String key, String value) {
            httpRequestBase.setHeader(key, value);
            return this;
        }

        public RestHttpRequest addAllHeaders(Map<String, String> headers) {
            headers.forEach((k, v) -> httpRequestBase.setHeader(k, v));
            return this;
        }

        public RestHttpRequest trustAllCertifications() {
            httpClientBuilder.setSSLSocketFactory(trustAllCerts());
            return this;
        }

        public RestHttpRequest addHttpEntity(HttpEntity httpEntity) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
            return this;
        }

        private static SSLConnectionSocketFactory trustAllCerts() {
            SSLContextBuilder builder = new SSLContextBuilder();
            try {
                builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
                return new SSLConnectionSocketFactory(builder.build());
            } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
                throw new RestHttpClientException("Could not successfully trust all certificates", e);
            }
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
        public RestHttpRequestBuilder build() {
            return new RestHttpRequestBuilder(
                    httpRequestBase,
                    httpClientBuilder,
                    httpEntityEnclosingRequestBase);
        }
    }
}
