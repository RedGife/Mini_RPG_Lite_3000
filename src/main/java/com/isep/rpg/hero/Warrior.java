package com.isep.rpg.hero;

import com.isep.rpg.hero.item.Weapon;

public class Warrior extends Hero
{
    // Construct
    public Warrior()
    {
        this.setHp(100000);
        this.setArmor(1000);
        this.setEntityDamage(6000);
    }
    public void add(Weapon w){
        int attack=getEntityDamage()+w.getDegats();
        setDegatsGlobaux(attack);
    }


    public String getType() { return "Warrior"; }
}
