package com.woodside.api;

import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class ApiResponse {

    private Response response;

    public ApiResponse(Response response) {
        this.response= response;
    }


    public void shouldHave(Condition condition){
        condition.check(response);
    }

}
