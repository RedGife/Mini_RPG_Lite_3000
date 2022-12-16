package com.isep.rpg.hero;

import com.isep.rpg.hero.item.Weapon;

public class Healheure extends Lanceur2Sort
{
    // Construct
    public Healheure()
    {
        this.setHp(50000);
        this.setArmor(8000);
        this.setManaPoints(10000);
        this.setSpellCost(300);
        this.setEntityDamage(3000);

    }
    public void add(Weapon he){
        int attack=getEntityDamage()+he.getDegats();
        this.setGlobalDamage(attack);
    }


    public String getType() { return "Healer"; }
}
