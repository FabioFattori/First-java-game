import java.awt.Graphics2D;
import java.awt.Color;

public class Player {
    int x;
    int y;
    int tileSize;
    int speed;
    Weapon weapon;

    
    Player(int tileSize){
        this.tileSize = tileSize;
        this.x = 100;
        this.y = 100;
        this.speed = 3;
        this.weapon = new Pugni();
    }

    Player(int tileSize,int x,int y){
        this.tileSize = tileSize;
        this.x = x;
        this.y = y;
        this.speed = 3;
        this.weapon = new Pugni();
    }

    Player(int tileSize,Weapon w){
        this.tileSize = tileSize;
        this.x = 100;
        this.y = 100;
        this.speed = 3;
        this.weapon = w;
    }

    Bullet _bullet;
    int _bulletShotTime = 0;

    private int _attackingTime = 0;
    private boolean _isPressingAttack = false;

    public void redraw(Graphics2D g2d, KeyHandler keyHandler){
        g2d.setColor(Color.white);

        g2d.fillRect(x, y, tileSize, tileSize);

        if(!weapon.isRanged)
        {
            if(keyHandler.attack && !_isPressingAttack && _attackingTime <= 0)
            {
                _isPressingAttack = true;
                _attackingTime = weapon.attackSpeed;
            }
            else if(!keyHandler.attack)
            {
                _isPressingAttack = false;
            }

            if(_attackingTime > 0){
                _attackingTime--;
                AttackNotRanged(g2d, keyHandler);
            }
        }
        else
        {
            if(keyHandler.attack && _bullet == null)
            {
                _bullet = new Bullet(x,y,weapon.range,weapon.speed,weapon.damage,keyHandler.direction);
                _bulletShotTime = 0;
            }
            
            if(_bullet != null)
            {
                AttackRanged(g2d);
                _bulletShotTime++;
            }

            if(_bulletShotTime * weapon.speed > weapon.range)
            {
                _bullet = null;
            }
        

        }
    }

    public void AttackRanged(Graphics2D g2d)
    {
        _bullet.draw(g2d,_bulletShotTime);
    }

    public void AttackNotRanged(Graphics2D g2d,KeyHandler keyHandler){
        g2d.setColor(Color.red);
        
        switch (keyHandler.direction) {
                case "up":
                    g2d.fillRect(x, y-this.weapon.range, tileSize, tileSize);
                    break;
                case "down":
                    g2d.fillRect(x, y+this.weapon.range, tileSize, tileSize);
                    break;
                case "left":
                    g2d.fillRect(x-this.weapon.range, y, tileSize, tileSize);
                    break;
                case "right":
                    g2d.fillRect(x+this.weapon.range, y, tileSize, tileSize);
                    break;
            
                default:
                    break;
        }
    }
}
