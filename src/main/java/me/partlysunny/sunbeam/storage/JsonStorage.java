package me.partlysunny.sunbeam.storage;

import com.google.gson.JsonObject;
import me.partlysunny.sunbeam.Sunbeam;

import java.io.File;

public final class JsonStorage {

    public static String savePath = "data";

    public static JsonObject load(String name) {
        Sunbeam.getPlugin().getDataFolder().mkdirs();
        File file = new File(Sunbeam.getPlugin().getDataFolder(), savePath + "/" + name + ".json");
        if (!file.exists()) {
            return new JsonObject();
        }
        return Sunbeam.gson.fromJson(FileUtils.readCollapsed(file), JsonObject.class);
    }

    public static void save(String name, JsonObject data) {
        Sunbeam.getPlugin().getDataFolder().mkdirs();
        File file = new File(Sunbeam.getPlugin().getDataFolder(), savePath + "/" + name + ".json");
        FileUtils.writeCollapsed(file, Sunbeam.gson.toJson(data));
    }

}
