package com.terransky.psersonalBot.interactions.command;

import com.terransky.psersonalBot.core.StandardEmbed;
import com.terransky.psersonalBot.core.interactions.SlashCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

public class Ping extends SlashCommand {

    public Ping() {
        super("ping", "PONG!");
    }

    @Override
    public void execute(@NotNull SlashCommandInteractionEvent event, StandardEmbed standardEmbed) {
        JDA jda = event.getJDA();
        jda.getRestPing().queue(ping -> event.replyEmbeds(
            standardEmbed.getEmbed("Ping Info")
                .addField("Rest Ping", ping + "ms", true)
                .addField("Web Socket Ping", jda.getGatewayPing() + "ms", true)
                .build()
        ).setEphemeral(true).queue());
    }
}
