package me.partlysunny.sunbeam.menu.item;

import me.partlysunny.sunbeam.menu.Menus;
import me.partlysunny.sunbeam.misc.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PageChangeItem extends ButtonItem {

    private final String destination;

    public PageChangeItem(String destination, String name) {
        this(destination, ItemBuilder.builder(Material.ARROW).setName(name).build());
    }

    public PageChangeItem(String destination, ItemStack item) {
        super(event -> {
            Menus.open(((Player) event.getWhoClicked()), destination);
        }, item);
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

}
