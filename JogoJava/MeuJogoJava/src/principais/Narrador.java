package MeuJogoJava.src.principais;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import MeuJogoJava.src.main.PainelDeJogo;

public class Narrador extends SerVivo{
    public Narrador(PainelDeJogo gp, int startX, int startY) {
        super(gp);
        this.posicaoX = startX;
        this.posicaoY = startY;
        loadSprites();
    }

    private void loadSprites() {
        try {
            sprite1 = ImageIO.read(getClass().getResourceAsStream("res/npcs/merchant_down_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = sprite1;
        g2.drawImage(image,(int) (posicaoX - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo *15) / 14), (int) (posicaoY - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo * 8) / 5), gp.tamanhoTitulo * 3, gp.tamanhoTitulo * 3, null);
    }
}

