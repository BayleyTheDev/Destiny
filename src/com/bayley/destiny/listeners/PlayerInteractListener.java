package com.bayley.destiny.listeners;

import com.bayley.destiny.Destiny;
import com.bayley.destiny.entities.EntityData;
import net.minecraft.server.v1_8_R1.PacketPlayOutEntityDestroy;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftSnowball;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.BlockIterator;

import java.util.WeakHashMap;

/**
 * Created by Bayley on 7/20/2015.
 */
public class PlayerInteractListener implements Listener {


    @EventHandler()
    public void onEvent(PlayerInteractEvent e) {
        Player p = (Player) e.getPlayer();
        if(p.getItemInHand().getType() == Material.SNOW_BALL) {




            Location location = p.getEyeLocation();
            BlockIterator blocksToAdd = new BlockIterator(location, 0D, 15);
            Location blockToAdd;
            Snowball projectile = p.launchProjectile(Snowball.class);
            EntityData data = new EntityData(projectile.getLocation(), 15, 5D);
            Destiny.shotprojectiledata.put(projectile, data);
            while(blocksToAdd.hasNext()) {
                blockToAdd = blocksToAdd.next().getLocation();
                if (blockToAdd.getBlock().getType() != Material.AIR || !Destiny.shotprojectiledata.containsKey(projectile)) {
                    break;
                }
                p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, Material.FIRE);
            }
            for (Player all : Bukkit.getServer().getOnlinePlayers()) {
                ((CraftPlayer)all).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(((CraftSnowball) projectile).getHandle().getId()));
            }
        }


    }
}
