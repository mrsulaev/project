package com.woodside.api.tests.good;


import com.woodside.api.entity.User;
import com.woodside.api.service.UserApiService;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class UserApiTests {

    private UserApiService userApiService = new UserApiService();

    @BeforeAll
    static void setUp() {
        RestAssured.port = 80;
    }


    @Test
    void testCanRegisterAsValidUser() {
        //Given
        User user = new User()
                .setPassword("test")
                .setEmail("set")
                .setUsername("test");


        Response response = userApiService.registerUser(user);

        //When

        assertThat(response.statusCode(), equalTo(200));
        //Then
        String s = response.body().jsonPath().get("id").toString();

        assertThat(s, not(isEmptyOrNullString()));

    }

    @Test
    void testCanNotRegisterAsValidUser() {
        //Given
        User user = new User()
                .setPassword("test")
                .setEmail("set")
                .setUsername("test");

        //When
        Response response = userApiService.registerUser(user);

        //Then
        assertThat(response.statusCode(), equalTo(500));

        String s = response.body().jsonPath().get("id").toString();

        assertThat(s, not(isEmptyOrNullString()));

    }
}
