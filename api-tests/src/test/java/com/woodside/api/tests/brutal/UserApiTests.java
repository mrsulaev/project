package com.woodside.api.tests.brutal;


import com.woodside.api.entity.User;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class UserApiTests {
    @BeforeAll
    static void setUp() {
        RestAssured.port = 80;
    }


    @Test
    void testCanRegisterAsValidUser() {
        //Given
        User user = new User().setPassword("test").setEmail("set").setUsername("test");

        //When
                RestAssured.given()
                .body(user)
                .when()
                .post().then()
                        .assertThat().body("id", not(isEmptyOrNullString()));

        //Then

    }
}
