package me.partlysunny.sunbeam.menu;

import org.bukkit.entity.Player;

import java.util.function.Function;

public interface MenuProvider extends Function<Player, Menu> {
}
