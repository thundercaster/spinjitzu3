package me.thundercaster.spinjitzu;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;
import java.util.UUID;

public class command implements CommandExecutor {
    Spinjitzu plugin;

    public command(Spinjitzu plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("on")) {
                    // Checks if the
                    if(plugin.getPlayerRunnables().containsKey(player.getUniqueId())) {
                        player.sendMessage("It's already enabled.");
                        return true;
                    }

                    player.sendMessage("On");
                    Map<UUID, BukkitRunnable> playerRunnables = plugin.getPlayerRunnables();
                    playerRunnables.put(player.getUniqueId(), createRunnable(player));
                    plugin.setPlayerRunnables(playerRunnables);
                    return true;
                }
                if (args[0].equalsIgnoreCase("off")) {
                    if(removeRunnable(player)) {
                        player.sendMessage("Off");
                    } else player.sendMessage("You never had it enabled.");
                }
            }
        }
        return true;
    }


    private BukkitRunnable createRunnable(Player player) {
        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {
                // all your fancy math stuff
                for (int i = 0; i<10; i++){
                    float y = (float) (0.2*i);
                    float r = (float) (0.2*i);

                    circle(r, y, player.getLocation(), player, 80);
                }
            }
        };
        runnable.runTaskTimerAsynchronously(plugin, 0, 1);
        return runnable;
    }


    private boolean removeRunnable(Player player) {
        if(plugin.getPlayerRunnables().containsKey(player.getUniqueId())) {
            plugin.getPlayerRunnables().get(player.getUniqueId()).cancel();

            Map<UUID, BukkitRunnable> playerRunnables = plugin.getPlayerRunnables();
            playerRunnables.remove(player.getUniqueId());
            plugin.setPlayerRunnables(playerRunnables);
            return true;
        }
        return false;
    }


    public void circle(float r, double y, Location l, Player p, int times){

        final double[] a = {0};
        for(int i = 0; i < times; i++) {

            double x = r*Math.cos(a[0]);
            double z = r*Math.sin(a[0]);
            p.spawnParticle(Particle.DRIP_LAVA, l.add(x,y,z), 0, x, 0 , z);
            a[0] = a[0] + 0.1;
            l.subtract(x,y,z);
        }
    }
}

