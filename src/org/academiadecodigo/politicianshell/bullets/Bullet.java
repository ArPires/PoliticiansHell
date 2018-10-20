package org.academiadecodigo.politicianshell.bullets;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet {

    private Rectangle bulletGfx;
    //private boolean move;
    private boolean fired;
    private boolean hit;

    public Bullet(int x, int y) {

        //move = false;
        fired = false;
        hit = false;
        bulletGfx = new Rectangle(x, y, 4, 10);
        bulletGfx.setColor(Color.RED);
        bulletGfx.fill();

    }

    public void move() {
        if (bulletGfx.getY() > -30) {
            //move = true;
            bulletGfx.translate(0, -20);
        }
    }

    public void stop() {
        //if (move) {
            bulletGfx.translate(0, 0);
        //}
    }

    public void setFired(boolean fired) {
        this.fired = fired;
    }

    public boolean getFired(){
        return fired;
    }

    public void hit(boolean hit){
        this.hit = hit;
    }

    public boolean getHit(){
        return hit;
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

    public void remove() {
        bulletGfx.delete();
    }
}
