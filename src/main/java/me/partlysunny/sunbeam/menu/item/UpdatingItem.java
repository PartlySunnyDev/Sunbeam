package me.partlysunny.sunbeam.menu.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class UpdatingItem extends DisplayItem {

    private final Runnable update;

    public UpdatingItem(ItemStack item, Runnable update) {
        super(item);
        this.update = update;
    }

    public UpdatingItem(Material material, String name, Runnable update) {
        super(material, name);
        this.update = update;
    }

    public UpdatingItem(Material material, String name, Runnable update, String... lore) {
        super(material, name, lore);
        this.update = update;
    }

    @Override
    public void update() {
        update.run();
    }
}
