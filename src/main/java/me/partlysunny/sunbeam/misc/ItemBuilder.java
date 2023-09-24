package me.partlysunny.sunbeam.misc;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemBuilder {

    private final ItemStack i;
    private final ItemMeta meta;

    private ItemBuilder(Material m) {
        i = new ItemStack(m);
        meta = i.getItemMeta();
    }

    public static ItemBuilder builder(Material m) {
        return new ItemBuilder(m);
    }

    public ItemBuilder setLore(String... lore) {
        meta.setLore(List.of(lore));
        return this;
    }

    public ItemBuilder setName(String name) {
        meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        i.setAmount(amount);
        return this;
    }

    public ItemBuilder setCustomModelData(int data) {
        meta.setCustomModelData(data);
        return this;
    }

    public ItemStack build() {
        i.setItemMeta(meta);
        return i;
    }

}
