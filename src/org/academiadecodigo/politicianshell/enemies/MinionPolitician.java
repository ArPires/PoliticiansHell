package org.academiadecodigo.politicianshell.enemies;


import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MinionPolitician extends Enemy {

    private int random;

    public MinionPolitician(EnemyType enemyType, int x, int y){
        super(EnemyType.MINION_POLITICIAN, x, y);

    }

    @Override
    public String getEnemyPicture() {
        random = (int) (Math.random() * (EnemyPicture.values().length - 2));
        String enemyPicture = EnemyPicture.values()[random].getUrl();
        return enemyPicture;

    }


    /*@Override
    public void showEnemy(String enemyPicture) {
        enemyPicture = EnemyPicture.values()[random].getUrl();
    }*/


}
