package org.academiadecodigo.politicianshell.enemies;

import org.academiadecodigo.politicianshell.Direction;
import org.academiadecodigo.politicianshell.bullets.Bullet;

public class EvilPolitician extends Enemy {

    private boolean dead;
    private int armour;
    private Bullet[] evilBullets;

    public EvilPolitician(EnemyType enemyType, int x, int y) {

        super(EnemyType.EVIL_POLITICIAN, x, y);
        dead = false;
        armour = 500;
        evilBullets = new Bullet[100];

    }

    public int getArmour() {
        return armour;
    }

    @Override
    public void moveEnemy() {
        int maxY = 300;

        Direction[] directions = Direction.values();

        Direction direction = directions[ (int) Math.random() * Direction.values().length ];

        switch (direction){
            case LEFT:
                enemyMoveLeft();
                break;
            case RIGHT:
                enemyMoveRight();
                break;
            case TOP:
                politicianMoveTop();
                break;
            case UP:
                politicianMoveUp();
                break;
        }
    }

    private void politicianMoveTop(){

    }

    private void politicianMoveUp(){

    }

    @Override
    public void enemyMoveRight() {

    }

    @Override
    public void enemyMoveLeft() {
        super.enemyMoveLeft();
    }


    @Override
    public void hit(Bullet bullet) {
        super.hit(bullet);
    }

    @Override
    public int getEnemyGfxX() {
        return super.getEnemyGfxX();
    }

    @Override
    public boolean isDead() {
        return dead;
    }
}

