package org.academiadecodigo.politicianshell.player;

import org.academiadecodigo.politicianshell.Direction;
import org.academiadecodigo.politicianshell.Sound;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.bullets.Bullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Player {

    private Picture playerGfx;
    private PlayerKeyboard playerKeyboard;
    private Direction direction;
    private boolean readyToNextShoot;
    private LinkedList<Bullet> savedBulletsList;
    private int life = 3;
    private Sound sound;

    public Player() {

        sound = new Sound("/resources/Sounds/shot.wav");
        int x = Field.WIDTH / 2 - 15;
        int y = Field.HEIGHT - 100;
        playerGfx = new Picture(x, y, "resources/Images/ZePovinho.png");

        playerKeyboard = new PlayerKeyboard(this);
        savedBulletsList = new LinkedList<>();
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void showPlayer() {
        playerGfx.draw();
    }

    public void hidePlayer() {
        playerGfx.delete();
    }

    public void setReadyToNextShoot(boolean readyToNextShoot) {
        this.readyToNextShoot = readyToNextShoot;
    }

    public boolean getReadyToNextShoot() {
        return readyToNextShoot;
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

        sound.play(true);

        if (!readyToNextShoot) {
            return null;
        }

        savedBulletsList.add(new Bullet( getX() + 13 , getY()));

        Bullet bullet = savedBulletsList.removeLast();

        setReadyToNextShoot(false);
        //sound.stop();
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
