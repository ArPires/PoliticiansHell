package org.academiadecodigo.politicianshell.field;

import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.player.Player;
import org.academiadecodigo.politicianshell.weapons.Bullet;

public class CollisionDetection {

    private Bullet bullet;
    private Enemy[] enemies;
    private Player player;

    public CollisionDetection(Enemy[] enemies) {

        this.enemies = enemies;

    }

    public void check(Bullet bullet) {


        for (int i = 0; i < enemies.length; i++) {
/*
            int eX = enemies[i].getEnemyGfxX();
            int eY = enemies[i].getEnemyGfxY();
            int eW = enemies[i].getEnemyGfxWidth();
            int eH = enemies[i].getEnemyGfxHeight();

            int y = enemies[i].getEnemyGfxY() + enemies[i].getEnemyGfxHeight();
            int x = enemies[i].getEnemyGfxX() + enemies[i].getEnemyGfxWidth();

            System.out.println(y + " enemy " + i);
            System.out.println(bullet.bulletGetX()+" bullet");
            //System.out.println(eX + " - " + eY + " - " + eW + " - " + eH);
            //System.out.println(bullet.bulletGetX() + "buX");
            //System.out.println(bullet.bulletGetY() + "buY");
            if (y > bullet.bulletGetY()){
                System.out.println("hit");
            }*/
            System.out.println(bullet.bulletGetY());
            System.out.println(enemies[i].getEnemyGfxY()+" en");
            if (bullet.bulletGetY() < enemies[i].getEnemyGfxY() && bullet.bulletGetWidth()){
                System.out.println("hit");

            }

            if (bullet.bulletGetX() < (enemies[i].getEnemyGfxX() + enemies[i].getEnemyGfxWidth()) &&
                    (bullet.bulletGetX() + bullet.bulletGetWidth()) > enemies[i].getEnemyGfxX() &&
                    bullet.bulletGetY() == (enemies[i].getEnemyGfxY() + enemies[i].getEnemyGfxHeight())) {
                System.out.println("hit");
                enemies[i].setDead(true);
                enemies[i].isDead();
            }
        }

    }

}
