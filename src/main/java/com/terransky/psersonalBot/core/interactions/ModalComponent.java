package com.terransky.psersonalBot.core.interactions;

import com.terransky.psersonalBot.core.StandardEmbed;
import com.terransky.psersonalBot.core.interfaces.IInteraction;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.interactions.modals.Modal;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ModalComponent implements IInteraction.IModal {

    private final String label;
    private final String title;

    protected ModalComponent(String label, String title) {
        this.label = label;
        this.title = title;
    }

    @SuppressWarnings("unused")
    protected Modal.Builder getModalBuilder() {
        return Modal.create(label, title);
    }

    @Override
    public Modal getConstructedModal() {
        return null;
    }

    @Override
    public String getName() {
        return label;
    }

    @Override
    public void execute(@NotNull ModalInteractionEvent event, StandardEmbed standardEmbed) throws IOException, ExecutionException, InterruptedException {
    }
}
