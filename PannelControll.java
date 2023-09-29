import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PannelControll extends JPanel implements Runnable{
    final int tileSizeOriginal = 16;
    final int scale=3;
    final int tileSize = tileSizeOriginal*scale;
    final int maxTileX = 20;
    final int maxTileY = 15;

    
    final int ScreenSizeX = tileSize*maxTileX;
    final int ScreenSizeY = tileSize*maxTileY;

    Bullet b;

    

    Player player = new Player(tileSize,new Bow());

    Zombie zombie = new Zombie(100, 10, 2, 200, 200, tileSize);

    Thread gameThread;

    public KeyHandler keyHandler = new KeyHandler();

    public PannelControll(){
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(ScreenSizeX,ScreenSizeY));
        this.setBackground(Color.black);
        this.addKeyListener(keyHandler);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {


        while(this.gameThread != null){
            
            update();
            repaint();

            try{
                Thread.sleep(1000/60);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void update(){

        if(keyHandler.up&&player.y-player.speed>0){
            player.y -= player.speed;
        }
        if(keyHandler.down&&player.y+player.speed<ScreenSizeY-player.tileSize){
            player.y += player.speed;
        }
        if(keyHandler.left&&player.x-player.speed>0){
            player.x -= player.speed;
        }
        if(keyHandler.right&&player.x+player.speed<ScreenSizeX-player.tileSize){
            player.x += player.speed;
        }

        if(zombie.x  - 40 >= player.x ){
            zombie.Attack("left");
        }else if(zombie.x +40 <= player.x){
            zombie.Attack("right");
        }else if(zombie.y - 40 >= player.y ){
            zombie.Attack("up");
        }else if(zombie.y + 40<= player.y ){
            zombie.Attack("down");
        }
            zombie.MoveInDirectionOfPlayer(player);
        


    }


    
    

    
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;




        player.redraw(g2d,keyHandler);

        if(zombie._isAttacking){
            zombie.drawAttack(g2d);
        }
        zombie.redraw(g2d);

        
        
    }
}
