package com.woodside.api.tests.brutal;


import com.woodside.api.entity.User;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class UserApiTests {
    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "";
    }


    @Test
    void testCanRegisterAsValidUser() {
        //Given
        User user = new User().setPassword("test").setEmail("set").setUsername("test");

        //When
                RestAssured.given()
                .body(user)
                .when()
                .post("register")
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", not(not(isEmptyOrNullString())));

        //Then

    }
}
