package me.partlysunny.sunbeam.menu;

import me.partlysunny.sunbeam.Items;
import me.partlysunny.sunbeam.menu.item.MenuItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Each menu is bound to an inventory
 * You can then open the menu for different players
 */
public class Menu {

    private final Inventory inventory;
    private final Map<Integer, MenuItem> items = new HashMap<>();
    private boolean enforceNoClick = true;

    public Menu(String name, int rows) {
        inventory = Bukkit.createInventory(null, rows * 9, name);
    }

    public void setItem(int slot, MenuItem item) {
        inventory.setItem(slot, item.getItem());
        items.put(slot, item);
    }

    public MenuItem getItem(int slot) {
        return items.get(slot);
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

    public boolean isEnforceNoClick() {
        return enforceNoClick;
    }

    public void setEnforceNoClick(boolean enforceNoClick) {
        this.enforceNoClick = enforceNoClick;
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }

    public Inventory getInventory() {
        return inventory;
    }

}
