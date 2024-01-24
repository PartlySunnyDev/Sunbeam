package me.partlysunny.sunbeam;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public final class Vectors {

    public static double getXZDistance(Location loc1, Location loc2) {
        return Math.sqrt(Math.pow(loc1.getX() - loc2.getX(), 2) + Math.pow(loc1.getZ() - loc2.getZ(), 2));
    }

    public static double getDistance(Location loc1, Location loc2) {
        return Math.sqrt(Math.pow(loc1.getX() - loc2.getX(), 2) + Math.pow(loc1.getY() - loc2.getY(), 2) + Math.pow(loc1.getZ() - loc2.getZ(), 2));
    }

    public static double getXZDistanceSquared(Location loc1, Location loc2) {
        return Math.pow(loc1.getX() - loc2.getX(), 2) + Math.pow(loc1.getZ() - loc2.getZ(), 2);
    }

    public static double getDistanceSquared(Location loc1, Location loc2) {
        return Math.pow(loc1.getX() - loc2.getX(), 2) + Math.pow(loc1.getY() - loc2.getY(), 2) + Math.pow(loc1.getZ() - loc2.getZ(), 2);
    }

    public static double getXZDistance(Vector vec1, Vector vec2) {
        return Math.sqrt(Math.pow(vec1.getX() - vec2.getX(), 2) + Math.pow(vec1.getZ() - vec2.getZ(), 2));
    }

    public static double getDistance(Vector vec1, Vector vec2) {
        return Math.sqrt(Math.pow(vec1.getX() - vec2.getX(), 2) + Math.pow(vec1.getY() - vec2.getY(), 2) + Math.pow(vec1.getZ() - vec2.getZ(), 2));
    }

    public static double getXZDistanceSquared(Vector vec1, Vector vec2) {
        return Math.pow(vec1.getX() - vec2.getX(), 2) + Math.pow(vec1.getZ() - vec2.getZ(), 2);
    }

    public static double getDistanceSquared(Vector vec1, Vector vec2) {
        return Math.pow(vec1.getX() - vec2.getX(), 2) + Math.pow(vec1.getY() - vec2.getY(), 2) + Math.pow(vec1.getZ() - vec2.getZ(), 2);
    }

    public static double getXZDistance(double x1, double z1, double x2, double z2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(z1 - z2, 2));
    }

    public static double getDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
    }

    public static double getXZDistanceSquared(double x1, double z1, double x2, double z2) {
        return Math.pow(x1 - x2, 2) + Math.pow(z1 - z2, 2);
    }

    public static double getDistanceSquared(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2);
    }

}
