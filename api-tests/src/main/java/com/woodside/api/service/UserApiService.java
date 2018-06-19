package com.woodside.api.service;

import com.woodside.api.entity.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.not;

public class UserApiService {

    private RequestSpecification given(){
        return RestAssured.given();
    }


    public Response registerUser(User user) {
        return given().body(user)
                .when()
                .post("register")
                .then().extract().response();
    }
}
