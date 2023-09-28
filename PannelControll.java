import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PannelControll extends JPanel implements Runnable{
    final int tileSizeOriginal = 16;
    final int scale=3;
    final int tileSize = tileSizeOriginal*scale;
    final int maxTileX = 24;
    final int maxTileY = 18;

    
    final int ScreenSizeX = tileSize*maxTileX;
    final int ScreenSizeY = tileSize*maxTileY;

    Thread gameThread;

    public PannelControll(){
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(ScreenSizeX,ScreenSizeY));
        this.setBackground(Color.black);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(this.gameThread != null){
            System.out.println("Game is running");
        }
    }
}
