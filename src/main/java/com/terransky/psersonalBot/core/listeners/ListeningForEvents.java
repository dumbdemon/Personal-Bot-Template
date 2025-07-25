package com.terransky.psersonalBot.core.listeners;

import com.terransky.psersonalBot.InteractionsHandler;
import com.terransky.psersonalBot.PersonalBot;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.GatewayPingEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.events.session.SessionDisconnectEvent;
import net.dv8tion.jda.api.events.session.SessionInvalidateEvent;
import net.dv8tion.jda.api.events.session.SessionResumeEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.*;

public class ListeningForEvents extends ListenerAdapter {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ListeningForEvents.class);

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        JDA jda = event.getJDA();
        InteractionsHandler.Commands commands = new InteractionsHandler.Commands();

        jda.updateCommands()
            .addCommands(commands.getCommandData())
            .queue(
                commandsQueue -> {
                    log.info("{} commands loaded successfully.", commandsQueue.size());
                    PersonalBot.displaySystemMessage(String.format("%s commands loaded successfully.", commandsQueue.size()), TrayIcon.MessageType.INFO, log);
                },
                err -> {
                    log.error("Unable to load commands.", err);
                    PersonalBot.displaySystemMessage("Unable to load commands. Please see logs for details.", TrayIcon.MessageType.ERROR, log);
                }
            );

        createInviteLinkFile(jda.getInviteUrl());
    }

    @Override
    public void onSessionDisconnect(@NotNull SessionDisconnectEvent event) {
        if (PersonalBot.getConfig().getLogging().getConnection().isConsole())
            log.warn("Disconnected from Discord.");
        if (PersonalBot.getConfig().getLogging().getConnection().isSystem())
            PersonalBot.displaySystemMessage("Disconnected from Discord.", TrayIcon.MessageType.WARNING, log);
    }

    @Override
    public void onSessionResume(@NotNull SessionResumeEvent event) {
        if (PersonalBot.getConfig().getLogging().getConnection().isConsole())
            log.warn("Reconnected to Discord.");
        if (PersonalBot.getConfig().getLogging().getConnection().isSystem())
            PersonalBot.displaySystemMessage("Reconnected to Discord.", TrayIcon.MessageType.WARNING, log);
    }

    @Override
    public void onSessionInvalidate(@NotNull SessionInvalidateEvent event) {
        if (PersonalBot.getConfig().getLogging().getConnection().isConsole())
            log.warn("Discord invalidated session.");
        if (PersonalBot.getConfig().getLogging().getConnection().isSystem())
            PersonalBot.displaySystemMessage("Discord invalidated session.", TrayIcon.MessageType.WARNING, log);
    }

    @Override
    public void onGatewayPing(@NotNull GatewayPingEvent event) {
        if (PersonalBot.getTrayIcon() != null) {
            PersonalBot.getTrayIcon().setToolTip("Ping - " + event.getNewPing());
        }
    }

    private void createInviteLinkFile(@NotNull String inviteUrl) {
        File inviteLink = new File("inviteLink.txt");
        String inviteLinkText = inviteUrl.replace("&scope=bot", "&integration_type=1&scope=applications.commands");

        if (!inviteLink.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(inviteLink))) {
                writer.write(inviteLinkText);
                log.info("Invite link created at \"{}\"", inviteLink.getAbsolutePath());
            } catch (IOException e) {
                log.error("Unable to create invite link file.", e);
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(inviteLink))) {
                if (inviteLinkText.equals(reader.readLine())) {
                    log.info("Invite link exists at \"{}\". Moving on.", inviteLink.getAbsolutePath());
                } else try (BufferedWriter writer = new BufferedWriter(new FileWriter(inviteLink))) {
                    writer.write(inviteLinkText);
                    log.info("Invite Link file has been modified at \"{}\"", inviteLink.getAbsolutePath());
                }
            } catch (IOException e) {
                log.error("Unable to read invite link file.", e);
            }
        }
    }
}
