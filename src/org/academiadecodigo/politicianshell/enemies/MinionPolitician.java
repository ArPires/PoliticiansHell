package org.academiadecodigo.politicianshell.enemies;


public class MinionPolitician extends Enemy {

    private int random;

    public MinionPolitician(int x, int y){
        super(x, y);

    }

    @Override
    public String getEnemyPictureUrl () {
        random = (int) (Math.random() * (EnemyPicture.values().length - 2));
        String enemyPicture = EnemyPicture.values()[random].getUrl();
        return enemyPicture;

    }
}
