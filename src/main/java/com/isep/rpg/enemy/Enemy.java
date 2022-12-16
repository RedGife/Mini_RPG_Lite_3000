package com.isep.rpg.enemy;

import com.isep.rpg.Entity;
import com.isep.rpg.hero.Hero;

public abstract class Enemy extends Entity
{
    public void attack(Hero hero)
    {
        int damage = getDegatsGlobaux() - hero.getArmor();
        hero.substractHp(damage);
    }
}
