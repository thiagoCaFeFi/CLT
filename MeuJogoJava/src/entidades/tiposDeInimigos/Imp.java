package MeuJogoJava.src.entidades.tiposDeInimigos;

import java.io.IOException;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import MeuJogoJava.src.entidades.Entity;
import MeuJogoJava.src.main.PainelDeJogo;


public class Imp extends Entity {
    private PainelDeJogo gp;


    public Imp(PainelDeJogo gp, int startX, int startY){
        super(gp);
        this.posicaoX = startX;
        this.posicaoY = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -60;
        bounds.y = -70;
        bounds.width = 80;
        bounds.height = 100;

        vida = 40;
        dano = 10;
        xpDrop = 10;
        moedaDrop = 15;
    }
    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/imp_idle_anim_f0.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/imp_idle_anim_f1.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/imp_idle_anim_f2.png"));
            
            

            idleback = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/imp_idle_anim_f0-ezgif.com-rotate.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/imp_idle_anim_f1-ezgif.com-rotate.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/imp/imp_idle_anim_f2-ezgif.com-rotate.png"));
            
          
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
            g2.drawImage(image, (int) (posicaoX - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo)), (int) (posicaoY - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo)), gp.tamanhoTitulo * 13 / 10, gp.tamanhoTitulo * 13 / 10, null);
}
public void update() {
    spriteCounter++;
            if (spriteCounter >= 5) {
                spriteCounter = 0;
                spriteNum++;
                if (spriteNum > 7) {
                    spriteNum = 1;
                }
            }
        }
        public int tipo() {
            return 3;
        }
}

