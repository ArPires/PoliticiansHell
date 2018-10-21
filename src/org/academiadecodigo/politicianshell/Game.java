package org.academiadecodigo.politicianshell;

import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.enemies.EnemyType;
import org.academiadecodigo.politicianshell.enemies.EvilPolitician;
import org.academiadecodigo.politicianshell.enemies.MinionPolitician;
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
    private int enemiesNumber;
    private Field gameField;
    private Status gameStatus;
    private Menu menu;
    private LinkedList<Bullet> bulletList;
    private Bullet bullet;
    private Text gameOverText;
    private Text roundOverText;
    private Text winningText;
    private int round = 1;

    public Game() {


        gameField = new Field();
        menu = new Menu();
        gameField.init();
        gameOverText = new Text(250, 350, "GAME OVER");
        gameOverText.setColor(Color.BLACK);
        gameOverText.grow(100, 50);
        winningText = new Text(250, 350, "YOU WON!!!");
        winningText.setColor(Color.BLACK);
        winningText.grow(100, 50);
        bulletList = new LinkedList<>();
        player = new Player();


    }

    public void preGame() throws InterruptedException {

        gameStatus = Status.MENU;
        gameStatus = menu.play();

        if (gameStatus == Status.QUIT) {
            System.exit(0);
        }
    }

    public void init() throws InterruptedException {


        enemiesNumber = 42;
        if (player.getLife() != 0) {
            roundOverText = new Text(250, 350, ("ROUND " + round));
            roundOverText.setColor(Color.BLACK);
            roundOverText.grow(100, 50);
            roundOverText.draw();
            Thread.sleep(1000);
            roundOverText.delete();
        }
        if (player.getLife() == 0) {
            gameOverText.draw();
            return;
        }

        player.showPlayer();

        enemies = createEnemies(enemiesNumber);

        bulletList = new LinkedList<>();

        collisionDetection = new CollisionDetector(enemies);


    }

    private Enemy[] createEnemies(int enemyNumber) {


        int x = 20;
        int y = 70;
        Enemy[] enemiesTemp = new Enemy[enemiesNumber];

        enemiesTemp[enemyNumber - 1] = new EvilPolitician(EnemyType.EVIL_POLITICIAN, 150, 10);
        enemiesTemp[enemyNumber - 2] = new EvilPolitician(EnemyType.EVIL_POLITICIAN, 350, 10);

        for (int i = 0; i < enemyNumber - 2; i++) {
            if (i % 10 == 0) {
                y += 50;
                x = 20;
            }
            enemiesTemp[i] = new MinionPolitician(EnemyType.MINION_POLITICIAN, x, y);
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
            if (player.getLife() == 0) {
                deleteBullets();
                player.hidePlayer();
                deleteEnemies();

                return;
            }
            if (enemiesNumber == 0){

            }
            if ((enemy.getEnemyGfxY() + enemy.getEnemyGfxHeight() + 5) >= player.getY() && enemiesNumber != 0) {
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
            collisionDetection.check(bullet, this);
        }
    }

    public void deleteEnemies() {
        for (Enemy enemy : enemies) {
            if(enemy instanceof EvilPolitician)  {
               ((EvilPolitician) enemy).setCorruptionLevel(0);
            }
            enemy.setDead(true);
        }

    }

    public void deleteBullets() {
        for (Bullet bullet : bulletList) {
            bullet.remove();
        }
    }

    public int getEnemiesNumber() {
        return enemiesNumber;
    }

    public void setEnemiesNumber(int enemiesNumber) {
        this.enemiesNumber = enemiesNumber;
    }

    public enum Status {

        MENU,
        PLAY,
        QUIT

    }
}
