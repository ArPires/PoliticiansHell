package org.academiadecodigo.politicianshell;

import org.academiadecodigo.politicianshell.enemies.Enemy;
import org.academiadecodigo.politicianshell.enemies.EnemyType;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.player.Player;
import org.academiadecodigo.politicianshell.player.PlayerKeyboard;
import org.academiadecodigo.politicianshell.weapons.Bullet;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        Game g = new Game();

        g.preGame();
        g.init();
        g.start();

    }

}
