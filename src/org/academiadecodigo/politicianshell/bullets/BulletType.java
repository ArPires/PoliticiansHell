package org.academiadecodigo.politicianshell.bullets;

public enum BulletType {

    POTATO(20,10),
    WATER_GUN(50,10),
    TOMATOS(100, 10);

    private int bulletPower;
    private int maxBullets;

    BulletType(int bulletPower, int maxBullets){
        this.bulletPower = bulletPower;
        this.maxBullets = maxBullets;
    }

    public int getBulletPower() {
        return bulletPower;
    }

    public int getMaxBullets() {
        return maxBullets;
    }

}
