package org.academiadecodigo.politicianshell;

import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.enemies.EnemyType;
import org.academiadecodigo.politicianshell.field.CollisionDetection;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.player.Player;
import org.academiadecodigo.politicianshell.weapons.Bullet;

import java.util.LinkedList;

public class Game {

    private CollisionDetection collisionDetection;
    private Field field;
    private Player player;
    private Enemy[] enemies;
    private LinkedList<Bullet> listBullets;
    private Bullet bullet;

    public Game() {
        field = new Field();
    }

    public void init() {

        field.init();

        enemies = createEnemies(45, 20, 50);

        collisionDetection = new CollisionDetection(enemies);

        player = new Player(Field.WIDTH / 2 - 15, Field.HEIGHT - 100, 30, 40);

        listBullets = new LinkedList<Bullet>();

    }

    public void addBulletInGame(Bullet bullet) {
        listBullets.add(bullet);
    }

    private Enemy[] createEnemies(int enemyNumber, int x, int y) {
        //int x = 0;
        //int y = 50;

        Enemy[] enemiesTemp = new Enemy[enemyNumber];

        for (int i = 0; i < enemyNumber; i++) {
            if (i == 15 || i == 30) {
                y += 30;
                x = 20;
            }
            enemiesTemp[i] = new Enemy(EnemyType.MINION_POLITICIAN, x, y);
            x += 30;
        }

        return enemiesTemp;
    }


    public void start() throws InterruptedException {

        while (true) {

            player.move();

            if (player.getShooting()) {
                listBullets.add(player.shoot());

            }

            for (Bullet bullet : listBullets) {
                if (bullet.getFired()) {
                    player.loadBullet(bullet);
                    listBullets.remove(bullet);
                }
                bullet.move();
                bullet.stop();

            }

            // the time of enemies movement

            moveAllPoliticians();


            Thread.sleep(100);

        }
    }

    public void moveAllPoliticians() {

        for (Enemy enemy : enemies) {

            enemy.movePoliticians();

        }
        for (Bullet bullet : listBullets) {
            collisionDetection.check(bullet);
        }


    }
}
