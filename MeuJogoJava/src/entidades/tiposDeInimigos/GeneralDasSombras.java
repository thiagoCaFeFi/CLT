package MeuJogoJava.src.entidades.tiposDeInimigos;

import javax.imageio.ImageIO;

import MeuJogoJava.src.entidades.Entity;
import MeuJogoJava.src.main.PainelDeJogo;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class GeneralDasSombras extends Entity{
      private PainelDeJogo gp;


    public GeneralDasSombras(PainelDeJogo gp, int startX, int startY){
        super(gp);
        this.posicaoX = startX;
        this.posicaoY = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = 450;
        bounds.y = 250;
        bounds.width = 400;
        bounds.height = 400;
        vida = 2000;
        dano = 100;
        xpDrop = 9999;
        moedaDrop = 9999;
        boss = true;
    }
    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/generalSombras/big_demon_idle_anim_f0.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/generalSombras/big_demon_idle_anim_f1.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/generalSombras/big_demon_idle_anim_f2.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/generalSombras/big_demon_idle_anim_f3.png"));
            

            idleback = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/generalSombras/big_demon_idle_anim_f0-ezgif.com-rotate.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/generalSombras/big_demon_idle_anim_f1-ezgif.com-rotate.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/generalSombras/big_demon_idle_anim_f2-ezgif.com-rotate.png"));
            idle4back = ImageIO.read(getClass().getResourceAsStream("/res/inimigos/generalSombras/big_demon_idle_anim_f3-ezgif.com-rotate.png"));
          
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
                image = idle4;
            } else if (spriteNum == 5) {
                image = idleback;
            } else if (spriteNum == 6) {
                image = idle2back;
            } else if (spriteNum == 7) {
                image = idle3back;
            } else if (spriteNum == 8){
                image = idle4back;
            }
            g2.drawImage(image, (int) (posicaoX - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo)), (int) (posicaoY - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo)), gp.tamanhoTitulo * 18 , gp.tamanhoTitulo * 10, null);
            g2.setColor(Color.RED);
            g2.drawRect((int) (posicaoX + bounds.x - gp.getCamera().getxOffSet()),
                (int) (posicaoY + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);
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
