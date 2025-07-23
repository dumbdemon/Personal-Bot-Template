package com.terransky.psersonalBot.core;

import com.terransky.psersonalBot.PersonalBot;
import net.dv8tion.jda.api.EmbedBuilder;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.time.OffsetDateTime;

@SuppressWarnings("unused")
public record StandardEmbed(net.dv8tion.jda.api.entities.User user) {
    @NotNull
    private String getEffectiveName() {
        return user.getEffectiveName();
    }

    @NotNull
    private String getEffectiveAvatarUrl() {
        return user.getEffectiveAvatarUrl();
    }


    @NotNull
    public EmbedBuilder getEmbed() {
        return new EmbedBuilder()
            .setColor(PersonalBot.EmbedColor.DEFAULT.getColor())
            .setTimestamp(OffsetDateTime.now())
            .setFooter(getEffectiveName(), getEffectiveAvatarUrl());
    }

    @NotNull
    public EmbedBuilder getEmbed(String embedTitle) {
        return getEmbed()
            .setTitle(embedTitle);
    }

    @NotNull
    public EmbedBuilder getEmbed(Color color) {
        return getEmbed()
            .setColor(color);
    }

    @NotNull
    public EmbedBuilder getEmbed(@NotNull PersonalBot.EmbedColor color) {
        return getEmbed(color.getColor());
    }

    @NotNull
    public EmbedBuilder getEmbed(String embedTitle, String url) {
        return getEmbed()
            .setTitle(embedTitle, url);
    }

    @NotNull
    public EmbedBuilder getEmbed(String embedTitle, Color color) {
        return getEmbed(color)
            .setTitle(embedTitle);
    }

    @NotNull
    public EmbedBuilder getEmbed(String embedTitle, @NotNull PersonalBot.EmbedColor color) {
        return getEmbed(embedTitle, color.getColor());
    }

    @NotNull
    public EmbedBuilder getEmbed(String embedTitle, String url, Color color) {
        return getEmbed(color)
            .setTitle(embedTitle, url);
    }

    @NotNull
    public EmbedBuilder getEmbed(String embedTitle, String url, @NotNull PersonalBot.EmbedColor color) {
        return getEmbed(embedTitle, url, color.getColor());
    }
}
