package com.terransky.psersonalBot.core.config.configTabs;

@SuppressWarnings("unused")
public class ConfigLoggingLocales {

    private boolean console;
    private boolean system;

    ConfigLoggingLocales() {
    }

    public boolean isConsole() {
        return console;
    }

    public void setConsole(boolean console) {
        this.console = console;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }
}
