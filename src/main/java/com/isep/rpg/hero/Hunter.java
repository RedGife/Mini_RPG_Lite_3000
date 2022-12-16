package com.isep.rpg.hero;

import com.isep.rpg.enemy.Enemy;
import com.isep.rpg.hero.item.Weapon;

public class Hunter extends Hero
{
    int fleches;

    public int getFleches() { return fleches; }

    @Override
    public void attack(Enemy enemy)
    {
        super.attack(enemy);
        this.fleches -=1;
    }
    public void add(Weapon h){
        int attack=getEntityDamage()+h.getDegats();
        setDegatsGlobaux(attack);
    }


    public Hunter()
    {
        this.setHp(70000);
        this.fleches = 20;
        this.setArmor(1000);
        this.setEntityDamage(4000);
    }

    public String getType() { return "Hunter"; }
}
