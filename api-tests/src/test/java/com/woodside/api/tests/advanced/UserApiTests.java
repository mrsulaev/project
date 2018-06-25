package com.woodside.api.tests.advanced;


import com.woodside.api.ApiResponse;
import com.woodside.api.entity.User;
import com.woodside.api.service.UserApiServiceAdvanced;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static com.woodside.api.Conditions.bodyField;
import static com.woodside.api.Conditions.statusCode;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;


public class UserApiTests {

    private UserApiServiceAdvanced userApiService = new UserApiServiceAdvanced();

    static Collection<Object[]> user() {
        return Arrays.asList(new Object[][]{
                {"testLastName", "testFirstName", "testUsername", "test@email.com", "tespwd"}
        });
    }

    @BeforeAll
    static void setUp() {
        RestAssured.port = 80;
    }

    @Test
    void testCanRegisterAsValidUser() {
        //Given
        User user = new User()
                .setLastName("123123123")
                .setFirstName("123123213")
                .setPassword("test")
                .setEmail("set")
                .setUsername("test");
        //When
        ApiResponse response = userApiService.registerUser(user);

        //Then
        response.shouldHave(statusCode(200));
        response.shouldHave(bodyField("id", not(isEmptyOrNullString())));

    }

    @ParameterizedTest()
    @DisplayName("Try to register not uniq user")
    @MethodSource(value = "user")
    void testCanNotRegisterAsValidUser(String lastName, String firstName, String userName, String email, String pwd) {
        //Given
        User user = new User()
                .setLastName(lastName)
                .setFirstName(firstName)
                .setUsername(userName)
                .setEmail(email)
                .setPassword(pwd);

        //When
        ApiResponse response = userApiService.registerUser(user);

        //Then
        response.shouldHave(statusCode(500));

    }
}
