package org.academiadecodigo.politicianshell;

import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.enemies.EnemyType;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.player.Player;
import org.academiadecodigo.politicianshell.player.PlayerKeyboard;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        Field field = new Field();

        field.init();
        //Game g = new Game(500, 800);
        //g.init();
        Player player = new Player(Field.WIDTH/2 - 15, Field.HEIGHT - 100, 30, 40);

        Enemy[] enemies = new Enemy[20];

        enemies[0] = new Enemy();
        enemies[0].movePolitician();

        /*for (int i = 1; i < enemies.length; i++){
            if (enemies[i-1].getEnemyGfxX() == 15) {
                enemies[i] = new Enemy();
                enemies[i].movePolitician();
            }
        }*/

        while (true) {

            player.move();


            // move enemies

            Thread.sleep(100);
        }

        /*for (Enemy enemy : enemies) {

        }*/
    }

}
