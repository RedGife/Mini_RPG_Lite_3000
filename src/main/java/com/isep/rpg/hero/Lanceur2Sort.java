package com.isep.rpg.hero;

import com.isep.rpg.enemy.Enemy;

public abstract class Lanceur2Sort extends Hero
{
    private int manaPoints, spellCost;

    public void setManaPoints(int mp) { this.manaPoints = mp; }
    public int getManaPoints() { return this.manaPoints; }

    public void setSpellCost(int sp) { this.spellCost = sp; }
    public int getSpellCost() { return spellCost; }

    @Override
    public void attack(Enemy enemy)
    {
        super.attack(enemy);
        this.manaPoints -= this.spellCost;
    }
}
