package org.academiadecodigo.politicianshell.weapons;

import org.academiadecodigo.politicianshell.Game;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet {

    private Rectangle bulletGfx;
private boolean move;

    public Bullet(int x, int y) {

        move = false;
        bulletGfx = new Rectangle(x, y, 4, 10);
        bulletGfx.setColor(Color.RED);
        bulletGfx.fill();

    }

    public void move() {
        if (bulletGfx.getY() > -30) {
            move = true;
            bulletGfx.translate(0, -10);
        }
    }

    public void stop(){
        if (move){
         bulletGfx.translate(0,0);
        }
    }


    public int bulletGetY() {
        return bulletGfx.getY();
    }

    public int bulletGetX() {
        return bulletGfx.getX();
    }

    public int bulletGetWidth() {
        return bulletGfx.getWidth();
    }

    public int bulletGetHeight() {
        return bulletGfx.getHeight();
    }

}
