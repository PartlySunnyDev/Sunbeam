package me.partlysunny.sunbeam;

import com.google.common.base.Preconditions;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public final class Items {

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

    private Items() {
        throw new AssertionError("Cannot instantiate Items");
    }

}
