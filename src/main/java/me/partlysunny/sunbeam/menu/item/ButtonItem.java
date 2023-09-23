package me.partlysunny.sunbeam.menu.item;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public class ButtonItem extends DisplayItem {

    private final Consumer<InventoryClickEvent> action;
    private Sound clickSound = Sound.UI_BUTTON_CLICK;

    public ButtonItem(Consumer<InventoryClickEvent> action, ItemStack item) {
        super(item);
        this.action = action;
    }

    public ButtonItem(Consumer<InventoryClickEvent> action, Material material, String name) {
        super(material, name);
        this.action = action;
    }

    public ButtonItem(Consumer<InventoryClickEvent> action, Material material, String name, String... lore) {
        super(material, name, lore);
        this.action = action;
    }

    public Sound getClickSound() {
        return clickSound;
    }

    public void setClickSound(Sound clickSound) {
        this.clickSound = clickSound;
    }

    public void onClick(InventoryClickEvent event) {
        if (action == null) return;
        action.accept(event);
        if (clickSound != null) {
            HumanEntity clicker = event.getWhoClicked();
            if (clicker instanceof Player player) {
                player.playSound(player.getLocation(), clickSound, 1, 1);
            }
        }
    }

}
