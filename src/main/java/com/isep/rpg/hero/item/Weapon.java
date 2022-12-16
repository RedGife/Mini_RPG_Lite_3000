package com.isep.rpg.hero.item;

public class Weapon {
    private int degats;
    private String name;

    public Weapon(String n,int d){
        this.degats=d;
        this.name=n;
    }
    public String getName(){
        return name;
    }
    public int getDegats(){
        return degats;
    }
}
