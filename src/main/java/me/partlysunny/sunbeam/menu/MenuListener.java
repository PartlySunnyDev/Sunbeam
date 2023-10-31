package me.partlysunny.sunbeam.menu;

import me.partlysunny.sunbeam.menu.item.ButtonItem;
import me.partlysunny.sunbeam.menu.item.MenuItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class MenuListener implements Listener {

    @EventHandler
    public void playerClickMenu(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player p) {
            Menu menu = Menus.getOpenMenu(p);
            if (menu == null) {
                return;
            }
            if (menu.isEnforceNoClick()) {
                e.setCancelled(true);
            }
            MenuItem item = menu.getItem(e.getSlot());
            if (item == null) {
                //This is just a normal menu item
                return;
            }
            if (item instanceof ButtonItem button) {
                button.onClick(e);
            }
        }
    }

    @EventHandler
    public void playerCloseMenu(InventoryCloseEvent e) {
        if (e.getPlayer() instanceof Player player) {
            Menu menu = Menus.getOpenMenu(player);
            if (menu != null) {
                Menus.close(player);
            }
        }
    }

}
