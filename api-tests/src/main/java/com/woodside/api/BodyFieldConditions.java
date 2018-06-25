package com.woodside.api;

import io.restassured.response.Response;
import org.hamcrest.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;

public class BodyFieldConditions extends Condition {
    private String jsonPath;
    private Matcher matcher;

    public BodyFieldConditions(String jsonPath, Matcher matcher) {
        this.jsonPath = jsonPath;
        this.matcher = matcher;
    }

    @Override
    public void check(Response response) {
        String s = response.body().jsonPath().get(jsonPath).toString();

        assertThat(s, matcher);
    }
}
