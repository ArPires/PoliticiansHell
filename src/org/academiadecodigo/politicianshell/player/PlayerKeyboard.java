package org.academiadecodigo.politicianshell.player;

import org.academiadecodigo.politicianshell.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class PlayerKeyboard implements KeyboardHandler {

    private Player player;
    private boolean shot;

    public PlayerKeyboard(Player player) {

        this.player = player;
        shot = true;

        Keyboard k = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(left);

        KeyboardEvent leftReleased = new KeyboardEvent();
        leftReleased.setKey(KeyboardEvent.KEY_LEFT);
        leftReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(leftReleased);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(right);

        KeyboardEvent rightReleased = new KeyboardEvent();
        rightReleased.setKey(KeyboardEvent.KEY_RIGHT);
        rightReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(rightReleased);

        KeyboardEvent shot = new KeyboardEvent();
        shot.setKey(KeyboardEvent.KEY_SPACE);
        shot.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(shot);

        KeyboardEvent shotReleased = new KeyboardEvent();
        shotReleased.setKey(KeyboardEvent.KEY_SPACE);
        shotReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(shotReleased);
    }

    @Override
    public void keyPressed(KeyboardEvent e) {

        if (e.getKey() == KeyboardEvent.KEY_LEFT) {
            player.setDirection(Direction.LEFT);
        }

        if (e.getKey() == KeyboardEvent.KEY_RIGHT) {
            player.setDirection(Direction.RIGHT);
        }

        if (e.getKey() == KeyboardEvent.KEY_SPACE) {
            if (shot) {
                player.setReadyToNextShoot(true);
                shot = false;
            }
        }
    }


    @Override
    public void keyReleased(KeyboardEvent e) {

        if (e.getKey() == KeyboardEvent.KEY_LEFT) {
            player.setDirection(null);
        }

        if (e.getKey() == KeyboardEvent.KEY_RIGHT) {
            player.setDirection(null);
        }

        if (e.getKey() == KeyboardEvent.KEY_SPACE) {
            shot = true;
        }
    }
}
