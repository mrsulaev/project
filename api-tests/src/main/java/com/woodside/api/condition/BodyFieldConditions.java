package com.woodside.api.condition;

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
    public String toString() {
        return "BodyFieldConditions{" + jsonPath + '\'' + matcher + '}';
    }

    @Override
    public void check(Response response) {
        assertThat(response.body().jsonPath().get(jsonPath).toString(), matcher);
    }
}
