package me.partlysunny.sunbeam.config;

import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class Config {

    private static final Map<String, ConfigInstance> configs = new HashMap<>();

    public static void init(JavaPlugin plugin) {
        plugin.getDataFolder().mkdirs();
    }

    /**
     * Add a config file to the config system.
     * @param defaultFileName The name or path to the default file without .yml extension
     * @param configName The name of the config file
     */
    public static void add(@Nullable String defaultFileName, @Nonnull String configName) {
        if (defaultFileName == null) {
            defaultFileName = configName;
        }
        configs.put(configName, new ConfigInstance(defaultFileName, configName));
    }

    public static ConfigInstance get(String name) {

    }

}
