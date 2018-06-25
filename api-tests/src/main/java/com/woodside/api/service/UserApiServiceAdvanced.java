package com.woodside.api.service;

import com.woodside.api.ApiResponse;
import com.woodside.api.entity.User;
import groovy.util.logging.Log;
import groovy.util.logging.Slf4j;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.http.ContentType.*;

@lombok.extern.slf4j.Slf4j
public class UserApiServiceAdvanced {

    private RequestSpecification given(){
        List<Filter> filters = new ArrayList<>();
      if(Boolean.valueOf(System.getProperty("enablelogging", "false"))) {
          filters.add(new RequestLoggingFilter());
          filters.add(new RequestLoggingFilter());
      }

      filters.add(new AllureRestAssured());

        return RestAssured.given()
                .contentType(JSON)
                .filters(filters);
    }

    @Step("Register user")
    public ApiResponse registerUser(User user) {
        log.info("Request header {}", user);

        Response response =  given()
                .body(user)
                .when()
                .post( "register")
                .then()
                .extract().response();
        return new ApiResponse(response);
    }
}
