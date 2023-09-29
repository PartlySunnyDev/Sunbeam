package me.partlysunny.sunbeam;

import org.bukkit.util.Transformation;

public class Displays {

    public static Transformation copy(Transformation original) {
        return new Transformation(original.getTranslation(), original.getLeftRotation(), original.getScale(), original.getRightRotation());
    }


}
