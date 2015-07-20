package com.bayley.destiny;

import com.bayley.destiny.entities.EntityData;
import com.bayley.destiny.listeners.EntityDamageByEntityListener;
import com.bayley.destiny.listeners.PlayerInteractListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
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

