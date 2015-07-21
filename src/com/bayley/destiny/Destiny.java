package com.bayley.destiny;

import com.bayley.destiny.entities.EntityData;
import com.bayley.destiny.listeners.EntityDamageByEntityListener;
import com.bayley.destiny.listeners.EntityShootBowListener;
import com.bayley.destiny.listeners.PlayerInteractListener;
import com.bayley.destiny.listeners.PlayerJoinListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.WeakHashMap;

/**
 * Created by Bayley on 7/20/2015.
 */
public class Destiny extends JavaPlugin{
    public static Destiny plugin;



    //#####DEFINES#####\\
    public final static WeakHashMap<Entity, EntityData> shotprojectiledata = new WeakHashMap<Entity, EntityData>();



    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        plugin = this;

        pm.registerEvents(new PlayerInteractListener(), this);
        pm.registerEvents(new EntityDamageByEntityListener(), this);
        pm.registerEvents(new EntityShootBowListener(), this);
        pm.registerEvents(new PlayerJoinListener(), this);


    }

    @Override
    public void onDisable() {



    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("test")){


        }
        return false;
    }
}

