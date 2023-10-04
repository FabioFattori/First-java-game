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

    @Override
    public boolean equals(Object o){
        if(o instanceof Weapon && ((Weapon)o).damage == this.damage && ((Weapon)o).speed == this.speed && ((Weapon)o).range == this.range && ((Weapon)o).attackSpeed == this.attackSpeed){
            return true;
        }
        return false;
    }

}
