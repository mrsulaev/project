package com.woodside.ui.tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeClass;

public class LogoutRequiredTest extends BaseUiTest {

    @BeforeClass
    public void logout() {
        Selenide.clearBrowserCookies();
    }
}
