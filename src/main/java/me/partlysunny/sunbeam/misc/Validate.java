package me.partlysunny.sunbeam.misc;

public final class Validate {

    public static String notEmpty(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("String must not be empty");
        }
        return string;
    }

}
