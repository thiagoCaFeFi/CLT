package MeuJogoJava.src.tile;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tile {

     private BufferedImage image;
    private final int id;
    public boolean isSolid;
    public static final int tileWidth = 80;
    public static final int tileHeight = 80;
     
     public Tile(String imagePath, int id, boolean isSolid) {
        this.id = id;
        this.image = loadImage(imagePath);
        this.isSolid = isSolid;
    }

    private BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
 
     public void draw(Graphics2D g2, int x, int y){
         g2.drawImage(image,x,y,tileWidth,tileHeight,null);
 
     }
 
     public int getId() {
         return id;
     }
 
     public boolean isSolid() {
         return false;
     }
}
