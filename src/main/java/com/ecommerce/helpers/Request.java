package com.ecommerce.helpers;

import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

public class Request {

    public Response getResponse(String request){
        com.jayway.restassured.response.Response response =
                given().
                        when().
                        get(request).
                        then().
                        extract().
                        response();
        System.out.println(response.getBody().asString());
        return response;
    }
}
