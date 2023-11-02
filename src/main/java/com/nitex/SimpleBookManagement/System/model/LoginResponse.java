package com.nitex.SimpleBookManagement.System.model;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String token;
    public LoginResponse(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}
