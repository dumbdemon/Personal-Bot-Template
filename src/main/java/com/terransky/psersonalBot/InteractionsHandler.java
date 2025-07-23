package com.terransky.psersonalBot;

import com.terransky.psersonalBot.core.InteractionHandler;
import com.terransky.psersonalBot.core.interactions.*;
import com.terransky.psersonalBot.interactions.command.Ping;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.List;

public class InteractionsHandler {

    InteractionsHandler() {
    }

    public static class Commands extends InteractionHandler<SlashCommand> {

        public Commands() {
            addInteraction(new Ping());
        }

        public List<SlashCommandData> getCommandData() {
            return interactionsHashSet.stream().map(SlashCommand::getCommandData).toList();
        }
    }

    public static class DiscordButtons extends InteractionHandler<ButtonComponent> {

        public DiscordButtons() {
        }
    }

    public static class Modals extends InteractionHandler<ModalComponent> {

        public Modals() {
        }
    }

    public static class SelectMenus {

        public static class String extends InteractionHandler<SelectMenuString> {

            public String() {
            }
        }

        public static class Entity extends InteractionHandler<SelectMenuEntity> {

            public Entity() {
            }
        }
    }
}
