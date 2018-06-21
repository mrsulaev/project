package com.woodside.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class ApiResponse {

    private Response response;

    public ApiResponse(Response response) {
        this.response = response;
    }

    @Step
    public void shouldHave(Condition condition) {
        condition.check(response);
    }

}
