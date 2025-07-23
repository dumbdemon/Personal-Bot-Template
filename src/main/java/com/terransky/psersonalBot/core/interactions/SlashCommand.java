package com.terransky.psersonalBot.core.interactions;

import com.terransky.psersonalBot.core.StandardEmbed;
import com.terransky.psersonalBot.core.interfaces.IInteraction;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.IntegrationType;
import net.dv8tion.jda.api.interactions.commands.build.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SlashCommand implements IInteraction.ICommand<SlashCommandInteractionEvent> {

    private final String name;
    private final String description;
    private final List<SubcommandGroupData> subcommandGroups = new ArrayList<>();
    private final List<SubcommandData> subcommands = new ArrayList<>();
    private final List<OptionData> options = new ArrayList<>();
    private boolean isNSFW = false;

    protected SlashCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Add options to the slash command.
     *
     * @param optionData An array of {@link OptionData}
     */
    @SuppressWarnings("unused")
    protected void addOptions(OptionData... optionData) {
        options.addAll(List.of(optionData));
    }

    /**
     * Add Subcommands to a slash command.
     * <p>
     * <b>NOTE:</b> If you added options via {@link #addOptions(OptionData...)}, subcommands added here will be ignored.
     *
     * @param subcommandData An array of {@link SubcommandData}
     */
    @SuppressWarnings("unused")
    protected void addSubCommands(SubcommandData... subcommandData) {
        subcommands.addAll(List.of(subcommandData));
    }

    /**
     * Add Subcommand groups to a slash command.
     * <p>
     * <b>NOTE:</b> If you added options via {@link #addOptions(OptionData...)} or {@link #addSubCommands(SubcommandData...)}, subcommand groups added here will be ignored.
     *
     * @param subcommandGroupData An array of {@link SubcommandGroupData}
     */
    @SuppressWarnings("unused")
    protected void addSubCommandGroup(SubcommandGroupData... subcommandGroupData) {
        subcommandGroups.addAll(List.of(subcommandGroupData));
    }

    public SlashCommandData getCommandData() {
        SlashCommandData commandData = Commands.slash(name, description)
            .setIntegrationTypes(IntegrationType.USER_INSTALL)
            .setNSFW(isNSFW);

        if (!options.isEmpty())
            return commandData.addOptions(options);

        if (!subcommands.isEmpty())
            return commandData.addSubcommands(subcommands);

        if (!subcommandGroups.isEmpty())
            return commandData.addSubcommandGroups(subcommandGroups);

        return commandData;
    }

    /**
     * Notates whether a command is Not Safe for Work.
     *
     * @param nsfw False until otherwise.
     */
    @SuppressWarnings("unused")
    protected void isNSFW(boolean nsfw) {
        this.isNSFW = nsfw;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(@NotNull SlashCommandInteractionEvent event, StandardEmbed standardEmbed) throws IOException, ExecutionException, InterruptedException {
        event.reply("That does nothing. Was this intended?").queue();
    }
}
