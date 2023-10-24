package me.partlysunny.sunbeam;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.partlysunny.sunbeam.config.Config;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.sql.DataSource;

public final class Databases {

    public static HikariConfig generate(String host, int port, String database, String username, String password) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://" + host + ":" + port + "/" + database);
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return config;
    }

    /**
     * Get a DataSource from a config file
     * The config section will be as follows:<br>
     *     host: localhost<br>
     *     port: 3306<br>
     *     database: name<br>
     *     username: root<br>
     *     password: password<br>
     * @param configFile The file, must be registered in {@link Config}
     * @param section The section where the database info is
     * @return The DataSource
     */
    public static DataSource getFromConfig(String configFile, String section) {
        YamlConfiguration config = Config.getConfig(configFile);
        return getDataSource(config.getString(section + ".host"), config.getInt(section + ".port"), config.getString(section + ".database"), config.getString(section + ".username"), config.getString(section + ".password"));
    }

    public static DataSource getDataSource(String host, int port, String database, String username, String password) {
        return new HikariDataSource(generate(host, port, database, username, password));
    }

}
