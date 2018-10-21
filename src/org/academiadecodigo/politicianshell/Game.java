package org.academiadecodigo.politicianshell;

import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.enemies.EnemyType;
import org.academiadecodigo.politicianshell.field.CollisionDetector;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.player.Player;
import org.academiadecodigo.politicianshell.bullets.Bullet;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

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
    private Text gameOverText;
    private Text roundOverText;
    private int round = 1;

    public Game(){

        gameField = new Field();
        menu = new Menu();
        gameField.init();
        gameOverText = new Text(250,350, "GAME OVER");
        gameOverText.setColor(Color.BLACK);
        gameOverText.grow(100, 50);




        /*enemies = createEnemies(40, 20, 50);
        player = new Player();
        collisionDetection = new CollisionDetector(enemies);
        bulletList = new LinkedList<Bullet>();*/
        //gameField.init();
        player = new Player();


    }

    public void preGame() throws InterruptedException {

        gameStatus = Status.MENU;
        gameStatus = menu.play();

        if (gameStatus == Status.QUIT) {
            System.exit(0);
        }

        if (gameStatus == Status.PLAY) {
            //init();
        }
    }

    public void init() throws InterruptedException {

        if(player.getLife() != 0) {
            roundOverText = new Text(250, 350, ("ROUND " + round));
            roundOverText.setColor(Color.BLACK);
            roundOverText.grow(100, 50);
            roundOverText.draw();
            Thread.sleep(1000);
            roundOverText.delete();
        }
        if(player.getLife() == 0) {
            gameOverText.draw();
            return;
        }

        player.showPlayer();

        enemies = createEnemies(40, 20, 50);

        //player = new Player(Field.WIDTH/2 - 15, Field.HEIGHT - 100, 30, 40);

        bulletList = new LinkedList<Bullet>();

        collisionDetection = new CollisionDetector(enemies);

        //player = new Player(Field.WIDTH / 2 - 15, Field.HEIGHT - 100, 30, 40);

    }

    public void addBulletInGame(Bullet bullet) {
        bulletList.add(bullet);
    }

    private Enemy[] createEnemies(int enemyNumber, int x, int y) {

        Enemy[] enemiesTemp = new Enemy[enemyNumber];

        for (int i = 0; i < enemyNumber; i++) {
            if (i % 10 == 0) {
                y += 50;
                x = 20;
            }
            enemiesTemp[i] = new Enemy(EnemyType.MINION_POLITICIAN, x, y);
            x += 45;
        }

        return enemiesTemp;
    }

    public void start() throws InterruptedException {

        while (true) {



            player.move();

            if (player.getReadyToNextShoot()) {

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

    public void moveAllEnemies() throws InterruptedException {

        for (Enemy enemy : enemies) {
            if(player.getLife() == 0) {
                deleteBullets();
                player.hidePlayer();
                deleteEnemies();

                return;
            }
            if((enemy.getEnemyGfxY() + enemy.getEnemyGfxHeight()) > player.getY()) {
                player.setLife(player.getLife() - 1);
                round++;
                System.out.println(player.getLife());

                deleteBullets();
                deleteEnemies();


                init();
                start();

                return;
            }
            enemy.moveEnemy();

        }

        for (Bullet bullet : bulletList) {
            collisionDetection.check(bullet);
        }
    }

    public void deleteEnemies() {
        for(Enemy enemy : enemies) {
            enemy.setDead(true);
        }
    }

    public void deleteBullets() {
        for(Bullet bullet : bulletList) {
            bullet.remove();
        }
    }

    public enum Status {

        MENU,
        PLAY,
        QUIT

    }
}
