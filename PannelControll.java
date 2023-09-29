import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

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

    

    Player player = new Player(tileSize,new HeavySword());

    List<Zombie> zombies;


    Thread gameThread;
    Graphics2D g2d;
    int fps = 60;
    int frameCount = 0;
    boolean changeControll = true;

    ChangeWeapongArea changeWeaponArea = new ChangeWeapongArea(100,100,100,100);

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

        zombies = new ArrayList<Zombie>();
        for(int i=0;i<10;i++){
            zombies.add(i, new Zombie(100,10,2,(int)(Math.random()*ScreenSizeX),(int)(Math.random()*ScreenSizeY),tileSize));
        }


        while(this.gameThread != null){
            
            if(player.health <= 0){
                this.gameThread = null;
            }

            update();
            repaint();

            try{
                Thread.sleep(1000/60);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        MenuDrawer.drawGameOver(this.g2d);
    }

    public void update(){
        frameCount++;

        if(changeWeaponArea.isPlayerInArea(player)){
            this.changeWeaponArea.canChangeWeapon = true;
        }

        if(keyHandler.changeWeapon&&changeWeaponArea.canChangeWeapon&&changeControll){
            changeWeaponArea.changeWeapon(player);
            changeWeaponArea.canChangeWeapon = false;
            changeControll = false;
        }

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

        


        for (Zombie zombie : zombies) {
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
    
        
        


        if(frameCount%fps==0){
            changeControll=true;
        }

    }


    
    

    
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        this.g2d = (Graphics2D) g;

        MenuDrawer.drawTopLeftMenu(g2d,player);


        player.redraw(g2d,keyHandler);

        for (Zombie zombie : zombies) {
            if(zombie._isAttacking){
            zombie.drawAttack(g2d);
        }
        zombie.redraw(g2d);
        }

        if(changeWeaponArea.isPlayerInArea(player)){
            MenuDrawer.drawTextPrompt("Press E to change weapon", g2d);
        }

        
            changeWeaponArea.draw(g2d);
        

        
        g2d.dispose();
    }
}
