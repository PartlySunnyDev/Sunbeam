package me.partlysunny.sunbeam;

import org.bukkit.Location;
import org.bukkit.entity.Display;
import org.bukkit.entity.Player;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class Displays {

    public static Transformation copy(Transformation original) {
        return new Transformation(new Vector3f(original.getTranslation()), new Quaternionf(original.getLeftRotation()), new Vector3f(original.getScale()), new Quaternionf(original.getRightRotation()));
    }

    public static void scale(Transformation transformation, float scale) {
        transformation.getScale().mul(scale);
    }

    public static void scale(Transformation transformation, float x, float y, float z) {
        transformation.getScale().mul(x, y, z);
    }

    public static <T extends Display> T summonDisplay(Location location, Class<T> displayClass) {
        assert location.getWorld() != null;
        return location.getWorld().spawn(location, displayClass);
    }


}
