package org.academiadecodigo.politicianshell;

import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.player.Player;

public class Game {

    private Field field;
    private Player player;
    private Enemy[] enemies;

   /* public Game(int cols, int rows) {
        field = new Field(cols, rows);
    }*/
    public Game(){
        enemies = createEnemies(20);

    }

    public void init() {
        field.init();
    }
        /*enemies[0] = new Enemy();
        enemies[0].movePolitician();*/

    public Enemy[] createEnemies (int enemyNumber) {
        Enemy[] enemiesTemp = new Enemy[enemyNumber];
        for (int i = 0; i < enemiesTemp.length; i++) {
            enemiesTemp[i] = new Enemy();
            //enemies[i].movePolitician();
        }
        return enemiesTemp;
    }

    public Enemy[] createEnemies (int enemyNumber) {
        Enemy[] enemiesTemp = new Enemy[enemyNumber];
        for (int i = 0; i < enemiesTemp.length; i++) {

        }
    }


    public void start()throws InterruptedException {
        while (true) {
           player.move();

           moveAllPoliticians();

           Thread.sleep(100);
        }
    }

    public void moveAllPoliticians() throws InterruptedException{
        for (Enemy enemy : enemies){
            enemy.movePolitician();
        }
    }
}
