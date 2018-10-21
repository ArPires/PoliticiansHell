package org.academiadecodigo.politicianshell.enemies;

import org.academiadecodigo.politicianshell.Direction;
import org.academiadecodigo.politicianshell.bullets.Bullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy {

    private EnemyType enemyType;
    private boolean dead;
    private int currentHealth;
    private Picture enemyGfx;
    private Direction direction = Direction.RIGHT;
    private int timeToChangeDirection;

    public Enemy(EnemyType enemyType, int x, int y) {

        this.enemyType = enemyType;
        currentHealth = enemyType.getHealth();
        int random = (int) (Math.random() * (EnemyPicture.values().length - 2));
        String enemyPicture = EnemyPicture.values()[random].getUrl();
        enemyGfx = new Picture(x, y, enemyPicture);
        enemyGfx.draw();
        timeToChangeDirection = 4;

    }

    public void moveEnemy() {

        int maxY = 550;

        switch (direction) {
            case RIGHT:
                enemyMoveRight();
                break;
            case DOWN_TO_LEFT:
                if (enemyGfx.getY() > maxY) {
                    return;
                }
                enemyDownToLeft();
                break;
            case LEFT:
                enemyMoveLeft();
                break;
            case DOWN_TO_RIGHT:
                if (enemyGfx.getY() > maxY) {
                    return;
                }
                enemyDownToRight();
                break;
        }

        timeToChangeDirection--;

    }

    public void enemyMoveLeft() {

        if (timeToChangeDirection == 0) {
            timeToChangeDirection = 4;
            direction = Direction.DOWN_TO_RIGHT;
        }

        enemyGfx.translate(-5, 0);

    }


    public void enemyMoveRight() {

        if (timeToChangeDirection == 0) {
            timeToChangeDirection = 4;
            direction = Direction.DOWN_TO_LEFT;
        }

        enemyGfx.translate(5, 0);
    }

    public void enemyDownToLeft() {

        enemyGfx.translate(0, 15);
        direction = Direction.LEFT;
    }

    public void enemyDownToRight() {

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


    public enum EnemyPicture {

        SOCRATES ("resources/Socrates.png"),
        LULA ("resources/Lula.png"),
        BOLSONARO ("resources/Bolsonaro.png"),
        MADURO ("resources/Maduro.png"),
        PUTIN ("resources/Putin.png"),
        PASSOS_COELHO ("resources/PassosCoelho.png"),
        ANTONIO_COSTA ("resources/AntonioCosta.png"),
        TRUMP ("resources/TrumpXL.png"),
        KIM_JONG_UN ("resources/KimJongUnXL.jpg");

        private String url;

        EnemyPicture(String url){
            this.url = url;
        }

        public String getUrl(){
            return this.url;
        }

    }

}
