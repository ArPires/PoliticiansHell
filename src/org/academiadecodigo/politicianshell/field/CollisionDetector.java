package org.academiadecodigo.politicianshell.field;

import org.academiadecodigo.politicianshell.Game;
import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.bullets.Bullet;

public class CollisionDetector {

    private Enemy[] enemies;

    public CollisionDetector(Enemy[] enemies) {
        this.enemies = enemies;
    }

    public void check(Bullet bullet, Game game) throws InterruptedException {

        for (int i = 0; i < enemies.length; i++) {

            int enemyX = bullet.bulletGetX() + bullet.bulletGetWidth();
            int enemyY = enemies[i].getEnemyGfxY() + enemies[i].getEnemyGfxHeight();
            int enemyMaxX = enemies[i].getEnemyGfxX() + enemies[i].getEnemyGfxWidth();

            boolean verifyY = bullet.bulletGetY() < enemyY;

            boolean verifyX = (enemyX > enemies[i].getEnemyGfxX());

            boolean verifyMaxX = (bullet.bulletGetX()) < enemyMaxX;

            if (verifyY && verifyX && verifyMaxX && !enemies[i].isDead() && !bullet.getHit()) {

                bullet.stop();
                bullet.hit(true);
                bullet.remove();
                bullet.splash();
                enemies[i].setDead(true);
                game.setEnemiesNumber(game.getEnemiesNumber() - 1);
                System.out.println(game.getScore());
                game.setScore(game.getScore()+1);

            }
        }
    }
}
