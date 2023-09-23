package me.partlysunny.sunbeam.menu;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Menus {

    private static final Map<UUID, Menu> openMenus = new HashMap<>();

    public static void open(Player player, Menu menu) {
        menu.open(player);
        openMenus.put(player.getUniqueId(), menu);
    }

    public static void close(Player player) {
        player.closeInventory();
        openMenus.remove(player.getUniqueId());
    }

    public static Menu getOpenMenu(Player player) {
        return openMenus.get(player.getUniqueId());
    }

}
