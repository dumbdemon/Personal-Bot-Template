package com.terransky.psersonalBot.core.config;

import com.terransky.psersonalBot.core.config.configTabs.ConfigAPI;
import com.terransky.psersonalBot.core.config.configTabs.ConfigLogging;
import com.terransky.psersonalBot.core.config.configTabs.ConfigMain;
import com.terransky.psersonalBot.core.config.configTabs.ConfigOther;

@SuppressWarnings("unused")
public class Config {
    private ConfigMain main;
    private ConfigLogging logging;
    private ConfigAPI api;
    private ConfigOther other;

    Config() {
    }

    public ConfigMain getMain() {
        return main;
    }

    public void setMain(ConfigMain main) {
        this.main = main;
    }

    public ConfigLogging getLogging() {
        return logging;
    }

    public void setLogging(ConfigLogging logging) {
        this.logging = logging;
    }

    public ConfigAPI getApi() {
        return api;
    }

    public void setApi(ConfigAPI api) {
        this.api = api;
    }

    public ConfigOther getOther() {
        return other;
    }

    public void setOther(ConfigOther other) {
        this.other = other;
    }
}
