package me.partlysunny.sunbeam.menu.item;

import me.partlysunny.sunbeam.Items;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DisplayItem extends MenuItem {

    private final ItemStack item;

    public DisplayItem(ItemStack item) {
        this.item = item;
    }

    public DisplayItem(Material material, String name) {
        this.item = new ItemStack(material);
        Items.name(item, name);
    }

    public DisplayItem(Material material, String name, String... lore) {
        this.item = new ItemStack(material);
        Items.name(item, name);
        Items.lore(item, lore);
    }

    @Override
    public ItemStack getItem() {
        return null;
    }
}
