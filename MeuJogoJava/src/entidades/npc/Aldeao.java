package MeuJogoJava.src.entidades.npc;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import MeuJogoJava.src.entidades.Entity;
import MeuJogoJava.src.main.PainelDeJogo;

public class Aldeao extends Entity{
    public Aldeao(PainelDeJogo gp, int startX, int startY) {
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
            image1 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/npcs/aldeao/aldeao.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/npcs/aldeao/aldeao1.png"));
            
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
        g2.drawImage(image, (int) (posicaoX - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo)), (int) (posicaoY - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo)), gp.tamanhoTitulo*14/10, gp.tamanhoTitulo*14/10, null);



    }


    public int tipo() {
        return 2;
    }

    public String getFala(){
        return "Eu sei que a Umbra é o grande problema, mas os goblins estão aproveitando a bagunça para saquear nas proximidades de nossa aldeia... você pode dar um jeito neles primeiro?\n" + "1 - Sim  (Elimine os goblins dessa região)\n" + "2 - Não\n";
    }
    public String getResposta(){
        return "Ok";
    }
}
