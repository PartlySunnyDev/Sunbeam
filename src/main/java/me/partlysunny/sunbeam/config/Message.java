package me.partlysunny.sunbeam.config;

import me.partlysunny.sunbeam.Text;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.annotation.Nullable;
import java.util.Map;

public class Message {

    public static void init() {
        Config.add("messages", "messages");
    }

    /**
     * Gets a message from the messages.yml file and automatically colors it.
     *
     * @param path The path to the message.
     * @return The colored message.
     */
    @NonNull
    public static String get(String path) {
        return get(path, true);
    }

    /**
     * Gets a message from the messages.yml file.
     *
     * @param path      The path to the message.
     * @param autoColor Whether or not to automatically color the message.
     * @return The message.
     */
    @NonNull
    public static String get(String path, boolean autoColor) {
        return get(path, "", autoColor);
    }

    /**
     * Gets a message from the messages.yml file and automatically colors it.
     * @param path The path to the message in the config file.
     * @param defaultMessage The message to default to if the path does not exist.
     * @return The colored message.
     */
    @NonNull
    public static String get(String path, @NonNull String defaultMessage) {
        return get(path, defaultMessage, true);
    }

    /**
     * Gets a message from the messages.yml file with a specified coloring strategy
     * @param path The path to the message in the config file.
     * @param defaultMessage The message to default to if the path does not exist.
     * @param autoColor Whether or not to automatically color the message.
     * @return The message after processing.
     */
    public static String get(String path, String defaultMessage, boolean autoColor) {
        return get(path, defaultMessage, autoColor, Map.of());
    }

    /**
     * Gets a message from the messages.yml file with a specified coloring strategy
     * @param path The path to the message in the config file.
     * @param defaultMessage The message to default to if the path does not exist.
     * @param autoColor Whether or not to automatically color the message.
     * @param replacements The replacements to make in the message.
     * @return The message after processing.s
     */
    @NonNull
    public static String get(String path, @NonNull String defaultMessage, boolean autoColor, Map<String, String> replacements) {
        String message = Config.getConfig("messages").getString(path, defaultMessage);
        if (autoColor) {
            return Text.color(message);
        }
        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            message = message.replace(entry.getKey(), entry.getValue());
        }
        return message;
    }

    /**
     * Gets a message from the messages.yml file. Automatically colors and has no default message
     * @param path The path to the message in the config file.
     * @param replacements The replacements to make in the message.
     * @return The message after processing.s
     */
    @NonNull
    public static String get(String path, Map<String, String> replacements) {
        return get(path, "", true, replacements);
    }

    @NonNull
    public static String get(String path, @NonNull String defaultMessage, Map<String, String> replacements) {
        return get(path, defaultMessage, true, replacements);
    }

    public static void send(Player p, String path, @NonNull String defaultMessage, Map<String, String> replacements) {
        p.sendMessage(get(path, defaultMessage, replacements));
    }

    public static void send(Player p, String path, @NonNull String defaultMessage) {
        p.sendMessage(get(path, defaultMessage));
    }

    public static void send(Player p, String path) {
        p.sendMessage(get(path));
    }

}
