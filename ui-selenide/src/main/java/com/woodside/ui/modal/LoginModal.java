package com.woodside.ui.modal;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class LoginModal {
    private SelenideElement userNameInput = $("#username-modal");
    private SelenideElement passwordInput = $("#password-modal");
    private SelenideElement loginButton = $("#login-modal  div.modal-body  button");

    public void loginAs(String userName, String pwd){
        userNameInput.setValue(userName);
        passwordInput.setValue(pwd);
        loginButton.click();
    }
}
