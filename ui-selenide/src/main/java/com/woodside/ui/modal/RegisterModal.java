package com.woodside.ui.modal;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegisterModal {
    private SelenideElement userName = $("#register-username-modal");
    private SelenideElement firstName = $("#register-username-modal");
    private SelenideElement lastName = $("#register-last-modal");
    private SelenideElement email = $("#register-email-modal");
    private SelenideElement password = $("#register-email-modal");
    private SelenideElement registerBtn = $("#register-modal div.modal-body button");

    public void registerAs(){
        userName.setValue("test");
    }
}
