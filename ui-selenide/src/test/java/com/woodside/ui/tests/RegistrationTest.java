package com.woodside.ui.tests;

import com.codeborne.selenide.Condition;
import com.woodside.api.entity.User;
import com.woodside.ui.pages.MainPage;
import org.junit.jupiter.api.Test;

import static com.woodside.api.TestData.getUserForTest;

public class RegistrationTest extends LogoutRequiredTest {

    @Test
    public void canRegistrationUser() {
        User user = getUserForTest();

        MainPage.open()
                .registerUser(user).loggedUserLabel.shouldBe(Condition.visible);
    }
}
