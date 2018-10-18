package org.academiadecodigo.politicianshell;

import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.player.Player;

public class Game {

    private Field field;
    private Player player;
    private Enemy[] enemies;

   /* public Game() {
        field = new Field();
    }*/
    public Game(){
        field = new Field();
    }

    public void init() {

        field.init();
        enemies = createEnemies(20);

        player = new Player(Field.WIDTH/2 - 15, Field.HEIGHT - 100, 30, 40);

        //enemies = new Enemy[20];
        enemies[0] = new Enemy();


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
