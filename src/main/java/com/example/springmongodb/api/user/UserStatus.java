package com.example.springmongodb.api.user;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum UserStatus {


    ACTIVE(1, "ACTIVE"),

    DELETED(2, "DELETED"),

    INACTIVE(3, "INACTIVE"),

    LOCKED(4, "LOCKED");


    private final Integer code;
    private final String userStatus;

    UserStatus(Integer code, String userStatus) {
        this.code = code;
        this.userStatus = userStatus;
    }

    public Integer getCode() {
        return code;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public static Map<Integer, UserStatus> getResponseStatusCodeMap() {
        return RESPONSE_STATUS_CODE_MAP;
    }

    private static final Map<Integer, UserStatus> RESPONSE_STATUS_CODE_MAP = Arrays
            .stream(UserStatus.values())
            .collect(Collectors.toMap(UserStatus::getCode, Function.identity()));

}
