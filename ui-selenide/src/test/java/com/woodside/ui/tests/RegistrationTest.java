package com.woodside.ui.tests;

import com.codeborne.selenide.Condition;
import com.woodside.api.TestData;
import com.woodside.api.entity.User;
import com.woodside.ui.pages.MainPage;
import org.junit.jupiter.api.Test;

public class RegistrationTest {

    @Test
    public void canRegistrationUser() {
        User user = TestData.getUserForTest();

        MainPage.open().registerUser(user)
                .loggedUserLabel.shouldBe(Condition.visible);
    }
}
