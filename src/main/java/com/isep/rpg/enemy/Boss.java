package com.isep.rpg.enemy;

public class Boss extends Enemy
{
    // Construct
    public  Boss()
    {
        this.setHp(200000);
        this.setGlobalDamage(20000);
    }

    public String getType() { return "Boss"; }
}
