package com.terransky.psersonalBot.core;

import com.terransky.psersonalBot.core.interfaces.IInteraction;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Optional;

public class InteractionHandler<T extends IInteraction<?>> {
    protected final HashSet<T> interactionsHashSet = new HashSet<>();

    protected InteractionHandler() {
    }

    protected final void addInteraction(T interaction) {
        interactionsHashSet.add(interaction);
    }

    @NotNull
    public Optional<T> getInteraction(String search) {
        return interactionsHashSet.stream()
            .filter(interaction -> interaction.getName().equalsIgnoreCase(search))
            .findFirst();
    }
}
