package com.terransky.psersonalBot.core.config.configTabs;

@SuppressWarnings("unused")
public class ConfigLogging {
    private ConfigLoggingLocales commands;
    private ConfigLoggingLocales connection;
    private ConfigLoggingLocales buttons;
    private ConfigLoggingLocales modal;
    private ConfigLoggingLocales selectMenus;

    ConfigLogging() {
    }

    public ConfigLoggingLocales getCommands() {
        return commands;
    }

    public void setCommands(ConfigLoggingLocales commands) {
        this.commands = commands;
    }

    public ConfigLoggingLocales getConnection() {
        return connection;
    }

    public void setConnection(ConfigLoggingLocales connection) {
        this.connection = connection;
    }

    public ConfigLoggingLocales getButtons() {
        return buttons;
    }

    public void setButtons(ConfigLoggingLocales buttons) {
        this.buttons = buttons;
    }

    public ConfigLoggingLocales getModal() {
        return modal;
    }

    public void setModal(ConfigLoggingLocales modal) {
        this.modal = modal;
    }

    public ConfigLoggingLocales getSelectMenus() {
        return selectMenus;
    }

    public void setSelectMenus(ConfigLoggingLocales selectMenus) {
        this.selectMenus = selectMenus;
    }
}
