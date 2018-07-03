package com.woodside.ui.modal;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.woodside.api.entity.User;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class RegisterModal {
    private SelenideElement userName = $("#register-username-modal");
    private SelenideElement firstName = $("#register-username-modal");
    private SelenideElement lastName = $("#register-last-modal");
    private SelenideElement email = $("#register-email-modal");
    private SelenideElement password = $("#register-email-modal");
    private SelenideElement registerBtn = $("#register-modal div.modal-body button");

    public void registerAs(User user){
        log.info("Registry user {}", user);
        userName.setValue(user.getUsername());
        firstName.setValue(user.getFirstName());
        lastName.setValue(user.getLastName());
        email.setValue(user.getEmail());
        password.setValue(user.getPassword());
        registerBtn.click();
    }
}
