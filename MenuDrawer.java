import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

public abstract class MenuDrawer {
    
    static void drawTopLeftMenu(Graphics2D g,Player p){
        
        g.setColor(Color.white);
        g.draw(new RoundRectangle2D.Double(0, 5, 150, 70, 10, 10));
        g.drawString("Health: " + p.health, 10, 20);
        g.drawString("Damage: " + p.weapon.damage, 10, 40);
        g.drawString("Weapon type:"+p.weapon.toString(), 10, 60);
    }

    static void drawGameOver(Graphics2D g){
        g.setColor(Color.RED);
        g.drawString("Game Over", 100, 100);
    }

    static void drawTextPrompt(String text,Graphics2D g){
        g.setColor(Color.white);
        
        g.drawString(text, 100, 100);
    }

    static void drawInventory(Graphics2D g,Player p,int currentIndex){
        int x=500;
        int y=10;
        int maxWidth=400;
        int maxHeight=300;
        g.setColor(Color.white);
        //draw a rectangole with the inventory in the right side of the screen
        g.draw(new RoundRectangle2D.Double(x, y, maxWidth, maxHeight, 10, 10));
        g.drawString("Inventory", x+50, y+15);
        
        int i = 0;
        for (Weapon w : p.inventory) {
            if(i==5){
                i=0;
            }
                if(p.inventory.indexOf(w)==currentIndex){
                    g.drawRoundRect(x+10+i*56, y+35, 48, 48,10,10);
                    
                }

                if(p.weapon.equals(w)){
                    g.setColor(Color.orange);
                    g.fillRoundRect(x+10+i*56, y+35, 48, 48,10,10);
                    g.setColor(Color.white);
                }

                if(w instanceof HeavySword){
                    ((HeavySword)w).DrawIcon(g, x+20+i*56, y+45);
                }
            i++;
        }
    }
}
