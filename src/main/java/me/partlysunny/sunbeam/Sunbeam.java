package me.partlysunny.sunbeam;

import me.partlysunny.sunbeam.config.Config;
import me.partlysunny.sunbeam.config.Message;
import me.partlysunny.sunbeam.menu.MenuListener;
import me.partlysunny.sunbeam.misc.ConsoleLogger;
import org.bukkit.plugin.java.JavaPlugin;

public final class Sunbeam {

    private static JavaPlugin plugin;
    private static String key;

    public static void init(JavaPlugin plugin) {
        init(plugin, new SunbeamOptions());
    }

    public static void init(JavaPlugin plugin, SunbeamOptions options) {
        ConsoleLogger.init(plugin);
        Scheduler.init(plugin);
        Config.init(plugin);
        Commands.init(plugin);
        if (options.doLoadMessagesConfig()) Message.init();
        key = options.getCustomDataKey();
        plugin.getServer().getPluginManager().registerEvents(new MenuListener(), plugin);
        Sunbeam.plugin = plugin;
    }

    public static JavaPlugin getPlugin() {
        if (plugin == null) {
            throw new IllegalStateException("Sunbeam has not been initialized yet!");
        }
        return plugin;
    }

    public static String getKey() {
        if (key == null) {
            throw new IllegalStateException("Sunbeam has not been initialized yet!");
        }
        return key;
    }

}
