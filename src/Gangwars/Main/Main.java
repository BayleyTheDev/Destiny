package Gangwars.Main;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;



/**
 * Created by Bayley on 4/24/2015.
 */
public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        getLogger().info("Destiny has been launched.");
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Destiny registered events.");
    }
    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.RESET + " has connected to Minecraft Roleplay.");

        event.getPlayer().getInventory().clear();
        event.getPlayer().sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Hello," + ChatColor.RESET + "" + ChatColor.YELLOW + " and welcome to the home of the Minecraft Roleplay Gamemode. Which is currently in the beta stage. Please wait around for the next game to start!");
    }


}
