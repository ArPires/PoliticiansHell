package org.academiadecodigo.politicianshell.weapons;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bullet {

    private Rectangle bulletGfx;


    public Bullet(int x, int y) {

        bulletGfx = new Rectangle(x, y, 4, 10);
        bulletGfx.setColor(Color.RED);
        bulletGfx.fill();

    }

    public void move() {

        ActionListener listener = new AbstractAction() {

            public void actionPerformed(ActionEvent e) {

                if(bulletGfx.getY() < 0) {
                    bulletGfx.translate(0,0);
                } else {
                    bulletGfx.translate(0,-10);
                }
            }
        };

        Timer timer = new Timer(30,listener);
        timer.start();

    }

    public int getY() {
        return bulletGfx.getY();
    }

}
