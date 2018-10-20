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

            int enemyY = enemies[i].getEnemyGfxY() + enemies[i].getEnemyGfxHeight();
            int enemyMaxX = enemies[i].getEnemyGfxX() + enemies[i].getEnemyGfxWidth();

            System.out.println(enemyY + " enemy " + i);
            System.out.println(bullet.bulletGetY() + " bullet");

            // verify Y bullet is same
            boolean verifyY = bullet.bulletGetY() < (enemies[i].getEnemyGfxY() + enemies[i].getEnemyGfxHeight());
            // verify X bullet  is more than enemy
            boolean verifyX = (bullet.bulletGetX() + bullet.bulletGetWidth()) > enemies[i].getEnemyGfxX();
            // verify the max with of enemy
            boolean verifyMaxX = (bullet.bulletGetX()) < (enemies[i].getEnemyGfxX() + enemies[i].getEnemyGfxWidth());

            System.out.println(enemies[i].isDead()+ " n " + i);

            if (verifyY && verifyX && verifyMaxX && !enemies[i].isDead() && !bullet.getHit()) {
                System.out.println("hit");
                enemies[i].setDead(true);
                bullet.stop();
                bullet.hit(true);
                //remove bullet
                bullet.remove();
                // add points


            }

            /*if (bullet.bulletGetX() < (enemies[i].getEnemyGfxX() + enemies[i].getEnemyGfxWidth()) &&
                    (bullet.bulletGetX() + bullet.bulletGetWidth()) > enemies[i].getEnemyGfxX() &&
                    bullet.bulletGetY() == (enemies[i].getEnemyGfxY() + enemies[i].getEnemyGfxHeight())) {
                System.out.println("hit");
                enemies[i].setDead(true);
                enemies[i].isDead();
            }*/
        }

    }

}
