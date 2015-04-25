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
    ///Hello
    //Test
    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        getLogger().info("Minecraft Roleplay TTT has been launched.");
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Minecraft Roleplay TTT registered events.");
    }
    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.YELLOW + event.getPlayer().getName() + ChatColor.RESET + " has connected to Minecraft Roleplay.");


    }


}
