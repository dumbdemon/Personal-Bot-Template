package com.terransky.psersonalBot.core;

import com.terransky.psersonalBot.core.interfaces.IInteraction;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Optional;

public class InteractionHandler<T extends IInteraction<?>> {
    protected final HashSet<T> interactionsHashSet = new HashSet<>();

    protected InteractionHandler() {
    }

    /**
     * Add an {@link IInteraction} of type {@link T} to the handler.
     *
     * @param interaction An interaction of type {@link T}.
     */
    protected final void addInteraction(T interaction) {
        interactionsHashSet.add(interaction);
    }

    /**
     * Search the handler for an interaction.
     *
     * @param search The name/id/label of the interaction.
     * @return Optional containing an object of type {@link T} or null.
     */
    @NotNull
    public Optional<T> getInteraction(String search) {
        return interactionsHashSet.stream()
            .filter(interaction -> interaction.getName().equalsIgnoreCase(search))
            .findFirst();
    }
}
