package com.ecommerce.httpclient;

import com.ecommerce.exception.RestHttpClientException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created by jmoore2 on 5/16/17.
 */
public class RestHttpClient {

    private final HttpRequest httpRequest;

    public RestHttpClient(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public <T> T getRequestDeserializeToClass(Class<T> classToDeserializeTo) {
        return deserializeHttpResponseToClass(getResponseEntity(HttpMethod.GET),
                classToDeserializeTo);
    }

    public <T> List<T> getRequestDeserializeToClassList(Class<T> classToDeserializeTo) {
        return deserializeHttpResponseToClassList(getResponseEntity(HttpMethod.GET),
                classToDeserializeTo);
    }

    public <T> T postRequestDeserializeToClass(Class<T> classToDeserializeTo) {
        return deserializeHttpResponseToClass(getResponseEntity(HttpMethod.POST),
                classToDeserializeTo);
    }

    public <T> List<T> postRequestDeserializeToClassList(Class<T> classToDeserializeTo) {
        return deserializeHttpResponseToClassList(getResponseEntity(HttpMethod.POST),
                classToDeserializeTo);
    }

    //Exposing for retrieving raw data (i.e. files)
    public byte[] getResponseEntity(HttpMethod method) {
        ResponseEntity<byte[]> responseEntity = getRestTemplate()
                .exchange(httpRequest.getDecodedUrl(), method,
                        httpRequest.getHttpEntity(), byte[].class);
        return responseEntity.getBody();
    }

    private RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(
                getHttpClientWithTrustedCerts()));
        restTemplate.setErrorHandler(new RestHttpClientErrorHandler());
        return restTemplate;
    }

    private static CloseableHttpClient getHttpClientWithTrustedCerts() {
        HttpClientBuilder clientBuilder = HttpClients.custom().setSSLSocketFactory(trustAllCerts());
        return clientBuilder.build();
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

    private ObjectMapper getObjectMapper() {
        return new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private <T> List<T> deserializeHttpResponseToClassList(byte[] response,
                                                           Class<T> classToDeserializeTo) {
        try {
            return getObjectMapper().readValue(response, TypeFactory.defaultInstance()
                    .constructCollectionType(List.class, classToDeserializeTo));
        } catch (IOException e) {
            throw new RestHttpClientException("Could not deserialize to the following class: "
                    + classToDeserializeTo, e);
        }
    }

    private <T> T deserializeHttpResponseToClass(byte[] response, Class<T> classToDeserializeTo) {
        try {
            return getObjectMapper().readValue(response, classToDeserializeTo);
        } catch (IOException e) {
            throw new RestHttpClientException("Could not deserialize to the following class: "
                    + classToDeserializeTo, e);
        }
    }
}
