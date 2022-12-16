package com.isep.rpg.hero;

import com.isep.rpg.hero.item.Weapon;

public class MagePotter extends Lanceur2Sort
{
    // Construct
    public MagePotter()
    {
        this.setHp(60000);
        this.setArmor(600);
        this.setManaPoints(11000);
        this.setSpellCost(500);
        this.setEntityDamage(5000);
    }
    public void add(Weapon m){
        int attack=getEntityDamage()+m.getDegats();
        setDegatsGlobaux(attack);
    }


    public String getType() { return "Mage"; }
}
