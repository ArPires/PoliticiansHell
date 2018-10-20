package org.academiadecodigo.politicianshell.player;

import org.academiadecodigo.politicianshell.Direction;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.weapons.Bullet;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;

public class Player {

    private Rectangle rectangle;
    private Bullet bullet;
    private PlayerKeyboard playerKeyboard;
    private Direction direction;
    private boolean shooting;
    private LinkedList<Bullet> listBullets;

    public Player(int x, int y, int width, int height) {

        rectangle = new Rectangle(x, y, width, height);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
        playerKeyboard = new PlayerKeyboard(this);
        shooting = false;

        listBullets = new LinkedList<>();



    }

    public void setShooting(boolean shooting) {
        this.shooting = shooting;

    }

    public boolean getShooting() {
        return shooting;
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

        if (rectangle.getX() > 10) {

            rectangle.translate(-10, 0);
        }
    }

    public void moveRight() {

        if (rectangle.getX() < Field.WIDTH - 40) {

            rectangle.translate(10, 0);
        }
    }

    public Bullet shoot() {
        if (!shooting) {
            return null;
        }

        listBullets.add(new Bullet( getX(), getY() ));

        Bullet bullet = listBullets.getLast();
        listBullets.removeLast();


        setShooting(false);


        return bullet;
    }

    public void loadBullet(Bullet bullet){
        bullet.setFired(false);
        listBullets.addFirst(bullet);
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
