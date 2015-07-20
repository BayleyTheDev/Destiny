package com.bayley.destiny.utils;

import com.bayley.destiny.entities.EntityData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import com.bayley.destiny.entities.EntityData;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Bayley on 7/20/2015.
 */
public class Utils {
    public final static boolean isHeadshot(Projectile a, Entity e) {
        double y = a.getLocation().getY();
        double y2 = ((LivingEntity) e).getEyeLocation().getY();
        double distance = Math.abs(y - y2);
        return distance <= 0.5D;
    }

    final static ArrayList<String> cooldowns = new ArrayList<String>();



    public final static boolean hasCooldown(Player player){
        return cooldowns.contains(player.getName());
    }
    public final static void addCooldown(Player player) {

        cooldowns.add(player.getName());
    }

    public final static void removeCooldown(Player player) {

        cooldowns.remove(player.getName());
    }
}
