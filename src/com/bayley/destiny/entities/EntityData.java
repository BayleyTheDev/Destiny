package com.bayley.destiny.entities;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * Created by Bayley on 7/20/2015.
 */
public class EntityData {
    private Location firedfrom;
    private Integer range;
    private Double damage;
    private Double hsmultiplier;
    private Entity firer;

    //constructor
    public EntityData(Location loc, Integer range, Double damage, Entity firer, Double hsmultiplier, Double cooldown) {
        this.firedfrom = loc;
        this.range = range;
        this.damage = damage;
        this.firer = firer;
        this.hsmultiplier = hsmultiplier;

    }
    public Location getFiredFrom() {
        return firedfrom;
    }
    public Integer getRange() {
        return range;
    }
    public Double getDamage() {
        return damage;
    }
    public Entity getFirer() {

        return firer;
    }
    public Double getHeadshotMultiplier() {

        return hsmultiplier;
    }

}