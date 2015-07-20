package com.bayley.destiny.listeners;

import com.bayley.destiny.Destiny;
import com.bayley.destiny.entities.EntityData;
import com.bayley.destiny.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by Bayley on 7/20/2015.
 */
public class EntityDamageByEntityListener implements Listener {

    @EventHandler()
    public void onEvent(EntityDamageByEntityEvent e) {

        if (e.getDamager() instanceof Snowball) { //check if the damager is a snowball

            if (Destiny.shotprojectiledata.containsKey(e.getDamager())) { //check if the snowball is one that is supposed to be doing a different damage

                EntityData eventdata = Destiny.shotprojectiledata.get(e.getDamager()); //get the data we stored about the projectile
                if (e.getEntity().getLocation().distance(eventdata.getFiredFrom())<=eventdata.getRange()) { //check to see if the event is taking place outside of the range
                Player p = (Player) eventdata.getFirer();
                //set the custom damage to the value stored earlier
                Destiny.shotprojectiledata.remove(e.getDamager()); //we can remove the projectile now so that the hashmap won't have unnecessary data in it.
                if(Utils.isHeadshot((Projectile) e.getDamager(), e.getEntity())) {
                    p.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "HEADSHOT -" + ChatColor.RESET + "" + ChatColor.GRAY + eventdata.getDamage() * eventdata.getHeadshotMultiplier() + " hp");
                    e.setDamage(eventdata.getDamage() * eventdata.getHeadshotMultiplier());
                }else {
                    p.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "-" + ChatColor.RESET + "" + ChatColor.GRAY + eventdata.getDamage() + " hp");
                    e.setDamage(eventdata.getDamage());
                }


                }
            }
        }
    }
}
