package org.academiadecodigo.politicianshell.enemies;


import org.academiadecodigo.politicianshell.field.Field;
import org.academiadecodigo.politicianshell.weapons.Bullet;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Enemy {

    private EnemyType enemyType;
    private boolean dead;
    //private BulletType bulletType;
    private int currentHealth;
    private Rectangle enemyGfx;
    private static final int DELAY = 5;

    public Enemy (EnemyType enemyType){
        this.enemyType = enemyType;
        currentHealth = enemyType.getHealth();
        enemyGfx = new Rectangle(0, 50, 15,15);
        enemyGfx.setColor(Color.YELLOW);
        enemyGfx.fill();
    }

    public Enemy (){

        enemyGfx = new Rectangle(0, 50, 15,15);
        enemyGfx.setColor(Color.YELLOW);
        enemyGfx.fill();
    }

    public void movePolitician() throws InterruptedException{
        int maxX = Field.WIDTH - enemyGfx.getWidth() - 10;
        int maxY = (Field.HEIGHT - Field.MARGIN_BOTTOM - enemyGfx.getHeight());

        while (enemyGfx.getY() < maxY) {
            while (enemyGfx.getX() < maxX) {
                Thread.sleep(DELAY);
                enemyGfx.translate(15, 0);
            }

            enemyGfx.translate(0, 15);

            while (enemyGfx.getX() > 10) {
                Thread.sleep(DELAY);
                enemyGfx.translate(-15, 0);
            }

            enemyGfx.translate(0, 15);
        }

        //System.out.println(rectangle.getX());

    }
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

