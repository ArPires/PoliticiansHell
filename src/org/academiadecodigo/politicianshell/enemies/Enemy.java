package org.academiadecodigo.politicianshell.enemies;


import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.Direction;
import org.academiadecodigo.politicianshell.weapons.Bullet;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Enemy {

    private EnemyType enemyType;
    private boolean dead;
    //private BulletType bulletType;
    private int currentHealth;
    private Rectangle enemyGfx;
    private Direction direction = Direction.RIGHT;
    private static final int DELAY = 5;
    private int initialX;
    private int initialY;


    public Enemy (EnemyType enemyType, int x, int y){
        this.initialX = x;
        this.initialY = y;
        this.enemyType = enemyType;
        currentHealth = enemyType.getHealth();
        enemyGfx = new Rectangle(x, y, 15,15);
        enemyGfx.setColor(Color.YELLOW);
        enemyGfx.fill();
    }

  /*  public void movePoliticians(){
        if(direction == Direction.RIGHT) {
            politicianMoveRight();
            return;
        }
        if(direction == Direction.DOWN) {
            politicianMoveDown();
            return;
        }
        politicianMoveLeft();
    }*/

    public void movePoliticians(){

        if(direction == Direction.RIGHT) {
            politicianMoveRight();
            return;
        }
        if(direction == Direction.DOWN) {
            politicianMoveDownToLeft();
            return;
        }
        if(direction == Direction.LEFT) {
            politicianMoveLeft();
            return;
        }
        politicianMoveDownToRight();

    }

    public void politicianMoveLeft(){
        /*if (enemyGfx.getX() > (Field.WIDTH + enemyGfx.getWidth() + 10)) {
            politicianMoveDown();
            return;
        } */
            enemyGfx.translate(-15, 0);
            direction = Direction.DOWN;
        }


    public void politicianMoveRight(){
        enemyGfx.translate(15, 0);
        direction = Direction.DOWN;
    }

    public void politicianMoveDownToLeft(){
        enemyGfx.translate(0, 15);
        direction = Direction.LEFT;

    }

    public void politicianMoveDownToRight(){
        enemyGfx.translate(0, 15);
        direction = Direction.RIGHT;

    }
    /*public void politicianMoveLeft(){
        if (enemyGfx.getX() > initialX) {
            enemyGfx.translate(-15, 0);
            return;
        }
        politicianMoveDown();
    }

    public void politicianMoveRight(){
        final int MAXX = initialX + 30;
        if (enemyGfx.getX() < MAXX) {
            enemyGfx.translate(15, 0);
            return;
        }
        politicianMoveDown();
    }

    public void politicianMoveDown(){
        int maxY1 = enemyGfx.getY() + 30;
        int maxY = Field.HEIGHT - Field.MARGIN_BOTTOM - enemyGfx.getHeight();
        enemyGfx.translate(0, 15);
        if (enemyGfx.getY() > maxY1) {
            System.out.println("lout");
            if(enemyGfx.getX() == initialX) {
                direction = Direction.RIGHT;

                return;
            }
            direction = Direction.LEFT;

        }

    }*/

    public void hit(Bullet bullet){

        //currentHealth = enemyType.getHealth() > weaponType.getBulletPower() ? currentHealth - weaponType.getBulletPower() : 0;


        if(currentHealth == 0) {
            dead = true;
            System.out.println("This enemy is dead!");
        }
    }

    public boolean isDead(){
        return this.dead;
    }

    public int getEnemyGfxX(){
        return enemyGfx.getX();
    }


}

