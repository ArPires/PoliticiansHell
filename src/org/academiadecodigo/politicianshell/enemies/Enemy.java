package org.academiadecodigo.politicianshell.enemies;


import org.academiadecodigo.politicianshell.weapons.Bullet;

abstract public class Enemy {

    private EnemyType enemyType;
    private boolean dead;
    //private BulletType bulletType;
    private int currentHealth;

    public Enemy (EnemyType enemyType){
        this.enemyType = enemyType;
        currentHealth = enemyType.getHealth();
    }

    public void hit(Bullet bullet){

        //currentHealth = enemyType.getHealth() > weaponType.getBulletPower() ? currentHealth - weaponType.getBulletPower() : 0;


        if(currentHealth == 0) {
        dead = true;
        System.out.println("This enemy is dead!");
        }
    }

    public boolean isDead(){
        return this.dead;
    }

}
