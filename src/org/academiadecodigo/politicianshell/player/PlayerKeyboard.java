package org.academiadecodigo.politicianshell.player;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerKeyboard implements KeyboardHandler {

    private Player player;

    public PlayerKeyboard(Player player) {
        this.player = player;

        Keyboard k = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(right);

        KeyboardEvent shot = new KeyboardEvent();
        shot.setKey(KeyboardEvent.KEY_SPACE);
        shot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(shot);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        if(e.getKey() == KeyboardEvent.KEY_LEFT) {
            player.moveLeft();
        }
        if(e.getKey() == KeyboardEvent.KEY_RIGHT) {
            player.moveRight();
        }
        if(e.getKey() == KeyboardEvent.KEY_SPACE) {
            player.shoot();
        }
    }


    @Override
    public void keyReleased(KeyboardEvent e) {
        if(e.getKey() == KeyboardEvent.KEY_LEFT) {
        }
        if(e.getKey() == KeyboardEvent.KEY_RIGHT) {
        }
        if(e.getKey() == KeyboardEvent.KEY_SPACE) {
        }
    }




}
