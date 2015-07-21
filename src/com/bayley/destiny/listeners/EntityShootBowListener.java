package com.bayley.destiny.listeners;

import com.bayley.destiny.Destiny;
import com.bayley.destiny.entities.EntityData;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftSnowball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.BlockIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bayley on 7/20/2015.
 */
public class EntityShootBowListener implements Listener {
    @EventHandler
    public void onEvent(EntityShootBowEvent e) {
    if(e.getEntity() instanceof Skeleton) {

        Skeleton s = (Skeleton) e.getEntity();
        s.getWorld().playSound(s.getLocation(), Sound.ZOMBIE_WOOD, 1, 2);





        Location location = s.getEyeLocation();
        BlockIterator blocksToAdd = new BlockIterator(location, 0D, 50);
        Location blockToAdd;
        Snowball projectile3 = s.launchProjectile(Snowball.class, e.getProjectile().getVelocity());
e.getProjectile().remove();


        EntityData data = new EntityData(projectile3.getLocation(), 50, 5D, s, 2D, 2D);

        Destiny.shotprojectiledata.put(projectile3, data);
        while (blocksToAdd.hasNext()) {
            blockToAdd = blocksToAdd.next().getLocation();
            if (blockToAdd.getBlock().getType() != Material.AIR || !Destiny.shotprojectiledata.containsKey(projectile3)) {
                break;
            }
            s.getWorld().playEffect(blockToAdd, Effect.HAPPY_VILLAGER, 1);

        }
        for (Player all : Bukkit.getServer().getOnlinePlayers()) {
            ((CraftPlayer) all).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(((CraftSnowball) projectile3).getHandle().getId()));

        }
    }
    }
}
