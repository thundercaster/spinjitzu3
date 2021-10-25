package me.thundercaster.spinjitzu;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class events implements Listener {
    Spinjitzu plugin;

    public events(Spinjitzu plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void move(PlayerMoveEvent e){
        Player player = e.getPlayer();
        Location location = player.getLocation();
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();


    }

    public void circle(){
        final double a = 0;
        new BukkitRunnable(){
            @Override
            public void run(){
                
            }
        }.runTaskTimerAsynchronously(Spinjitzu.getPlugin(), 0,1L);
    }
}
