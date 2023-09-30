package me.partlysunny.sunbeam.menu.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UpdatingItem extends DisplayItem {


    public UpdatingItem(ItemStack item) {
        super(item);
    }

    public UpdatingItem(Material material, String name) {
        super(material, name);
    }

    public UpdatingItem(Material material, String name, String... lore) {
        super(material, name, lore);
    }
}
