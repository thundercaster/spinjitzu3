package me.thundercaster.spinjitzu;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public final class Spinjitzu extends JavaPlugin {
    
    //Credit to Adelemphii for helping a lot with BukkitRunnables and classes to solve the problems encountered with the plugin.
    //A personal thank you :)
    private Map<UUID, BukkitRunnable> playerRunnables = new HashMap<>();

    private static Spinjitzu plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("spinjitzu").setExecutor(new command(this));

    }
    public static Spinjitzu getPlugin() {
        return plugin;
    }
    public Map<UUID, BukkitRunnable> getPlayerRunnables() {
        return playerRunnables;
    }


    public void setPlayerRunnables(Map<UUID, BukkitRunnable> playerRunnables) {
        this.playerRunnables = playerRunnables;
    }



}
