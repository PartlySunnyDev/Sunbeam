package me.partlysunny.sunbeam.config;

import me.partlysunny.sunbeam.Text;

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
    public static String get(String path, boolean autoColor) {
        String message = Config.getConfig("messages").getString(path);
        if (autoColor) {
            return Text.color(message);
        }
        return message;
    }

    /**
     * Gets a message from the messages.yml file and automatically colors it.
     * @param path The path to the message in the config file.
     * @param defaultMessage The message to default to if the path does not exist.
     * @return The colored message.
     */
    public static String get(String path, String defaultMessage) {
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
        String message = Config.getConfig("messages").getString(path, defaultMessage);
        if (autoColor) {
            return Text.color(message);
        }
        return message;
    }

}
