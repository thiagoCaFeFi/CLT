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
        bounds = new Rectangle(posicaoX, posicaoY, gp.getWidth(), gp.getHeight());
        bounds.x = -50;
        bounds.y = -70;
        bounds.width = 200;
        bounds.height = 250;
    }

    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/npcs/narrador/merchant_down_1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/npcs/narrador/merchant_down_2.png"));

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
        BufferedImage image = idle;
        if (spriteNum == 1) {
            image = idle;
        } else if (spriteNum == 2) {
            image = idle2;
        
        }
        g2.drawImage(image, (int) (posicaoX - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo)), (int) (posicaoY - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo)), gp.tamanhoTitulo*3, gp.tamanhoTitulo*3, null);
    }
    public String getFala(){
        return "Ouça bem, jovem aventureiro, pois o que estou prestes a revelar é de extrema importância. Uma força maligna, antiga como o próprio tempo, está despertando de seu sono profundo. Chama-se Umbra, um poder sombrio e insidioso que há muito foi selado pelos grandes magos do passado. Porém, os selos estão se enfraquecendo, e agora Umbra começa a se espalhar pela região de Galan. A terra, outrora fértil e cheia de vida, está se tornando desolada e perigosa. Se nada for feito, toda a nossa existência pode ser consumida pelas trevas. Você, com sua coragem e determinação, pode ser a chave para impedir que essa escuridão devore o nosso mundo.";
    }
    public int tipo(){
        return 2;
    }
}

