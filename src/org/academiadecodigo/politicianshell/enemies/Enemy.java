package org.academiadecodigo.politicianshell.enemies;

import org.academiadecodigo.politicianshell.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class Enemy {

    private boolean dead;
    private Picture enemyGfx;
    private Direction direction = Direction.RIGHT;
    private int timeToChangeDirection;
    private int x;
    private int y;

    public Enemy(int x, int y) {

        this.x = x;
        this.y = y;
        String enemyPicture = getEnemyPictureUrl();
        enemyGfx = new Picture(x, y, enemyPicture);
        enemyGfx.draw();
        timeToChangeDirection = 4;

    }

    public abstract String getEnemyPictureUrl();

    public void moveEnemy() {

        switch (direction) {
            case RIGHT:
                enemyMoveRight();
                break;
            case DOWN_TO_LEFT:
                enemyDownToLeft();
                break;
            case LEFT:
                enemyMoveLeft();
                break;
            case DOWN_TO_RIGHT:
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

        SOCRATES ("resources/Images/Socrates.png"),
        LULA ("resources//Images/Lula.png"),
        BOLSONARO ("resources/Images/Bolsonaro.png"),
        MADURO ("resources/Images/Maduro.png"),
        PUTIN ("resources/Images/Putin.png"),
        PASSOS_COELHO ("resources/Images/PassosCoelho.png"),
        ANTONIO_COSTA ("resources/Images/AntonioCosta.png"),
        TRUMP ("resources/Images/TrumpXL.png"),
        KIM_JONG_UN ("resources/Images/KimJongUnXL.jpg");

        private String url;

        EnemyPicture(String url){
            this.url = url;
        }

        public String getUrl(){
            return this.url;
        }

    }

}
