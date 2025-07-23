package com.terransky.psersonalBot.interactions.buttons;

import com.terransky.psersonalBot.PersonalBot;
import com.terransky.psersonalBot.core.StandardEmbed;
import com.terransky.psersonalBot.core.interactions.ButtonComponent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class InvalidButton extends ButtonComponent {
    public InvalidButton() {
        super("invalid-button");
    }

    @Override
    public void execute(@NotNull ButtonInteractionEvent event, @NotNull StandardEmbed standardEmbed) throws IOException, ExecutionException, InterruptedException {
        event.replyEmbeds(
            standardEmbed.getEmbed("Button Expired", PersonalBot.EmbedColor.ERROR)
                .setDescription("This button no longer works.")
                .build()
        ).setEphemeral(true).queue();
    }
}
