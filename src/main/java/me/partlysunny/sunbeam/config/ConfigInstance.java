package me.partlysunny.sunbeam.config;

import me.partlysunny.sunbeam.Sunbeam;
import org.bukkit.configuration.InvalidConfigurationException;
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
        this.config = YamlConfiguration.loadConfiguration(file);
        this.defaultFileStream = getClass().getClassLoader().getResourceAsStream(defaultFileName + ".yml");
        try {
            reload();
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
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

    public void reload() throws IOException, InvalidConfigurationException {
        if (!file.exists()) {
            if (defaultFileStream != null) {
                saveDefault();
            } else {
                if (!file.createNewFile()) {
                    throw new IOException("Could not create file " + file.getName());
                }
            }
        }
        config.load(file);
    }

    public void save() throws IOException {
        config.save(file);
    }

    public void saveDefault() throws IOException {
        if (defaultFileStream == null) {
            throw new IOException("Could not find default file " + defaultFileName);
        }
        if (file.exists()) {
            return;
        }
        Sunbeam.getPlugin().saveResource(defaultFileName + ".yml", true);
    }

}
