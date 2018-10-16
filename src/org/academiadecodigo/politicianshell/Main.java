package org.academiadecodigo.politicianshell;

import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.player.Player;
import org.academiadecodigo.politicianshell.player.PlayerKeyboard;

public class Main {

    public static void main(String[] args) throws InterruptedException{

        Field field = new Field();

        field.init();

       Player player = new Player(Field.WIDTH/2 - 15, Field.HEIGHT - 100, 30, 40);

    }
}
