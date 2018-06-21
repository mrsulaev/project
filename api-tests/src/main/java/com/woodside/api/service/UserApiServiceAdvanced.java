package com.woodside.api.service;

import com.woodside.api.ApiResponse;
import com.woodside.api.entity.User;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserApiServiceAdvanced {

    private RequestSpecification given(){
        return RestAssured.given();
    }

    @Step("Register user")
    public ApiResponse registerUser(User user) {
        Response response =  given()
                .log().body()
                .body(user)
                .when()
                .post( "register")
                .then()
                .log().ifError()
                .extract().response();
        return new ApiResponse(response);
    }
}
