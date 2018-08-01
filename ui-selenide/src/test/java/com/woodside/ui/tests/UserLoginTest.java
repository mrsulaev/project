package com.woodside.ui.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.woodside.api.entity.User;
import com.woodside.api.service.UserApiServiceAdvanced;
import com.woodside.ui.modal.LoginModal;
import com.woodside.ui.pages.MainPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.woodside.api.TestData.getUserForTest;

public class UserLoginTest extends LogoutRequiredTest{

    private UserApiServiceAdvanced apiService = new UserApiServiceAdvanced();

    @Test
    public void testCanLoginAsValidUser() {
        User user = getUserForTest();

        apiService.registerUser(user);

        MainPage.open()
                .loginUser(user.getUsername(), user.getPassword())
                .loggedUserLabel.shouldHave(exactText("Logged in as testUserName"));
    }

    @Test
    public void canRegistrationUser() {
        Selenide.clearBrowserCookies();
        User user = getUserForTest();

        MainPage.open()
                .registerUser(user).loggedUserLabel.shouldBe(Condition.visible);
    }

}
