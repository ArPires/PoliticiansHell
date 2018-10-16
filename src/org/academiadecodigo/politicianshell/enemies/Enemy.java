package org.academiadecodigo.politicianshell.enemies;

import org.academiadecodigo.politicianshell.field.Position;
import org.academiadecodigo.politicianshell.weapons.Weapon;
import org.academiadecodigo.politicianshell.weapons.WeaponType;

abstract public class Enemy {

    private EnemyType enemyType;
    private Position position;
    private Boolean dead;

    public Enemy (EnemyType enemyType, int health){
        this.enemyType = enemyType;
    }
    public abstract Position move();

    public void hit(Weapon weapon){

        enemyType.getHealth() > WeaponType.getBullets()? health - WeaponType.getBullets():0;


        if(health == 0) {
        dead = true;
        System.out.println("This enemy is dead!");
        }
    }

    public boolean isDead(){
        return this.dead;
    }

}
