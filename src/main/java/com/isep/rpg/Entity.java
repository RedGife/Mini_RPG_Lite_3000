package com.isep.rpg;

public abstract class Entity
{
    private int lifePoints;
    private static int weaponDamage;

    private int attack;

    private static int entityDamage;

    // Init

    public int getHp() { return this.lifePoints; }
    public void setHp(int hp) { this.lifePoints = hp; }
    public int substractHp(int damage)
    {
        this.lifePoints -= damage;
        return damage;
    }
    public int attack(){
        return this.attack;
    }
    public int getDegatsGlobaux() { return degatsGlobaux;}
    public void setDegatsGlobaux(int degatsGlobaux) { this.degatsGlobaux = degatsGlobaux; }

    public void setEntityDamage(int entityDamage) {
        Entity.entityDamage = entityDamage;}

    public static int getEntityDamage(){
        return entityDamage;
    }

    public abstract String getType();

    public int degatsGlobaux;

    public boolean isAlive()
    {
        return this.lifePoints <= 0 ? false : true;
    }

}
