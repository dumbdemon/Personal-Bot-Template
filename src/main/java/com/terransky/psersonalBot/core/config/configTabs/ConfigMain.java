package com.terransky.psersonalBot.core.config.configTabs;

@SuppressWarnings("unused")
public class ConfigMain {
    private String token;
    private String ownerID;
    private String botName;

    ConfigMain() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public String getBotName() {
        return botName;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }
}
