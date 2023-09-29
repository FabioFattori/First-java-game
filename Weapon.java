public abstract class Weapon {
    int damage;
    int attackSpeed;     // the higher the attack speed, the slower the attack
    
    int range;
    int speed;

    public Weapon(int damage, int attackSpeed,int range,int speed){
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.speed = speed;
    }



}
