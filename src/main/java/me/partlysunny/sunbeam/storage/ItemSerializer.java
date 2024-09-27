package me.partlysunny.sunbeam.storage;

import me.partlysunny.sunbeam.misc.ConsoleLogger;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class ItemSerializer {

    public static String fromItem(ItemStack itemStack) {
        //Serialize the item(turn it into byte stream)
        ByteArrayOutputStream io = new ByteArrayOutputStream();
        try {
            BukkitObjectOutputStream os = new BukkitObjectOutputStream(io);
            os.writeObject(itemStack);
            os.flush();
        } catch (IOException e) {
            ConsoleLogger.error("Failed to serialize item: " + itemStack);
            return null;
        }

        byte[] serializedObject = io.toByteArray();

        //Encode the serialized object into to the base64 format
        return new String(Base64.getEncoder().encode(serializedObject));

    }

    public static ItemStack fromString(String base64) {
        byte[] serializedObject = Base64.getDecoder().decode(base64);

        //Input stream to read the byte array
        ByteArrayInputStream in = new ByteArrayInputStream(serializedObject);
        //object input stream to serialize bytes into objects
        BukkitObjectInputStream is;
        //Use the object input stream to deserialize an object from the raw bytes
        try {
            is = new BukkitObjectInputStream(in);
            return (ItemStack) is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

