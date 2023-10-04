import java.awt.Color;
import java.awt.Graphics2D;

public class ChangeWeapongArea {
    int x; 
    int y;
    int width;
    int height;
    boolean canChangeWeapon = false;

    public ChangeWeapongArea(int x,int y,int width,int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isPlayerInArea(Player p){
        if(p.x > this.x && p.x < this.x + this.width && p.y > this.y && p.y < this.y + this.height){
            return true;
        }
        return false;
    }

    public void changeWeapon(Player p){
        if(p.weapon instanceof HeavySword){
            p.weapon = new Bow();
        }else if(p.weapon instanceof Bow){
            p.weapon = new HeavySword();
        }else{
            p.weapon = new HeavySword();
        }
    }

    public void draw(Graphics2D g){
        g.setColor(Color.YELLOW);
        g.drawRect(this.x, this.y, this.width, this.height);
    }
}
