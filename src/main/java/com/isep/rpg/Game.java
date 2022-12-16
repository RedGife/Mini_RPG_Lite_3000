package com.isep.rpg;

import com.isep.rpg.enemy.BasicEnemy;
import com.isep.rpg.enemy.Boss;
import com.isep.rpg.enemy.Enemy;
import com.isep.rpg.hero.Hero;


import java.util.ArrayList;

public class Game
{
    public ArrayList<Hero> party = new ArrayList<Hero>();
    public ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    int playerTurn;
    boolean isPlayerTurn = true;

    // Génère un nombre d'ennemis égal au nombre de héros
    public void generateEnemies()
    {
        this.enemyList.add(new Boss());
        for (int i = 0; i < this.party.size() - 1; i++)
        {
            this.enemyList.add(new BasicEnemy());
        }
    }

    // TODO - revoir
    // Vérifie si l'entité est vivante (i.e à au moins 1 HP)
    public Boolean isEntityAlive(Entity entity)
    {
        if (entity.getHp() <= 0) { return false; }
        else { return true; }
    }

    public void setParty(ArrayList<Hero> list) {this.party = list;}

    public Game(){}
}
