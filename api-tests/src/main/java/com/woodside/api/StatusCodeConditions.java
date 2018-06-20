package com.woodside.api;

import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StatusCodeConditions extends Condition {

    private int statusCode;

    public StatusCodeConditions(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public void check(Response response) {
        assertThat(response.statusCode(), equalTo(statusCode));

    }
}
