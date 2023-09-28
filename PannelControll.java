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

    Player player = new Player(tileSize);

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

        


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;


        g2d.setColor(Color.white);

        

        g2d.fillRect(player.x, player.y, player.tileSize, player.tileSize);

        if(keyHandler.attack){
            g2d.setColor(Color.red);
            switch (keyHandler.direction) {
                case "up":
                    g2d.fillRect(player.x, player.y-30, player.tileSize, player.tileSize);
                    break;
                case "down":
                    g2d.fillRect(player.x, player.y+30, player.tileSize, player.tileSize);
                    break;
                case "left":
                    g2d.fillRect(player.x-30, player.y, player.tileSize, player.tileSize);
                    break;
                case "right":
                    g2d.fillRect(player.x+30, player.y, player.tileSize, player.tileSize);
                    break;
            
                default:
                    break;
            }   
        }

        g2d.dispose();
    }
}
