package MeuJogoJava.src.entidades.tiposDeInimigos;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import MeuJogoJava.src.entidades.Entity;
import MeuJogoJava.src.main.PainelDeJogo;
public class HobGoblin extends Entity {
       private PainelDeJogo gp;
     public HobGoblin(PainelDeJogo gp, int startX, int startY){
        super(gp);
        this.posicaoX = startX;
        this.posicaoY = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = 220;
        bounds.y = 120;
        bounds.width = 160;
        bounds.height = 170;
        vida = 200;
        dano = 40;
        xpDrop = 100;
        moedaDrop = 200;
        boss = true;
    }



    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/ogre_idle_anim_f0.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/ogre_idle_anim_f1.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/ogre_idle_anim_f2.png"));
            
            

            idleback = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/ogre_idle_anim_f0-ezgif.com-rotate.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/ogre_idle_anim_f1-ezgif.com-rotate.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/ogre_idle_anim_f2-ezgif.com-rotate"));
            
          
            } catch (IOException e) {
            e.printStackTrace();
        }
}
public void draw(Graphics2D g2) {
    BufferedImage image = null;
    if (spriteNum == 1) {
                image = idle;
            } else if (spriteNum == 2) {
                image = idle2;
            } else if (spriteNum == 3) {
                image = idle3;
            } else if (spriteNum == 4) {
                image = idleback;
            } else if (spriteNum == 5) {
                image = idle2back;
            } else if (spriteNum == 6) {
                image = idle3back;
            }
            g2.drawImage(image, (int) (posicaoX - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo)), (int) (posicaoY - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo)), gp.tamanhoTitulo * 9, gp.tamanhoTitulo * 5, null);
}
public void update() {
    spriteCounter++;
            if (spriteCounter >= 4) {
                spriteCounter = 0;
                spriteNum++;
                if (spriteNum > 6) {
                    spriteNum = 1;
                }
            }
        }
        public int tipo() {
            return 3;
        }
}
