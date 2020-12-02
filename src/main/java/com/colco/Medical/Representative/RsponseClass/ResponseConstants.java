package com.colco.Medical.Representative.RsponseClass;

public enum ResponseConstants {

    BAD_REQUEST(200, "BAD_REQUEST"),
    BAD_CREDENTIALS(201, "BAD_CREDENTIALS");

    private final int code;

    private final String desc;

    ResponseConstants(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}