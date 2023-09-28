import java.awt.Color;
import java.awt.Graphics2D;


public class Bullet{
    int x;
    int y;

    int speed = 10;
    String direction = "down";
    int tileSize = 10;

    Bullet(int x,int y,int range,int speed,int damage,String direction){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
    }

    void draw(Graphics2D g2d, int fpsPassed)
   {
        int currentX ;
        int currentY ;

        switch(direction)
        {
            case "up":
                currentX = x;
                currentY = y - (speed * fpsPassed);
                break;
            case "down":

                currentX = x;
                currentY = y + (speed * fpsPassed);
                break;
            case "left":
                currentX = x - speed * fpsPassed;
                currentY = y;
                break;
            case "right":
                currentX = x + speed * fpsPassed;
                currentY = y;
                break;
            default:

                currentX = x;
                currentY = y;
                break;
        }

        g2d.fillRect(currentX, currentY, tileSize, tileSize);

        g2d.dispose();     
   } 

}
