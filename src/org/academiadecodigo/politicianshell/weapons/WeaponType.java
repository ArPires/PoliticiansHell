package org.academiadecodigo.politicianshell.weapons;

public enum WeaponType {
    REVOLVER(20,10),
    RIFLES(50,10);

    private int bulletPower;
    private int maxBullets;

    WeaponType(int bulletPower, int maxBullets){
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
