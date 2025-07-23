package com.terransky.psersonalBot.core.interactions;

import com.terransky.psersonalBot.core.StandardEmbed;
import com.terransky.psersonalBot.core.interfaces.IInteraction;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ButtonComponent implements IInteraction.IButton {

    private final String label;

    protected ButtonComponent(String label) {
        this.label = label;
    }

    @Override
    public String getName() {
        return label;
    }

    @Override
    public void execute(@NotNull ButtonInteractionEvent event, StandardEmbed standardEmbed) throws IOException, ExecutionException, InterruptedException {
        event.reply("That does nothing. Was this intended?").queue();
    }
}
