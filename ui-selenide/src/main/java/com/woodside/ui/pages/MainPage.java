package com.woodside.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.woodside.api.entity.User;
import com.woodside.ui.modal.LoginModal;
import com.woodside.ui.modal.RegisterModal;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class MainPage {

    private SelenideElement loginLink = $("#login > a");
    private SelenideElement registerLink = $("#register > a");
    public SelenideElement loggedUserLabel = $("#howdy > a");
    private LoginModal loginModal = new LoginModal();
    private RegisterModal registerModal = new RegisterModal();

    public static MainPage open(){
        return Selenide.open("/", MainPage.class);
    }

    @Step
    public MainPage loginUser(String userName, String password) {
        log.info("Log in as {}, {}", userName, password);
        loginLink.click();
        loginModal.loginAs(userName, password);
        return this;
    }

    @Step
    public MainPage registerUser(User user){
        log.info("Log in as {}, {}", user.getEmail(), user.getUsername());

        registerLink.click();
        registerModal.registerAs(user);
        return this;
    }
}
