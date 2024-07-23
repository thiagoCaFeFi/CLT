package MeuJogoJava.src.entidades.npc;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import MeuJogoJava.src.entidades.Entity;
import MeuJogoJava.src.main.PainelDeJogo;

public class Casa extends Entity { 
    public Casa(PainelDeJogo gp, int startX, int startY) {
        super(gp);
        this.posicaoX = startX;
        this.posicaoY = startY;
        bounds = new Rectangle();
        bounds.x = -230;
        bounds.y = -400;
        bounds.width = 450;
        bounds.height = 400;
        loadSprites();
    }

    private void loadSprites() {
        try {
            image1 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/objetos/Peasant's_House-NoAnimation.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = image1;
        g2.drawImage(image,(int) (posicaoX - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo)*4), (int) (posicaoY - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo)*7), gp.tamanhoTitulo*8 , gp.tamanhoTitulo *8, null);

        g2.setColor(Color.RED);
        g2.drawRect((int) (posicaoX + bounds.x - gp.getCamera().getxOffSet()),
                (int) (posicaoY + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);

    }
                public int tipo(){
                    return 1;
                }
    
}
