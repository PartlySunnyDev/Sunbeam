package me.partlysunny.sunbeam;

import me.partlysunny.sunbeam.config.Config;
import me.partlysunny.sunbeam.misc.ConsoleLogger;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sunbeam {

    private static JavaPlugin plugin;

    public static void init(JavaPlugin plugin) {
        ConsoleLogger.init(plugin);
        Scheduler.init(plugin);
        Config.init(plugin);
        Sunbeam.plugin = plugin;
    }

    public static JavaPlugin getPlugin() {
        if (plugin == null) {
            throw new IllegalStateException("Sunbeam has not been initialized yet!");
        }
        return plugin;
    }

}
