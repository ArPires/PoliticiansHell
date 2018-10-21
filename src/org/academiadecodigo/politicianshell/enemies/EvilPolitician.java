package org.academiadecodigo.politicianshell.enemies;

public class EvilPolitician extends Enemy {

    private int corruptionLevel;

    public EvilPolitician(EnemyType enemyType, int x, int y) {

        super(EnemyType.EVIL_POLITICIAN, x, y);
        corruptionLevel = 10;

    }

    @Override
    public String getEnemyPicture() {
        String enemyPicture = EnemyPicture.values()[7].getUrl();
        return enemyPicture;
    }

    @Override
    public void setDead(boolean dead) {
       if (corruptionLevel == 0) {
           super.setDead(true);
       }
       corruptionLevel--;
    }


    public void setCorruptionLevel(int corruptionLevel) {
        this.corruptionLevel = corruptionLevel;
    }

}

