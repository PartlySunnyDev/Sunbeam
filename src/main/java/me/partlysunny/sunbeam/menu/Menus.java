package me.partlysunny.sunbeam.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Menus {

    private static final Map<UUID, Menu> openMenus = new HashMap<>();
    private static final Map<String, MenuProvider> registeredMenus = new HashMap<>();

    public static void init(JavaPlugin plugin)
    {
        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Menu menu : openMenus.values()) {
                menu.update();
            }
        }, 0, 1);
    }
    public static void open(Player player, Menu menu) {
        menu.open(player);
        openMenus.put(player.getUniqueId(), menu);
    }

    public static void open(Player player, String name) {
        open(player, registeredMenus.get(name).apply(player));
    }

    public static void registerMenu(String name, MenuProvider menu) {
        registeredMenus.put(name, menu);
    }

    public static void close(Player player) {
        openMenus.remove(player.getUniqueId());
        player.closeInventory();
    }

    public static void reload(Player player, String menu) {
        close(player);
        open(player, menu);
    }

    public static Menu getOpenMenu(Player player) {
        return openMenus.get(player.getUniqueId());
    }

}
