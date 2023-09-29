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
}
