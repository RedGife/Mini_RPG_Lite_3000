package com.isep.rpg.hero.item;

public class Weapon {
    private int degats;
    private String nom;

    public Weapon(String n,int d){
        this.degats=d;
        this.nom =n;
    }
    public String getNom(){
        return nom;
    }
    public int getDegats(){
        return degats;
    }
}
