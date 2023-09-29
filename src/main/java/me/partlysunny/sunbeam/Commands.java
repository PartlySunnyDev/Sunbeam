package me.partlysunny.sunbeam;

import me.partlysunny.sunbeam.misc.ConsoleLogger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class Commands {

    private static CommandMap commandMap = null;

    private Commands() {
        throw new AssertionError("Cannot instantiate Commands");
    }

    public static void init(JavaPlugin plugin) {
        try {
            Field f;
            f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            f.setAccessible(true);
            Commands.commandMap = (CommandMap) f.get(Bukkit.getServer());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            ConsoleLogger.error("Error initializing Commands");
        }
    }

    public static void registerCommand(Command command) {
        commandMap.register(command.getName(), command);
    }

    public static Player playerChecks(CommandSender sender) {
        return playerChecks(sender, new ArrayList<>(), ChatColor.RED + "You do not have permission to use this command.", ChatColor.RED + "You must be a player to use this command.");
    }

    public static Player playerChecks(CommandSender sender, List<String> permissions) {
        return playerChecks(sender, permissions, ChatColor.RED + "You do not have permission to use this command.", ChatColor.RED + "You must be a player to use this command.");
    }

    public static Player playerChecks(CommandSender sender, List<String> permissions, String noPermissionMessage, String notPlayerMessage) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(notPlayerMessage);
            return null;
        }
        for (String permission : permissions) {
            if (!sender.hasPermission(permission)) {
                sender.sendMessage(noPermissionMessage);
                return null;
            }
        }
        return (Player) sender;
    }

    public static void sendUsage(CommandSender sender, String usage) {
        sender.sendMessage(ChatColor.RED + "Correct Usage: " + usage);
    }

}
