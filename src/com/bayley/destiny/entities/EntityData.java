package com.bayley.destiny.entities;

import org.bukkit.Location;

/**
 * Created by Bayley on 7/20/2015.
 */
public class EntityData {
    private Location firedfrom;
    private Integer range;
    private Double damage;

    //constructor
    public EntityData(Location loc, Integer range, Double damage) {
        this.firedfrom = loc;
        this.range = range;
        this.damage = damage;
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
}