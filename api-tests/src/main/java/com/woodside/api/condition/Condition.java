package com.woodside.api.condition;

import io.restassured.response.Response;

public abstract class Condition {
    public abstract void check(Response response);
}
