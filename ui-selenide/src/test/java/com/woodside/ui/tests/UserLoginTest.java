package com.woodside.ui.tests;

import com.codeborne.selenide.Configuration;
import com.woodside.api.entity.User;
import com.woodside.api.service.UserApiServiceAdvanced;
import com.woodside.ui.pages.MainPage;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.woodside.api.TestData.getUserForTest;

public class UserLoginTest {

    private UserApiServiceAdvanced apiService = new UserApiServiceAdvanced();

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1080x768";
        Configuration.baseUrl = "http://localhost:80";
        RestAssured.port = 80;
    }

    @Test
    public void testCanLoginAsValidUser() {
        User user = getUserForTest();

        apiService.registerUser(user);

        MainPage.open()
                .loginUser(user.getUsername(), user.getPassword())
                .loggedUserLabel.shouldHave(exactText("Logged in as testUserName"));
    }
}
