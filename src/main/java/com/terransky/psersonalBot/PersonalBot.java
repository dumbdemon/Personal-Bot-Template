package com.terransky.psersonalBot;

import com.terransky.psersonalBot.core.config.Config;
import com.terransky.psersonalBot.core.config.ConfigHandler;
import com.terransky.psersonalBot.core.listeners.InteractionListener;
import com.terransky.psersonalBot.core.listeners.ListeningForEvents;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.FileNotFoundException;

public class PersonalBot {

    private static final String TOKEN;
    private static final SystemTray tray;
    private static final TrayIcon trayIcon;
    private static final Logger log = LoggerFactory.getLogger(PersonalBot.class);

    static {
        TOKEN = getConfig().getMain().getToken();
        if (SystemTray.isSupported()) {
            String botName = PersonalBot.getConfig().getMain().getBotName();
            tray = SystemTray.getSystemTray();
            final PopupMenu popup = new PopupMenu();

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Image image = Toolkit.getDefaultToolkit().createImage(classLoader.getResource("icon.png"));

            trayIcon = new TrayIcon(image, botName + " Icon", popup);
            trayIcon.setImageAutoSize(true);

            MenuItem exitItem = new MenuItem("Shutdown");

            exitItem.addActionListener(e -> {
                log.info("Shutting down bot...");
                tray.remove(trayIcon);
                System.exit(0);
            });

            popup.add(exitItem);

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        } else {
            tray = null;
            trayIcon = null;
        }
    }

    public static void main(String[] args) {
        if (TOKEN == null)
            throw new IllegalArgumentException("Unable to start bot. No bot token was set.");

        JDA jda = JDABuilder.createDefault(TOKEN)
            .build();

        jda.addEventListener(
            new ListeningForEvents(),
            new InteractionListener()
        );
    }

    public static Config getConfig() {
        try {
            return ConfigHandler.getInstance().getConfig();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Unable to load config. Please verify file permissions.", e);
        }
    }

    public static TrayIcon getTrayIcon() {
        return trayIcon;
    }

    public static void displaySystemMessage(String message, TrayIcon.MessageType type, Logger logger) {
        try {
            trayIcon.displayMessage(getConfig().getMain().getBotName(), message, type);
        } catch (NullPointerException e) {
            logger.error("Unable to display tray notification.", e);
        }
    }

    public enum EmbedColor {
        DEFAULT(51, 204, 51),
        ERROR(Color.RED);

        private final Color color;

        EmbedColor(int r, int g, int b) {
            this.color = new Color(r, g, b);
        }

        EmbedColor(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }
    }
}