package me.partlysunny.sunbeam.menu.item;

import me.partlysunny.sunbeam.Scheduler;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

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
