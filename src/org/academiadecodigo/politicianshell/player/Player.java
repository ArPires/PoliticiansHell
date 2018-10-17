package org.academiadecodigo.politicianshell.player;

import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.weapons.Bullet;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player {

    private Rectangle rectangle;
    private Bullet bullet;
    private PlayerKeyboard playerKeyboard;
    private Direction direction;

    public Player(int x, int y, int width, int height) {

        rectangle = new Rectangle(x,y,width,height);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
        playerKeyboard = new PlayerKeyboard(this);

    }

    public void move() {
        if (direction == null) {
            return;
        }

        if (direction == Direction.LEFT) {
            moveLeft();
            return;
        }

        moveRight();
    }

    public void moveLeft() {

        if(rectangle.getX() > 10) {

            rectangle.translate(-15, 0);
        }
    }

    public void moveRight() {

        if(rectangle.getX() < Field.WIDTH - 40) {

            rectangle.translate(15,0);
        }
    }

    public void shoot() {

        bullet = new Bullet(rectangle.getX(),rectangle.getY());
        bullet.move();

    }

    public int getX(){
        return rectangle.getX();
    }

    public int getY(){
        return rectangle.getY();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
