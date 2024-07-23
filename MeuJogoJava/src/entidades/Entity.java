package MeuJogoJava.src.entidades;
import java.awt.image.BufferedImage;
import java.util.Random;

import MeuJogoJava.src.main.PainelDeJogo;
import java.awt.*;

public abstract class Entity {
    protected PainelDeJogo gp;
    public int xpDrop, moedaDrop;
    public BufferedImage image1, image2;
    public BufferedImage idle,idle2,idle3,idle4,idle5,idle6, idleback, idle2back, idle3back, idle4back, idle5back, idle6back, run, run2, run3, run4, run5, run6,runcostas, runcostas2, runcostas3, runcostas4, runcostas5, runcostas6;
    public boolean atacando;
    public boolean morto;
    public boolean morrendo;
    protected int vida;
    public int dano;
    public int vidaMaxima;
    private String nome;
    public String direcao;
    public int spriteNum = 1;
    public int spriteCounter = 0;
    public String movimentacao;
    protected Rectangle bounds;
    public boolean boss;
    public int posicaoX, posicaoY, velocidade, level;
    private boolean shouldBeRemoved;
    public int variacaoDeAtaque;
    private Random rand = new Random();
    

    
   
    protected Entity( PainelDeJogo gp){

        this.gp = gp;
    }
    public int getVida() { 
        return vida; 
        
    }
    public String getNome() { 
            return nome; 
    }
    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }
    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }
    public void variacaoAtaque() {
        atacando = true;
        variacaoDeAtaque = 1 + rand.nextInt(2);
   }
    public void update() {
        if(morrendo){
            morto = true;
            setShouldBeRemoved(true);
        }
        spriteCounter++;
        if (spriteCounter >= 5) {
            spriteCounter = 0;
            spriteNum++;
            if (spriteNum > 7) {
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
        g2.drawImage(image, (int) (posicaoX - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo)), (int) (posicaoY - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo)), gp.tamanhoTitulo, gp.tamanhoTitulo, null);

    }
    public Entity checkEntityColissions(float xOffSet, float yOffSet) { 

        for(Entity e : gp.getEntityManager().getEntities()) {

            if(e.equals(this)){
                continue;
            }

                if (e.getBoundsCollision(0f, 0f).intersects(getBoundsCollision(xOffSet, yOffSet))) {
                    System.out.println("colidiu com " + e.getClass().getSimpleName());
                    return e; // retornar e
                }
            }

        return null;
    }

    public Rectangle getBoundsCollision(float xOffset, float yOffset) {
        return new Rectangle((int)(posicaoX+ bounds.x+ xOffset), (int) (posicaoY + yOffset + bounds.y ), bounds.width,bounds.height);
    }
    public int getX() {
        return posicaoX;
    }


    public int getY() {
        return posicaoY;
    }

    public int getHeightBounds() {
        return bounds.height;
    }
    public abstract int tipo(); // Existem diveros tipos de colisao: 1 para colisao normal , 2 para npcs com dialogo e 3 para viloes com combate
    protected String getFala(){
        return "";
    }
    protected String getResposta(){
        return "";
    }

    public void receberDamage(int i) {
        if(vida>=i) {
            vida-=i;
        } else {
            vida = 0;
        }
    }
    public boolean shouldBeRemoved() {
        return shouldBeRemoved;
    }

    public void setShouldBeRemoved(boolean shouldBeRemoved) {
        this.shouldBeRemoved = shouldBeRemoved;
    }

}
