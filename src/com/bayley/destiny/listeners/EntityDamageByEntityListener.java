package com.bayley.destiny.listeners;

import com.bayley.destiny.Destiny;
import com.bayley.destiny.entities.EntityData;
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
                e.setDamage(eventdata.getDamage()); //set the custom damage to the value stored earlier
                Destiny.shotprojectiledata.remove(e.getDamager()); //we can remove the projectile now so that the hashmap won't have unnecessary data in it.
                }
            }
        }
    }
}
