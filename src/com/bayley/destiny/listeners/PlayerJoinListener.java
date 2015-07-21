package com.bayley.destiny.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Bayley on 7/21/2015.
 */
public class PlayerJoinListener implements Listener {

    @EventHandler()
    public void onEvent(PlayerJoinEvent e) {
        e.getPlayer().setMaxHealth(200);
        e.getPlayer().setHealth(200);
    }
}
