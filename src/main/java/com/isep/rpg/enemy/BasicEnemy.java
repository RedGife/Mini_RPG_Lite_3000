package com.isep.rpg.enemy;

public class BasicEnemy extends Enemy
{
    // Construct
    public BasicEnemy()
    {
        this.setHp(30000);
        this.setDegatsGlobaux(5000);
    }

    public String getType() { return "Sbires"; }
}
