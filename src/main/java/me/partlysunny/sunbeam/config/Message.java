package me.partlysunny.sunbeam.config;

import me.partlysunny.sunbeam.Text;

public class Message {

    public static void init() {
        Config.add("messages", "messages");
    }

    /**
     * Gets a message from the messages.yml file and automatically colors it.
     * @param path The path to the message.
     * @return The colored message.
     */
    public static String get(String path) {
        return get(path, true);
    }

    /**
     * Gets a message from the messages.yml file.
     * @param path The path to the message.
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

}
