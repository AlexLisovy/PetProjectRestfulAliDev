package com.restfulApiDev.api.services;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.restfulApiDev.api.properties.BaseUrlLinks.REST_FULL_MAIN_URL;


public class SetupApiService {

    public RequestSpecification baseSetupHeaders(){
        return RestAssured.given()
                .baseUri(REST_FULL_MAIN_URL)
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter());
    }
}
