package MeuJogoJava.src.entidades.npc;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import MeuJogoJava.src.entidades.Entity;
import MeuJogoJava.src.main.PainelDeJogo;

public class Mercante extends Entity{
    PainelDeJogo gp;

    public Mercante(PainelDeJogo gp, int startX, int startY) {
        super(gp);
        this.posicaoX = startX;
        this.posicaoY = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -45;
        bounds.y = -70;
        bounds.width = 80;
        bounds.height = 100;
    }

    private void loadSprites() {
        try {
            image1 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/npcs/mercante/necromancer_anim_f1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/npcs/mercante/necromancer_anim_f1-ezgif.com-rotate.png"));
            


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        spriteCounter++;
        if (spriteCounter >= 6) {
            spriteCounter = 0;
            spriteNum++;
            if (spriteNum > 2) {
                spriteNum = 1;
            }
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        if (spriteNum == 1) {
            image = image1;
        } else if (spriteNum == 2) {
            image = image2;
        }
        g2.drawImage(image, (int) (posicaoX - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo)), (int) (posicaoY - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo)), gp.tamanhoTitulo*2, gp.tamanhoTitulo*2, null);



    }


    public int tipo() {
        return 2;
    }

    public String getFala(){ 
        return "Deseja comprar algo? \n" +
                "1 - Poção de Força  (G 40)\n" +
                "2 - Poção de Vitalidade (G 60)\n";
    }

}
