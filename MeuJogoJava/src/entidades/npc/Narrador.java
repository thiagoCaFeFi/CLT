package MeuJogoJava.src.entidades.npc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import MeuJogoJava.src.entidades.Entity;
import MeuJogoJava.src.main.PainelDeJogo;

public class Narrador extends Entity{
    public Narrador(PainelDeJogo gp, int startX, int startY) {
        super(gp);
        this.posicaoX = startX;
        this.posicaoY = startY;
        loadSprites();
    }

    private void loadSprites() {
        try {
            image1 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/npcs/narrador/merchant_down_1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/npcs/narrador/merchant_down_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        if (spriteNum == 1) {
            image = image1;
        } else if (spriteNum == 2) {
            image = image2;
        
        }
        g2.drawImage(image, (int) (posicaoX - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo)), (int) (posicaoY - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo)), gp.tamanhoTitulo*15/10, gp.tamanhoTitulo*15/10, null);
    }
    public String getFala(){
        return "Ouça bem, jovem aventureiro, pois o que estou prestes a revelar é de extrema importância. Uma força maligna, antiga como o próprio tempo, está despertando de seu sono profundo. Chama-se Umbra, um poder sombrio e insidioso que há muito foi selado pelos grandes magos do passado. Porém, os selos estão se enfraquecendo, e agora Umbra começa a se espalhar pela região de Galan. A terra, outrora fértil e cheia de vida, está se tornando desolada e perigosa. Se nada for feito, toda a nossa existência pode ser consumida pelas trevas. Você, com sua coragem e determinação, pode ser a chave para impedir que essa escuridão devore o nosso mundo.";
    }
    public int tipo(){
        return 2;
    }
}

