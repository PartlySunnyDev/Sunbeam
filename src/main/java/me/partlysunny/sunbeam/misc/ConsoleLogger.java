package me.partlysunny.sunbeam.misc;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class ConsoleLogger {

    private static Logger logger;

    public static void init(JavaPlugin plugin) {
        logger = plugin.getLogger();
    }

    public static void console(String message) {
        logger.info(message);
    }

    public static void warning(String message) {
        logger.warning(message);
    }

    public static void error(String message) {
        logger.severe(message);
    }

}
