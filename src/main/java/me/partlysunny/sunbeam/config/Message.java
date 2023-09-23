package me.partlysunny.sunbeam.config;

public class Message {

    public static void init() {
        Config.add("messages", "messages");
    }

    public static String get(String path) {
        return Config.getConfig("messages").getString(path);
    }

}
