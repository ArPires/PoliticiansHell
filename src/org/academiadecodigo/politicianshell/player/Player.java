package org.academiadecodigo.politicianshell.player;

import org.academiadecodigo.politicianshell.Direction;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.bullets.Bullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Player {

    private Picture playerGfx;
    //private Bullet bullet;
    private PlayerKeyboard playerKeyboard;
    private Direction direction;
    private boolean triggerOn;
    private LinkedList<Bullet> savedBulletsList;
    //private Field grid;

    public Player() {
        int x = Field.WIDTH / 2 - 15;
        int y = Field.HEIGHT - 100;
        //int x = grid.getWidth()/2 - 15;
        //int y = grid.getHeight() - 100;
        playerGfx = new Picture(x, y, "resources/ZePovinho.png");
        playerGfx.draw();
        playerKeyboard = new PlayerKeyboard(this);
        savedBulletsList = new LinkedList<>();
    }

    public void setTrigger(boolean triggerOn) {
        this.triggerOn = triggerOn;
    }

    public boolean getTrigger() {
        return triggerOn;
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

        if(playerGfx.getX() > 10) {
            playerGfx.translate(-10, 0);
        }
    }

    public void moveRight() {

        if(playerGfx.getX() < Field.WIDTH - 40) {
            playerGfx.translate(10,0);
        }
    }

    public Bullet shoot() {

        if (!triggerOn) {
            return null;
        }

        savedBulletsList.add(new Bullet( getX() + 13 , getY()));

        Bullet bullet = savedBulletsList.removeLast();

        setTrigger(false);

        return bullet;

    }

    public void loadBullet(Bullet bullet){

        bullet.setFired(false);

        savedBulletsList.addFirst(bullet);

    }

    public int getX(){
        return playerGfx.getX();
    }

    public int getY(){
        return playerGfx.getY();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
