package me.partlysunny.sunbeam.util;

import com.google.common.base.Preconditions;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public final class Items {

    public static void name(ItemStack item, String name) {
        Preconditions.checkNotNull(item, "item cannot be null");
        Preconditions.checkNotNull(name, "name cannot be null");
        ItemMeta meta = item.getItemMeta();
        Preconditions.checkArgument(meta != null, "item must have meta");
        meta.setDisplayName(name);
        item.setItemMeta(meta);
    }

    public static void lore(ItemStack item, String... lore) {
        Preconditions.checkNotNull(item, "item cannot be null");
        Preconditions.checkNotNull(lore, "lore cannot be null");
        ItemMeta meta = item.getItemMeta();
        Preconditions.checkArgument(meta != null, "item must have meta");
        meta.setLore(java.util.Arrays.asList(lore));
        item.setItemMeta(meta);
    }

    private Items() {
        throw new AssertionError("Cannot instantiate Items");
    }

}
