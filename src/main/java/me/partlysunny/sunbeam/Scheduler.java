package me.partlysunny.sunbeam;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public final class Scheduler {

    private static JavaPlugin plugin;

    private Scheduler() {
        throw new AssertionError("Cannot instantiate Scheduler");
    }

    public static void init(JavaPlugin plugin) {
        Scheduler.plugin = plugin;
    }

    public static void scheduleRepeatingCancelTask(Runnable r, long delay, long repeat, long stopAfter) {
        BukkitScheduler scheduler = Bukkit.getScheduler();
        BukkitTask t = scheduler.runTaskTimer(plugin, r, delay, repeat);
        scheduler.runTaskLater(plugin, t::cancel, stopAfter);
    }

    public static BukkitTask runTaskTimer(Runnable update, int tickDelay, int tickInterval) {
        return Bukkit.getScheduler().runTaskTimer(plugin, update, tickDelay, tickInterval);
    }

    public static BukkitTask runTaskLater(Runnable update, int tickDelay) {
        return Bukkit.getScheduler().runTaskLater(plugin, update, tickDelay);
    }

    public static BukkitTask runTask(Runnable update) {
        return Bukkit.getScheduler().runTask(plugin, update);
    }

    public static BukkitTask runTaskAsync(Runnable update) {
        return Bukkit.getScheduler().runTaskAsynchronously(plugin, update);
    }
}
