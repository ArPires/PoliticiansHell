package org.academiadecodigo.politicianshell.weapons;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet {

    private Rectangle bulletGfx;

    public Bullet(int x, int y) {

        bulletGfx = new Rectangle(x, y, 6, 20);
        bulletGfx.setColor(Color.RED);
        bulletGfx.fill();

    }

    public void move()  {
            bulletGfx.translate(0, -5);
    }

    public int getY() {
        return bulletGfx.getY();
    }


}
