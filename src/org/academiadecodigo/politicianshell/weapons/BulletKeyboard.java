/*package org.academiadecodigo.politicianshell.weapons;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class BulletKeyboard implements KeyboardHandler {

    private Bullet bullet;

    public BulletKeyboard(Bullet bullet) {
        this.bullet = bullet;

        Keyboard k = new Keyboard(this);

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
        if(e.getKey() == KeyboardEvent.KEY_SPACE) {
            player.shoot();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {}



}*/
