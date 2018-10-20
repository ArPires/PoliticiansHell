package org.academiadecodigo.politicianshell;

import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.enemies.EnemyType;
import org.academiadecodigo.politicianshell.field.CollisionDetector;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.player.Player;
import org.academiadecodigo.politicianshell.bullets.Bullet;
import java.util.LinkedList;

public class Game {

    private CollisionDetector collisionDetection;
    private Player player;
    private Enemy[] enemies;
    private Field gameField;
    private Status gameStatus;
    private Menu menu;
    private LinkedList<Bullet> bulletList;
    private Bullet bullet;

    public Game(){

        gameField = new Field();
        menu = new Menu();

    }

    public void preGame() throws InterruptedException {

        gameStatus = Status.MENU;
        gameStatus = menu.play();

        if (gameStatus == Status.QUIT) {
            System.exit(0);
        }

        if (gameStatus == Status.PLAY) {
            init();
        }
    }

    public void init() {

        gameField.init();

        enemies = createEnemies(45, 20, 50);

        //player = new Player(Field.WIDTH/2 - 15, Field.HEIGHT - 100, 30, 40);
        player = new Player();

        collisionDetection = new CollisionDetector(enemies);

        //player = new Player(Field.WIDTH / 2 - 15, Field.HEIGHT - 100, 30, 40);

        bulletList = new LinkedList<Bullet>();
    }

    public void addBulletInGame(Bullet bullet) {
        bulletList.add(bullet);
    }

    private Enemy[] createEnemies(int enemyNumber, int x, int y) {

        Enemy[] enemiesTemp = new Enemy[enemyNumber];

        for (int i = 0; i < enemyNumber; i++) {
            if (i % 15 == 0) {
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

            if (player.getTrigger()) {

                bulletList.add(player.shoot());

            }

            for (Bullet bullet : bulletList) {

                if (bullet.getFired()) {

                    player.loadBullet(bullet);
                    bulletList.remove(bullet);

                }

                bullet.move();
                bullet.stop();

            }

            moveAllEnemies();

            Thread.sleep(100);

        }
    }

    public void moveAllEnemies() {

        for (Enemy enemy : enemies) {
            enemy.moveEnemy();
        }

        for (Bullet bullet : bulletList) {
            collisionDetection.check(bullet);
        }
    }

    public enum Status {

        MENU,
        PLAY,
        QUIT

    }
}
