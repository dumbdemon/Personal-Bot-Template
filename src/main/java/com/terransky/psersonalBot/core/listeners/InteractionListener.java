package com.terransky.psersonalBot.core.listeners;

import com.terransky.psersonalBot.InteractionsHandler;
import com.terransky.psersonalBot.PersonalBot;
import com.terransky.psersonalBot.core.StandardEmbed;
import com.terransky.psersonalBot.core.interactions.*;
import com.terransky.psersonalBot.interactions.buttons.InvalidButton;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.EntitySelectInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class InteractionListener extends ListenerAdapter {
    private static final Logger log = LoggerFactory.getLogger(InteractionListener.class);

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        Optional<SlashCommand> slashCommandOptional = new InteractionsHandler.Commands().getInteraction(event.getName());

        if (slashCommandOptional.isEmpty()) return;

        StandardEmbed standardEmbed = new StandardEmbed(event.getUser());

        SlashCommand slashCommand = slashCommandOptional.get();
        if (PersonalBot.getConfig().getLogging().getCommands().isConsole())
            log.info("Command called [{}]", slashCommand.getName());
        if (PersonalBot.getConfig().getLogging().getCommands().isSystem())
            PersonalBot.displaySystemMessage(String.format("Command called [%s]", slashCommand.getName()), TrayIcon.MessageType.INFO, log);

        try {
            slashCommand.execute(event, standardEmbed);
        } catch (IOException | ExecutionException | InterruptedException e) {
            EmbedBuilder embedBuilder = standardEmbed.getEmbed(PersonalBot.EmbedColor.ERROR)
                .setDescription(String.format("Command [%s] failed to execute.", slashCommand.getName().toUpperCase()));
            log.error("Full command path that triggered error :: [{}]", event.getFullCommandName());
            log.error("With the following exceptions", e);
            if (event.isAcknowledged()) {
                event.getHook().sendMessageEmbeds(embedBuilder.build()).queue();
            } else event.replyEmbeds(embedBuilder.build()).queue();
        }
    }

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        Optional<ButtonComponent> buttonsOptional = new InteractionsHandler.DiscordButtons().getInteraction(event.getButton().getLabel());
        StandardEmbed standardEmbed = new StandardEmbed(event.getUser());

        if (buttonsOptional.isEmpty()) {
            try {
                new InvalidButton().execute(event, standardEmbed);
            } catch (IOException | ExecutionException | InterruptedException e) {
                log.error("Fallback Button Failed :: ", e);
            }
            return;
        }


        ButtonComponent buttonComponent = buttonsOptional.get();
        if (PersonalBot.getConfig().getLogging().getButtons().isConsole())
            log.info("Button called [{}]", buttonComponent.getName());
        if (PersonalBot.getConfig().getLogging().getButtons().isSystem())
            PersonalBot.displaySystemMessage(String.format("Button called [%s]", buttonComponent.getName()), TrayIcon.MessageType.INFO, log);

        try {
            buttonComponent.execute(event, standardEmbed);
        } catch (IOException | ExecutionException | InterruptedException e) {
            EmbedBuilder embedBuilder = standardEmbed.getEmbed(PersonalBot.EmbedColor.ERROR)
                .setDescription(String.format("Button [%s] failed to execute.", buttonComponent.getName().toUpperCase()));
            log.error("Button failed ::", e);
            if (event.isAcknowledged()) {
                event.getHook().sendMessageEmbeds(embedBuilder.build()).queue();
            } else event.replyEmbeds(embedBuilder.build()).queue();
        }
    }

    @Override
    public void onModalInteraction(@NotNull ModalInteractionEvent event) {
        Optional<ModalComponent> modalComponentOptional = new InteractionsHandler.Modals().getInteraction(event.getModalId());

        if (modalComponentOptional.isEmpty()) return;

        StandardEmbed standardEmbed = new StandardEmbed(event.getUser());

        ModalComponent modalComponent = modalComponentOptional.get();
        if (PersonalBot.getConfig().getLogging().getModal().isConsole())
            log.info("Modal called [{}]", modalComponent.getName());
        if (PersonalBot.getConfig().getLogging().getModal().isSystem())
            PersonalBot.displaySystemMessage(String.format("MOdal called [%s]", modalComponent.getName()), TrayIcon.MessageType.INFO, log);

        try {
            modalComponent.execute(event, standardEmbed);
        } catch (IOException | ExecutionException | InterruptedException e) {
            EmbedBuilder embedBuilder = standardEmbed.getEmbed(PersonalBot.EmbedColor.ERROR)
                .setDescription(String.format("Button [%s] failed to execute.", modalComponent.getName().toUpperCase()));
            log.error("Button failed ::", e);
            if (event.isAcknowledged()) {
                event.getHook().sendMessageEmbeds(embedBuilder.build()).queue();
            } else event.replyEmbeds(embedBuilder.build()).queue();
        }
    }

    @Override
    public void onStringSelectInteraction(@NotNull StringSelectInteractionEvent event) {
        Optional<SelectMenuString> selectMenuStringOptional = new InteractionsHandler.SelectMenus.String()
            .getInteraction(event.getInteraction().getComponentId());

        if (selectMenuStringOptional.isEmpty()) return;

        StandardEmbed standardEmbed = new StandardEmbed(event.getUser());

        SelectMenuString selectMenuString = selectMenuStringOptional.get();
        try {
            selectMenuString.execute(event, standardEmbed);
        } catch (IOException | ExecutionException | InterruptedException e) {
            EmbedBuilder embedBuilder = standardEmbed.getEmbed(PersonalBot.EmbedColor.ERROR)
                .setDescription(String.format("Select Menu [%s] failed to execute.", selectMenuString.getName().toUpperCase()));
            log.error("Select Menu failed ::", e);
            if (event.isAcknowledged()) {
                event.getHook().sendMessageEmbeds(embedBuilder.build()).queue();
            } else event.replyEmbeds(embedBuilder.build()).queue();
        }
    }

    @Override
    public void onEntitySelectInteraction(@NotNull EntitySelectInteractionEvent event) {
        Optional<SelectMenuEntity> selectMenuEntityOptional = new InteractionsHandler.SelectMenus.Entity()
            .getInteraction(event.getInteraction().getComponentId());

        if (selectMenuEntityOptional.isEmpty()) return;

        StandardEmbed standardEmbed = new StandardEmbed(event.getUser());

        SelectMenuEntity selectMenuEntity = selectMenuEntityOptional.get();
        try {
            selectMenuEntity.execute(event, standardEmbed);
        } catch (IOException | ExecutionException | InterruptedException e) {
            EmbedBuilder embedBuilder = standardEmbed.getEmbed(PersonalBot.EmbedColor.ERROR)
                .setDescription(String.format("Select Menu [%s] failed to execute.", selectMenuEntity.getName().toUpperCase()));
            log.error("Select Menu failed ::", e);
            if (event.isAcknowledged()) {
                event.getHook().sendMessageEmbeds(embedBuilder.build()).queue();
            } else event.replyEmbeds(embedBuilder.build()).queue();
        }
    }
}
