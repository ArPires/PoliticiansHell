package org.academiadecodigo.politicianshell.enemies;

public class EvilPolitician extends Enemy {

    private int corruptionLevel;

    public EvilPolitician(int x, int y) {
        super(x, y);
        corruptionLevel = 10;

    }

    @Override
    public String getEnemyPictureUrl() {

        String enemyPictureUrl = EnemyPicture.TRUMP.getUrl();
        String enemyPictureUrl1 = EnemyPicture.KIM_JONG_UN.getUrl();

        return enemyPictureUrl;
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

