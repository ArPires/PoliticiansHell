package org.academiadecodigo.politicianshell.enemies;

public enum EnemyType {

    EVIL_POLITICIAN(500),
    MINION_POLITICIAN(100);

    private int health;

    EnemyType(int health){
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

}
