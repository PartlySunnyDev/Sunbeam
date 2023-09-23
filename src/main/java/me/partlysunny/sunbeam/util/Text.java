package me.partlysunny.sunbeam.util;

import org.bukkit.ChatColor;

import java.util.List;

public final class Text {

    public String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public List<String> color(List<String> messages) {
        messages.replaceAll(this::color);
        return messages;
    }

}
