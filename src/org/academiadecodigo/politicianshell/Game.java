package org.academiadecodigo.politicianshell;

import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.player.Player;

public class Game {

    private Field field;
    private Player player;
    private Enemy[] enemies;

    public Game() {
        field = new Field();
    }

    public void init() {

        field.init();

        player = new Player(Field.WIDTH/2 - 15, Field.HEIGHT - 100, 30, 40);

        enemies = new Enemy[20];
        enemies[0] = new Enemy();


    }

    public void start() throws InterruptedException{

        while (true) {

            player.move();
            //enemies[0].movePolitician();
            /*for (int i = 1; i < enemies.length; i++){
                if (enemies[i-1].getEnemyGfxX() == 15) {
                    enemies[i] = new Enemy();
                    enemies[i].movePolitician();
                }
            }*/

            // move enemies

            Thread.sleep(50);

        }
    }
}
