package com.woodside.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiResponse {

    private Response response;

    public ApiResponse(Response response) {
        this.response = response;
    }

    @Step("Api response should have {0}")
    public void shouldHave(Condition condition) {
        log.info("Api Response should have {}", condition);
        condition.check(response);
    }

}
