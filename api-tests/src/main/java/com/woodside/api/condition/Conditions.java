package com.woodside.api.condition;

import org.hamcrest.Matcher;

public class Conditions {
    public static StatusCodeConditions statusCode(int statusCode) {
        return new StatusCodeConditions(statusCode);
    }

    public static BodyFieldConditions bodyField(String jsonPath, Matcher matcher) {
        return new BodyFieldConditions(jsonPath, matcher);
    }
}
