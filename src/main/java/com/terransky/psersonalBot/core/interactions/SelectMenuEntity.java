package com.terransky.psersonalBot.core.interactions;

import com.terransky.psersonalBot.core.StandardEmbed;
import com.terransky.psersonalBot.core.interfaces.IInteraction;
import net.dv8tion.jda.api.events.interaction.component.EntitySelectInteractionEvent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@SuppressWarnings("unused")
public class SelectMenuEntity implements IInteraction.ISelectMenuEntity {

    private final String id;

    protected SelectMenuEntity(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return id;
    }

    @Override
    public void execute(@NotNull EntitySelectInteractionEvent event, StandardEmbed standardEmbed) throws IOException, ExecutionException, InterruptedException {

    }
}
