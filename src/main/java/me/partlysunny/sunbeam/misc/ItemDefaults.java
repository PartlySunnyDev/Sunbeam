package me.partlysunny.sunbeam.misc;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public final class ItemDefaults {

    private static final Map<Material, Integer> ARMOR_VALUES = new HashMap<>() {{
        put(Material.LEATHER_HELMET, 1);
        put(Material.LEATHER_CHESTPLATE, 3);
        put(Material.LEATHER_LEGGINGS, 2);
        put(Material.LEATHER_BOOTS, 1);
        put(Material.GOLDEN_HELMET, 2);
        put(Material.GOLDEN_CHESTPLATE, 5);
        put(Material.GOLDEN_LEGGINGS, 3);
        put(Material.GOLDEN_BOOTS, 1);
        put(Material.CHAINMAIL_HELMET, 2);
        put(Material.CHAINMAIL_CHESTPLATE, 5);
        put(Material.CHAINMAIL_LEGGINGS, 4);
        put(Material.CHAINMAIL_BOOTS, 1);
        put(Material.IRON_HELMET, 2);
        put(Material.IRON_CHESTPLATE, 6);
        put(Material.IRON_LEGGINGS, 5);
        put(Material.IRON_BOOTS, 2);
        put(Material.DIAMOND_HELMET, 3);
        put(Material.DIAMOND_CHESTPLATE, 8);
        put(Material.DIAMOND_LEGGINGS, 6);
        put(Material.DIAMOND_BOOTS, 3);
        put(Material.NETHERITE_HELMET, 3);
        put(Material.NETHERITE_CHESTPLATE, 8);
        put(Material.NETHERITE_LEGGINGS, 6);
        put(Material.NETHERITE_BOOTS, 3);
    }};

    private static final Map<Material, Integer> TOUGHNESS_VALUES = new HashMap<>() {{
        put(Material.LEATHER_HELMET, 0);
        put(Material.LEATHER_CHESTPLATE, 0);
        put(Material.LEATHER_LEGGINGS, 0);
        put(Material.LEATHER_BOOTS, 0);
        put(Material.GOLDEN_HELMET, 0);
        put(Material.GOLDEN_CHESTPLATE, 0);
        put(Material.GOLDEN_LEGGINGS, 0);
        put(Material.GOLDEN_BOOTS, 0);
        put(Material.CHAINMAIL_HELMET, 0);
        put(Material.CHAINMAIL_CHESTPLATE, 0);
        put(Material.CHAINMAIL_LEGGINGS, 0);
        put(Material.CHAINMAIL_BOOTS, 0);
        put(Material.IRON_HELMET, 0);
        put(Material.IRON_CHESTPLATE, 0);
        put(Material.IRON_LEGGINGS, 0);
        put(Material.IRON_BOOTS, 0);
        put(Material.DIAMOND_HELMET, 2);
        put(Material.DIAMOND_CHESTPLATE, 2);
        put(Material.DIAMOND_LEGGINGS, 2);
        put(Material.DIAMOND_BOOTS, 2);
        put(Material.NETHERITE_HELMET, 3);
        put(Material.NETHERITE_CHESTPLATE, 3);
        put(Material.NETHERITE_LEGGINGS, 3);
        put(Material.NETHERITE_BOOTS, 3);
    }};

    public static int getArmorValue(ItemStack item) {
        if (item == null || item.getType() == Material.AIR) {
            return 0;
        }
        if (ARMOR_VALUES.containsKey(item.getType())) {
            return ARMOR_VALUES.get(item.getType());
        }
        return 0;
    }

    public static int getArmorValue(Material mat) {
        if (mat == null) {
            return 0;
        }
        if (ARMOR_VALUES.containsKey(mat)) {
            return ARMOR_VALUES.get(mat);
        }
        return 0;
    }

    public static int getToughnessValue(ItemStack item) {
        if (item == null || item.getType() == Material.AIR) {
            return 0;
        }
        if (TOUGHNESS_VALUES.containsKey(item.getType())) {
            return TOUGHNESS_VALUES.get(item.getType());
        }
        return 0;
    }

    public static int getToughnessValue(Material mat) {
        if (mat == null) {
            return 0;
        }
        if (TOUGHNESS_VALUES.containsKey(mat)) {
            return TOUGHNESS_VALUES.get(mat);
        }
        return 0;
    }

    public static String getDefaultName(Material material) {
        String unprocessed = material.toString().toLowerCase().replace("_", " ");
        String[] split = unprocessed.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    private ItemDefaults() {
        throw new AssertionError("This utility class cannot be instantiated");
    }

}
