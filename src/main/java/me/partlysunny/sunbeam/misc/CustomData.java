package me.partlysunny.sunbeam.misc;

import com.google.common.base.Preconditions;
import me.partlysunny.sunbeam.Sunbeam;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CustomData {

    private final PersistentDataContainer container;
    private ItemMeta potentialMeta;

    private CustomData(PersistentDataContainer container) {
        this.container = container;
    }

    public static CustomData of(PersistentDataContainer container) {
        Preconditions.checkNotNull(container, "container cannot be null");
        return new CustomData(container);
    }

    public static CustomData of(Entity entity) {
        Preconditions.checkNotNull(entity, "entity cannot be null");
        return of(entity.getPersistentDataContainer());
    }

    public static CustomData of(ItemStack block) {
        Preconditions.checkNotNull(block, "block cannot be null");
        Preconditions.checkNotNull(block.getItemMeta(), "block must have meta");
        Preconditions.checkNotNull(block.getItemMeta().getPersistentDataContainer(), "block must have custom data");
        CustomData customData = of(block.getItemMeta().getPersistentDataContainer());
        customData.potentialMeta = block.getItemMeta();
        return customData;
    }

    public void set(String key, String value) {
        Preconditions.checkNotNull(key, "key cannot be null");
        Preconditions.checkNotNull(value, "value cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        container.set(nKey, org.bukkit.persistence.PersistentDataType.STRING, value);
    }

    public void set(String key, int value) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        container.set(nKey, org.bukkit.persistence.PersistentDataType.INTEGER, value);
    }

    public void set(String key, double value) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        container.set(nKey, org.bukkit.persistence.PersistentDataType.DOUBLE, value);
    }

    public void set(String key, float value) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        container.set(nKey, org.bukkit.persistence.PersistentDataType.FLOAT, value);
    }

    public void set(String key, long value) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        container.set(nKey, org.bukkit.persistence.PersistentDataType.LONG, value);
    }

    public void set(String key, short value) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        container.set(nKey, org.bukkit.persistence.PersistentDataType.SHORT, value);
    }

    public void set(String key, byte value) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        container.set(nKey, org.bukkit.persistence.PersistentDataType.BYTE, value);
    }

    public void set(String key, boolean value) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        container.set(nKey, org.bukkit.persistence.PersistentDataType.BYTE, value ? (byte) 1 : (byte) 0);
    }

    public String getString(String key) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        return container.get(nKey, org.bukkit.persistence.PersistentDataType.STRING);
    }

    public int getInt(String key) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        Integer value = container.get(nKey, PersistentDataType.INTEGER);
        if (value == null) {
            return 0;
        }
        return value;
    }

    public double getDouble(String key) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        Double value = container.get(nKey, PersistentDataType.DOUBLE);
        if (value == null) {
            return 0;
        }
        return value;
    }

    public float getFloat(String key) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        Float value = container.get(nKey, PersistentDataType.FLOAT);
        if (value == null) {
            return 0;
        }
        return value;
    }

    public long getLong(String key) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Long value = container.get(nKey, PersistentDataType.LONG);
        if (value == null) {
            return 0;
        }
        return value;
    }

    public short getShort(String key) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Short value = container.get(nKey, PersistentDataType.SHORT);
        if (value == null) {
            return 0;
        }
        return value;
    }

    public byte getByte(String key) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Byte value = container.get(nKey, PersistentDataType.BYTE);
        if (value == null) {
            return 0;
        }
        return value;
    }

    public boolean getBoolean(String key) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Byte value = container.get(nKey, PersistentDataType.BYTE);
        if (value == null) {
            return false;
        }
        return value == 1;
    }

    public void remove(String key) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        container.remove(nKey);
    }

    public boolean has(String key) {
        Preconditions.checkNotNull(key, "key cannot be null");
        NamespacedKey nKey = NamespacedKey.fromString(key, Sunbeam.getPlugin());
        Preconditions.checkNotNull(nKey, "key cannot be null");
        return container.has(nKey, PersistentDataType.BYTE);
    }

    public void update(ItemStack item) {
        if (potentialMeta == null) {
            throw new IllegalStateException("Cannot update item without meta: CustomData was not created with an item");
        }
        item.setItemMeta(potentialMeta);
    }
}
