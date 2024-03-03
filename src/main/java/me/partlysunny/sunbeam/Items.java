package me.partlysunny.sunbeam;

import com.google.common.base.Preconditions;
import me.partlysunny.sunbeam.misc.CustomData;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public final class Items {

    private Items() {
        throw new AssertionError("Cannot instantiate Items");
    }

    public static void name(ItemStack item, String name) {
        Preconditions.checkNotNull(item, "item cannot be null");
        Preconditions.checkNotNull(name, "name cannot be null");
        ItemMeta meta = item.getItemMeta();
        Preconditions.checkArgument(meta != null, "item must have meta");
        meta.setDisplayName(ChatColor.RESET + name);
        item.setItemMeta(meta);
    }

    public static void lore(ItemStack item, String... lore) {
        Preconditions.checkNotNull(item, "item cannot be null");
        Preconditions.checkNotNull(lore, "lore cannot be null");
        ItemMeta meta = item.getItemMeta();
        Preconditions.checkArgument(meta != null, "item must have meta");
        List<String> list = Arrays.asList(lore);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, ChatColor.RESET + list.get(i));
        }
        meta.setLore(list);
        item.setItemMeta(meta);
    }

    public static void tag(ItemStack item, String tagId) {
        Preconditions.checkNotNull(tagId, "tagId cannot be null");
        CustomData data = CustomData.of(item);
        data.set(tagId, true);
        data.update(item);
    }

    public static boolean checkTag(ItemStack item, String tagId) {
        Preconditions.checkNotNull(tagId, "tagId cannot be null");
        CustomData data = CustomData.of(item);
        return data.has(tagId);
    }

}
