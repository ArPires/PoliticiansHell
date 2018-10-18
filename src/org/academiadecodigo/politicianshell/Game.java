package org.academiadecodigo.politicianshell;

import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.enemies.EnemyType;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.player.Player;

public class Game {

    private Field field;
    private Player player;
    private Enemy[] enemies;
    private Enemy[] enemies1;
    public Game(){
        field = new Field();
    }

    public void init() {

        field.init();

        enemies = createEnemies(45, 20, 50);

        player = new Player(Field.WIDTH/2 - 15, Field.HEIGHT - 100, 30, 40);

    }

    public Enemy[] createEnemies (int enemyNumber, int x, int y) {
        //int x = 0;
        //int y = 50;

        Enemy[] enemiesTemp = new Enemy[enemyNumber];

        for (int i = 0; i < enemyNumber; i++) {
            if (i == 15 || i == 30){
                y += 30;
                x = 20;
            }
            enemiesTemp[i] = new Enemy(EnemyType.MINION_POLITICIAN, x, y);
            x += 30;
        }

        return enemiesTemp;
    }


    public void start()throws InterruptedException {

        while (true) {

            player.move();

            moveAllPoliticians();

            Thread.sleep(200);

        }
    }

    public void moveAllPoliticians() {

        for (Enemy enemy : enemies) {

            enemy.movePoliticians();

        }

    }

}
