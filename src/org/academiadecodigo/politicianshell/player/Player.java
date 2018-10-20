package org.academiadecodigo.politicianshell.player;

import org.academiadecodigo.politicianshell.Direction;
import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.weapons.Bullet;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player {

    private Picture playerGfx;
    private Bullet bullet;
    private PlayerKeyboard playerKeyboard;
    private Direction direction;
    private boolean shooting;

 /*   public Player(int x, int y, int width, int height) {

        rectangle = new Rectangle(x,y,width,height);
        rectangle.setColor(Color.BLUE);
        rectangle.fill();
        playerKeyboard = new PlayerKeyboard(this);

    }*/

    public Player() {
        int x = Field.WIDTH/2 - 15;
        int y = Field.HEIGHT - 100;
        playerGfx = new Picture(x, y,"resources/ZePovinho.png");
        playerGfx.draw();
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

        if(playerGfx.getX() > 10) {

            playerGfx.translate(-10, 0);
        }
    }

    public void moveRight() {

        if(playerGfx.getX() < Field.WIDTH - 40) {

            playerGfx.translate(10,0);
        }
    }

    public void shoot() {
        if(shooting) {
            return;
        }
        bullet = new Bullet(playerGfx.getX()+13,playerGfx.getY());
        bullet.move();

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
