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

/*
 import java.awt.*;
import java.awt.image.BufferedImage;
import MeuJogoJava.src.main.PainelDeJogo;

public class Tile {
     // MATERIAIS ESTATICOS
     private static PainelDeJogo gp;
     public static Tile[] tiles = new Tile[100];
     public static Tile pisoTerra = new PisoTerra(1);
     public static Tile pisoGrama = new PisoGrama(2);
     public static Tile pisoAgua = new PisoAgua(3);
     public static Tile pisoTijoloPedra = new PisoAgua(3);
     
 
 
     // CLASSE
     public BufferedImage image;
     protected final int id;
     public boolean colission = false;
     public static final int tileWidth = gp.tamanhoTitulo, tileHeight = gp.tamanhoTitulo;
 
 
     public Tile(BufferedImage image,int id) {
         this.id = id;
         this.image = image;
         this.gp = new PainelDeJogo();
         tiles[id] = this;
     }
 
     public void update() {
 
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
 */
