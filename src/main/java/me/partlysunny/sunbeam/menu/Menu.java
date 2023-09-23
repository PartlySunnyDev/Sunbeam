package me.partlysunny.sunbeam.menu;

import me.partlysunny.sunbeam.Items;
import me.partlysunny.sunbeam.menu.item.MenuItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Each menu is bound to an inventory
 * You can then open the menu for different players
 */
public class Menu {

    private final Inventory inventory;

    public Menu(String name, int rows) {
        inventory = Bukkit.createInventory(null, rows * 9, name);
    }

    public void setItem(int slot, MenuItem item) {
        inventory.setItem(slot, item.getItem());
    }

    public void fillBackground(Material material) {
        ItemStack item = new ItemStack(material);
        Items.name(item, "");
        for (int i = 0; i < inventory.getSize(); i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, item);
            }
        }
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }

    public Inventory getInventory() {
        return inventory;
    }

}
