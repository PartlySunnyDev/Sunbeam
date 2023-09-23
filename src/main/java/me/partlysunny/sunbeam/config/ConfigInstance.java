package me.partlysunny.sunbeam.config;

import me.partlysunny.sunbeam.Sunbeam;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ConfigInstance {

    private final String defaultFileName;
    private final String configName;
    private final YamlConfiguration config;
    private final InputStream defaultFileStream;
    private final File file;

    public ConfigInstance(String defaultFileName, String configName) {
        this.defaultFileName = defaultFileName;
        this.configName = configName;
        this.file = new File(Sunbeam.getPlugin().getDataFolder(), configName + ".yml");
        this.config = new YamlConfiguration();
        this.defaultFileStream = getClass().getClassLoader().getResourceAsStream(defaultFileName + ".yml");
    }

    public String getDefaultFileName() {
        return defaultFileName;
    }

    public String getConfigName() {
        return configName;
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public void reload() {
        /*if (!.exists()) {
            if (defaultFileStream != null) {
                saveDefault();
            } else {
                if (!file.createNewFile()) {
                    throw new IOException("Could not create file " + file.getName());
                }
            }
        }
        config.load(file);*/
    }

}
