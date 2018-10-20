package org.academiadecodigo.politicianshell.enemies;


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
    private int waitingTime = 0;


    public Enemy(EnemyType enemyType, int x, int y) {
        this.enemyType = enemyType;
        currentHealth = enemyType.getHealth();
        enemyGfx = new Rectangle(x, y, 15, 15);
        enemyGfx.setColor(Color.YELLOW);
        enemyGfx.fill();
    }

    public void movePoliticians() {
        int maxY = 550;
        switch (direction) {
            case RIGHT:
                politicianMoveRight();
                break;
            case DOWN_TO_LEFT:
                if (enemyGfx.getY() > maxY) {
                    return;
                }
                politicianMoveDownToLeft();
                break;
            case LEFT:
                politicianMoveLeft();
                break;
            case DOWN_TO_RIGHT:
                if (enemyGfx.getY() > maxY) {
                    return;
                }
                politicianMoveDownToRight();
                break;
        }
        waitingTime++;
    }

    public void politicianMoveLeft() {
         if (waitingTime == 4) {

            waitingTime = 0;
            direction = Direction.DOWN_TO_RIGHT;
        }

        enemyGfx.translate(-5, 0);
    }


    public void politicianMoveRight() {
        if (waitingTime == 4) {
            waitingTime = 0;

            direction = Direction.DOWN_TO_LEFT;
        }
        enemyGfx.translate(5, 0);
    }

    public void politicianMoveDownToLeft() {
        enemyGfx.translate(0, 15);
        direction = Direction.LEFT;

    }

    public void politicianMoveDownToRight() {
        enemyGfx.translate(0, 15);
        direction = Direction.RIGHT;

    }

    public void hit(Bullet bullet) {

        //currentHealth = enemyType.getHealth() > weaponType.getBulletPower() ? currentHealth - weaponType.getBulletPower() : 0;


        if (currentHealth == 0) {
            dead = true;
            System.out.println("This enemy is dead!");
        }
    }

    public boolean isDead() {
        return this.dead;
    }

    public void setDead(boolean isDead) {
        this.dead = isDead;
        enemyGfx.delete();
    }

    public int getEnemyGfxX() {
        return enemyGfx.getX();
    }

    public int getEnemyGfxY() {
        return enemyGfx.getY();
    }

    public int getEnemyGfxWidth() {
        return enemyGfx.getWidth();
    }

    public int getEnemyGfxHeight() {
        return enemyGfx.getHeight();
    }
}
