package me.partlysunny.sunbeam.menu.item;

import me.partlysunny.sunbeam.menu.Menu;
import me.partlysunny.sunbeam.menu.Menus;
import me.partlysunny.sunbeam.misc.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Supplier;

public class PageChangeItem extends ButtonItem {

    private final Supplier<Menu> destination;

    public PageChangeItem(Supplier<Menu> destination, String name) {
        this(destination, ItemBuilder.builder(Material.ARROW).setName(name).build());
    }

    public PageChangeItem(Supplier<Menu> destination, ItemStack item) {
        super(event -> {
            Menus.open(((Player) event.getWhoClicked()), destination.get());
        }, item);
        this.destination = destination;
    }

    public Supplier<Menu> getDestination() {
        return destination;
    }

}
