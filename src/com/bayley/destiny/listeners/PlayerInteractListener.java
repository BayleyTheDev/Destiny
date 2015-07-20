package com.bayley.destiny.listeners;

import com.bayley.destiny.Destiny;
import com.bayley.destiny.entities.EntityData;
import com.bayley.destiny.utils.Utils;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftSnowball;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.BlockIterator;

import java.util.WeakHashMap;

/**
 * Created by Bayley on 7/20/2015.
 */
public class PlayerInteractListener implements Listener {


    @EventHandler()
    public void onEvent(PlayerInteractEvent e) {
        final Player p = (Player) e.getPlayer();


        if(p.getItemInHand().getType() == Material.SNOW_BALL) {
ItemMeta meta = (ItemMeta) p.getItemInHand().getItemMeta();
         //   for(int x = 0; x < meta.getLore().size(); x = x+1) {


           e.setCancelled(true);
            if(!Utils.hasCooldown(p)) {
                p.playSound(p.getLocation(), Sound.ZOMBIE_WOOD, 1, 2);

                Location location = p.getEyeLocation();
                BlockIterator blocksToAdd = new BlockIterator(location, 0D, 50);
                Location blockToAdd;
                Snowball projectile3 = p.launchProjectile(Snowball.class);
                projectile3.getVelocity().multiply(3);
                EntityData data = new EntityData(projectile3.getLocation(), 50, 5D, p, 2D, 2D);

                Destiny.shotprojectiledata.put(projectile3, data);
                while (blocksToAdd.hasNext()) {
                    blockToAdd = blocksToAdd.next().getLocation();
                    if (blockToAdd.getBlock().getType() != Material.AIR || !Destiny.shotprojectiledata.containsKey(projectile3)) {
                        break;
                    }
                    p.getWorld().playEffect(blockToAdd, Effect.SMOKE, 0);

                }
                Utils.addCooldown(p);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Destiny.plugin, new Runnable() {
                    public void run() {

                        Utils.removeCooldown(p);

                    }
                }, 35L);
                for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                    ((CraftPlayer) all).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(((CraftSnowball) projectile3).getHandle().getId()));

                }
            }
        }


    }
}
