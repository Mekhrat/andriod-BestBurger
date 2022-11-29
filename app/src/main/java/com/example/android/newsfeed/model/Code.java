package com.example.android.newsfeed.model;

import java.util.Date;

public class Code {
    private String email;
    private String code;

    public Code(String email, String code) {
        this.email = email;
        this.code = code;
    }

    public Code() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
