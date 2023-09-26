package me.partlysunny.sunbeam;

import org.bukkit.ChatColor;

import java.util.List;

public final class Text {

    private Text() {
        throw new IllegalStateException("Utility class");
    }

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> color(List<String> messages) {
        messages.replaceAll(Text::color);
        return messages;
    }

}
