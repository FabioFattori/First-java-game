import java.awt.Color;
import java.awt.Graphics2D;

public class Zombie {
    int health;
    int damage;
    int speed;
    int x;
    int y;
    int tileSize;
    boolean _isAttacking = false;
    String attackDirection = "none";

    public Zombie(int health, int damage, int speed, int x, int y, int tileSize) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.tileSize = tileSize;
    }

    public void MoveInDirectionOfPlayer(Player p){
        if(p.x > this.x){
            this.x += this.speed;
        }
        else if(p.x < this.x){
            this.x -= this.speed;
        }
        else if(p.y > this.y){
            this.y += this.speed;
        }
        else if(p.y < this.y){
            this.y -= this.speed;
        }
    }

    public void redraw(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, tileSize, tileSize);
    }

    public void Attack(String direction){
        this._isAttacking = true;
        this.attackDirection = direction;
    }

    public void drawAttack(Graphics2D g2d){
        g2d.setColor(Color.blue);
            
        switch(this.attackDirection){
            case "left":
                g2d.fillRect(this.x - this.tileSize, this.y, this.tileSize, this.tileSize);
                break;
            case "right":
                g2d.fillRect(this.x + this.tileSize, this.y, this.tileSize, this.tileSize);
                break;
            case "up":
                g2d.fillRect(this.x, this.y - this.tileSize, this.tileSize, this.tileSize);
                break;
            case "down":
                g2d.fillRect(this.x, this.y + this.tileSize, this.tileSize, this.tileSize);
                break;
        }
            _isAttacking = false;
    }
    
}
