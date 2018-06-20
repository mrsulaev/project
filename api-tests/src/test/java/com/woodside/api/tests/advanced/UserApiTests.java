package com.woodside.api.tests.advanced;


import com.woodside.api.ApiResponse;
import com.woodside.api.entity.User;
import com.woodside.api.service.UserApiServiceAdvanced;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.woodside.api.Conditions.bodyField;
import static com.woodside.api.Conditions.statusCode;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class UserApiTests {

    private UserApiServiceAdvanced userApiService = new UserApiServiceAdvanced();

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "";
    }


    @Test
    void testCanRegisterAsValidUser() {
        //Given
        User user = new User()
                .setPassword("test")
                .setEmail("set")
                .setUsername("test");

        //When
        ApiResponse response = userApiService.registerUser(user);

        //Then
        response.shouldHave(statusCode(200));
        response.shouldHave(bodyField("id", not(isEmptyOrNullString())));

    }

    @Test
    void testCanNotRegisterAsValidUser() {
        //Given
        User user = new User()
                .setPassword("test")
                .setEmail("set")
                .setUsername("test");

        //When
        ApiResponse response = userApiService.registerUser(user);

        //Then
        response.shouldHave(statusCode(500));

        response.shouldHave(bodyField("id", isEmptyOrNullString()));

    }
}
