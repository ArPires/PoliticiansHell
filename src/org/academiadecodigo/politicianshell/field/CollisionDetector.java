package org.academiadecodigo.politicianshell.field;

import org.academiadecodigo.politicianshell.Game;
import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.player.Player;
import org.academiadecodigo.politicianshell.bullets.Bullet;

public class CollisionDetector {

    private Enemy[] enemies;
    private Player player;

    public CollisionDetector(Enemy[] enemies) {
        this.enemies = enemies;
    }

    public void check(Bullet bullet, Game game) throws InterruptedException {

        for (int i = 0; i < enemies.length; i++) {

            int enemyY = enemies[i].getEnemyGfxY() + enemies[i].getEnemyGfxHeight();
            int enemyMaxX = enemies[i].getEnemyGfxX() + enemies[i].getEnemyGfxWidth();

            // verify Y bullet is same
            boolean verifyY = bullet.bulletGetY() < (enemies[i].getEnemyGfxY() + enemies[i].getEnemyGfxHeight());

            // verify X bullet  is more than enemy
            boolean verifyX = (bullet.bulletGetX() + bullet.bulletGetWidth()) > enemies[i].getEnemyGfxX();

            // verify the max with of enemy
            boolean verifyMaxX = (bullet.bulletGetX()) < (enemies[i].getEnemyGfxX() + enemies[i].getEnemyGfxWidth());

            if (verifyY && verifyX && verifyMaxX && !enemies[i].isDead() && !bullet.getHit()) {

                bullet.stop();
                bullet.hit(true);
                bullet.remove();
                bullet.splash();
                enemies[i].setDead(true);
                game.setEnemiesNumber(game.getEnemiesNumber() - 1);
            }
        }
    }

   /* public boolean checkPlayer(Player player) throws InterruptedException {
        if(player.getLife() == 0) {
            System.out.println("GAME OVER");
        }
        for(int i = 0; i < enemies.length; i++) {
            if((enemies[i].getEnemyGfxY() + enemies[i].getEnemyGfxHeight()) > player.getY()) {
                player.setLife(player.getLife() - 1);
                System.out.println(player.getLife());
                return true;
            }
        }
        return false;

    }*/

}
