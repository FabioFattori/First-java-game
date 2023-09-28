public abstract class Weapon {
    int damage;
    int attackSpeed;     // the higher the attack speed, the slower the attack
    boolean isRanged;
    int range;
    int speed;

    public Weapon(int damage, int attackSpeed,boolean isRanged,int range,int speed){
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.isRanged = isRanged;
        this.range = range;
        this.speed = speed;
    }



}
