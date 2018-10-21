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

    public Game(){

        enemiesNumber = 42;
        gameField = new Field();
        menu = new Menu();
        gameField.init();
        gameOverText = new Text(250,350, "GAME OVER");
        gameOverText.setColor(Color.RED);
        gameOverText.grow(100, 50);


        /*minionPoliticians = createEnemies(40, 20, 50);
        player = new Player();
        collisionDetection = new CollisionDetector(minionPoliticians);
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

    public void init() {

        /*if(player.getLife() == 0) {
            System.out.println("GAME OVER");
            return;
        }*/

        player.showPlayer();

        enemies = createEnemies(enemiesNumber);
        //player = new Player(Field.WIDTH/2 - 15, Field.HEIGHT - 100, 30, 40);

        bulletList = new LinkedList<Bullet>();

        collisionDetection = new CollisionDetector(enemies);

        //player = new Player(Field.WIDTH / 2 - 15, Field.HEIGHT - 100, 30, 40);

    }

    /*public void addBulletInGame(Bullet bullet) {
        bulletList.add(bullet);
    }*/

    private Enemy[] createEnemies(int enemyNumber) {

        int x = 20;
        int y = 70;

        Enemy[] enemiesTemp = new  Enemy[enemiesNumber];

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



    /*private EvilPolitician[] createEvilPolitician(int evilPoliticianNumber, int x, int y) {
        EvilPolitician[] evilPoliticiansTemp = new EvilPolitician[evilPoliticianNumber];

        for (int i = 0; i < evilPoliticianNumber; i++) {
            evilPoliticiansTemp[i] = new EvilPolitician(EnemyType.EVIL_POLITICIAN, x, y);
             x += 200;
        }

        return evilPoliticiansTemp;
    }*/


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


        //if (minionPoliticiansNumber != 0) {
            for (Enemy enemy : enemies) {
                if (player.getLife() == 0) {
                    deleteBullets();
                    player.hidePlayer();
                    deleteEnemies();
                    gameOverText.draw();
                    return;
                }
                if ((enemy.getEnemyGfxY() + enemy.getEnemyGfxHeight()) > player.getY()) {
                    player.setLife(player.getLife() - 1);
                    System.out.println(player.getLife());
                    deleteBullets();
                    deleteEnemies();
                    init();
                    start();
                    return;
                }
                enemy.moveEnemy();

            }
        //}


        for (Bullet bullet : bulletList) {
            collisionDetection.check(bullet, this);
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
