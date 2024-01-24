package me.partlysunny.sunbeam.menu;

import org.bukkit.inventory.EquipmentSlot;

public final class Slots {

    public static final int HOTBAR_START = 0;
    public static final int HOTBAR_END = 8;
    public static final int ARMOR_BOOTS = 36;
    public static final int ARMOR_HELMET = 39;
    public static final int OFFHAND = 40;

    public static int getHotbarSlot(int index) {
        return HOTBAR_START + index;
    }

    public static int getEquipmentSlot(EquipmentSlot slot) {
        return switch (slot) {
            case HAND -> 0;
            case FEET -> ARMOR_BOOTS;
            case LEGS -> ARMOR_BOOTS + 1;
            case CHEST -> ARMOR_HELMET - 1;
            case HEAD -> ARMOR_HELMET;
            default -> -1;
        };
    }

}
