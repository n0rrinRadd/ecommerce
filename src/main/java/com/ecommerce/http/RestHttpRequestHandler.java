package com.ecommerce.http;

import com.ecommerce.exception.FileHandleException;
import com.ecommerce.exception.ObjectMapperException;
import com.ecommerce.exception.RestHttpClientException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class RestHttpRequestHandler {

    private final HttpClient client;
    private final HttpRequestBase httpRequestBase;

    public RestHttpRequestHandler(RestHttpRequestBuilder restHttpRequestBuilder) {
        client = restHttpRequestBuilder.getHttpClientBuilder().build();
        HttpRequestBase httpRequestBase = restHttpRequestBuilder.getHttpRequestBase();
        this.httpRequestBase = httpRequestBase == null ?
                restHttpRequestBuilder.getHttpEntityEnclosingRequestBase() : httpRequestBase;
    }

    private HttpResponse executeRequest() {
        try {
            return client.execute(httpRequestBase);
        } catch (IOException e) {
            throw new RestHttpClientException("Could not execute the request: " + e.getLocalizedMessage());
        }
    }

    public RestHttpResponsePageDetails fetchPage() {
        HttpResponse httpResponse = executeRequest();
        try {
            String doc = EntityUtils.toString(httpResponse.getEntity());
            Document document = Jsoup.parse(doc);

            RestHttpResponsePageDetails restHttpResponseDetails = new RestHttpResponsePageDetails();
            restHttpResponseDetails.setDocument(document);

            StatusLine statusLine = httpResponse.getStatusLine();
            restHttpResponseDetails.setStatusCode(statusLine.getStatusCode());
            restHttpResponseDetails.setStatusReason(statusLine.getReasonPhrase());
            return restHttpResponseDetails;
        } catch (IOException e) {
            throw new ObjectMapperException("Could not parse html: Error", e);
        }
    }

    public <T> T fetchResponseAsObject(Class<T> classToDeserializeTo) {
        return deserializeHttpResponseToClass(classToDeserializeTo);
    }

    public <T> List<T> fetchResponseAsObjectList(Class<T> classToDeserializeTo) {
        return deserializeHttpResponseToClassList(classToDeserializeTo);
    }

    public byte[] fetchResponseAsBytes() {
        try {
            return IOUtils.toByteArray(executeRequest().getEntity().getContent());
        } catch (IOException e) {
            throw new FileHandleException("Could not extract contents", e);
        }
    }

    private ObjectMapper getObjectMapper() {
        return new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private <T> List<T> deserializeHttpResponseToClassList(Class<T> classToDeserializeTo) {
        try {
            return getObjectMapper().readValue(executeRequest().getEntity().getContent(), TypeFactory.defaultInstance()
                    .constructCollectionType(List.class, classToDeserializeTo));
        } catch (IOException e) {
            throw new ObjectMapperException("Could not deserialize to the following class: "
                    + classToDeserializeTo, e);
        }
    }

    private <T> T deserializeHttpResponseToClass(Class<T> classToDeserializeTo) {
        try {
            return getObjectMapper().readValue(executeRequest().getEntity().getContent(), classToDeserializeTo);
        } catch (IOException e) {
            throw new ObjectMapperException("Could not map to the following class: "
                    + classToDeserializeTo, e);
        }
    }
}