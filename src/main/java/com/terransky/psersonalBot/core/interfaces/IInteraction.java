package com.terransky.psersonalBot.core.interfaces;

import com.terransky.psersonalBot.core.StandardEmbed;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.EntitySelectInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.interactions.modals.Modal;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface IInteraction<T extends GenericInteractionCreateEvent> {

    /**
     * The name/label/ID of the interaction.
     *
     * @return A string containing a name, label, or ID.
     */
    String getName();

    /**
     * The main handler for all interactions.
     *
     * @param event         The event as received by Discord.
     * @param standardEmbed A ready-made {@link net.dv8tion.jda.api.EmbedBuilder} to send.
     * @throws IOException          Thrown if your command deals with the file system or network systems/APIs.
     * @throws ExecutionException   Thrown if your command deals with JVM processes.
     * @throws InterruptedException Thrown if a thread process caused an error.
     */
    void execute(@NotNull T event, StandardEmbed standardEmbed)
        throws IOException, ExecutionException, InterruptedException;


    interface ICommand<T extends GenericCommandInteractionEvent> extends IInteraction<T> {
    }

    interface IButton extends IInteraction<ButtonInteractionEvent> {
    }

    interface IModal extends IInteraction<ModalInteractionEvent> {

        /**
         * Get a constructed modal to be sent as a response.
         *
         * @return A {@link Modal} object.
         */
        @SuppressWarnings("unused")
        Modal getConstructedModal();
    }

    interface ISelectMenuEntity extends IInteraction<EntitySelectInteractionEvent> {
    }

    interface ISelectMenuString extends IInteraction<StringSelectInteractionEvent> {
    }
}
