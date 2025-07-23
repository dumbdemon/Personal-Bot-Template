package com.terransky.psersonalBot.core.config.api;

@SuppressWarnings("unused")
public class APIToken {

    private String token;

    protected APIToken() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
