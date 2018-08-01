package com.woodside.ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseUiTest {

    @BeforeSuite
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1080x768";
        Configuration.baseUrl = "http://localhost:80";
        RestAssured.port = 80;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
