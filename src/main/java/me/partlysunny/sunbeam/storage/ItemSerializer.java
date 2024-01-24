package me.partlysunny.sunbeam.storage;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Type;
import java.util.Map;

public final class ItemSerializer {

    private static final Gson gson = new Gson();

    public static String fromItem(ItemStack itemStack) {
        Map<String, Object> serialize = itemStack.serialize();
        return gson.toJson(serialize);
    }

    public static ItemStack fromString(String json) {
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return ItemStack.deserialize(gson.fromJson(json, type));
    }

}
