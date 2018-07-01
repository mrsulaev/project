package com.woodside.api;

import com.woodside.api.entity.User;
import org.apache.commons.lang3.RandomStringUtils;

public class TestData {

    public static User getUserForTest(){
        return new User()
                .setLastName("123123123")
                .setFirstName("123123213")
                .setPassword("test1")
                .setEmail("set1")
                .setUsername(RandomStringUtils.randomAlphanumeric(6));
    }
}
