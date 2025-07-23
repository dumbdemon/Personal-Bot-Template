package com.terransky.psersonalBot.core.config.api;

@SuppressWarnings("unused")
public class APIUserPassword extends APIToken {

    private String username;

    protected APIUserPassword() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
