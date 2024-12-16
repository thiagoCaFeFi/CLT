package MeuJogoJava.src.principais;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.main.KeyHandler;
import java.awt.*;
import java.awt.image.BufferedImage;
import MeuJogoJava.src.tile.Tile;
import java.util.ArrayList;
import MeuJogoJava.src.objetos.Objetos;


import MeuJogoJava.src.main.PainelDeJogo;

public class Personagens extends SerVivo {
    private int vida, mana, experiencia; //variavéis de status base
    //private int strenght, dexterity, constitution, inteligence, wisdow, charisma; //atributos
    private KeyHandler keyH;
     private int xp, nivel;
     private Combate combate; //iniciar combate por aproximacao no mato a ser implementada
     public ArrayList<Objetos> inventario = new ArrayList<Objetos>();
     public final int maxInventarioSize = 20;
     private boolean jaDialogou = false;



//Construtor de personagem
    public Personagens(PainelDeJogo gp, KeyHandler keyH){
        super(gp);
        this.keyH = keyH;
        setDefaultValues();
        bounds = new Rectangle();
        direcao = "frente";
        
    }
    public boolean iniciarDialogo(int x, int y) {
        Point posicaoDialogo = gp.getCurrentMap().findTileCoordinates(4);
        if (posicaoDialogo != null && posicaoDialogo.equals(new Point(x, y)) && !jaDialogou) {
             gp.setEstadoPersonagem(PainelDeJogo.EstadoPersonagem.Dialogo);
             jaDialogou = true;
             return true;
        }
        return false;
   }
    public int getVida() { 
        return vida; 
        
    }
    public int getMana() { 
        return mana; 
        }
        public String getNome() { 
            return nome; 
    }
    public void setExperiencia(int experienciaAtual) {
        experiencia = experienciaAtual;
        if (experiencia >= 100) {
            nivel++; 
            experiencia = 0; 
        }
    }
    protected void setDefaultValues() {
        posicaoX = gp.tamanhoTitulo*15;
        posicaoY = gp.tamanhoTitulo*18;
        vida = 50;
        vidaMaxima =50;
        velocidade =4;

   }
   public void update() {

    if (keyH.paraCima) {
         if(direcao=="frente"){
              direcao = "frente";
         } else {
              direcao = "costas";
         }
         movimentacao = "movendo";

         int ty = (int) ((posicaoY - velocidade + bounds.y) / Tile.tileHeight);
         if (!collisionWithTile((int) ((x + bounds.x) / Tile.tileWidth), ty) &&
                 !collisionWithTile((int) ((x + bounds.x + bounds.width) / Tile.tileWidth), ty)) {
              posicaoY = posicaoY - velocidade;
         }
    } else if (keyH.paraBaixo) {
         if(direcao=="frente") {
              direcao = "frente";
         } else {
              direcao = "costas";
         }
         movimentacao = "movendo";

         int by = (int) ((posicaoY + velocidade + bounds.y + bounds.height) / Tile.tileHeight);
         if (!collisionWithTile((int) ((x + bounds.x) / Tile.tileWidth), by) &&
                 !collisionWithTile((int) ((x + bounds.x + bounds.width) / Tile.tileWidth), by)) {
                    posicaoY = posicaoY + velocidade;
         }
    } else if (keyH.paraEsquerda) {
         direcao = "costas";
         movimentacao = "movendo";

         int tx = (int) ((x - velocidade + bounds.x) / Tile.tileWidth);
         if (!collisionWithTile(tx, (int) ((posicaoY + bounds.y) / Tile.tileHeight)) &&
                 !collisionWithTile(tx, (int) ((posicaoY + bounds.y + bounds.height) / Tile.tileHeight))) {
              x = x - velocidade;
         }
    } else if (keyH.paraDireita) {
         direcao = "frente";
         movimentacao = "movendo";

         int bx = (int) ((x + velocidade + bounds.x + bounds.width) / Tile.tileWidth);
         if (!collisionWithTile(bx, (int) ((posicaoY + bounds.y) / Tile.tileHeight)) &&
                 !collisionWithTile(bx, (int) ((posicaoY + bounds.y + bounds.height) / Tile.tileHeight))) {
              x = x + velocidade;
         }
    } else {
         movimentacao = "parado";
    }

    iniciarCombate((int) posicaoX / Tile.tileWidth, (int) posicaoY / Tile.tileHeight);
    iniciarDialogo(posicaoY/Tile.tileWidth,posicaoY/Tile.tileHeight);
    spriteCounter++;
    if (spriteCounter >= 5) {
         spriteCounter = 0; 
         spriteNum++; 
         if (spriteNum > 7) {
              spriteNum = 1; 
         }
    }
    gp.getCamera().centerOnEntity(this);
}

public void draw(Graphics2D g2) {
    BufferedImage image = null;

    if (movimentacao != null && movimentacao.equals("parado")) {
         if (spriteNum == 1) {
              if (direcao.equals("frente")) {
                   image = sprite1;
              } else if (direcao.equals("costas")) {
                   image = sprite2;
              }
         } else if (spriteNum == 2) {
              if (direcao.equals("frente")) {
                   image = idle2;
              } else if (direcao.equals("costas")) {
                   image = idle2back;
              }
         } else if (spriteNum == 3) {
              if (direcao.equals("frente")) {
                   image = idle3;
              } else if (direcao.equals("costas")) {
                   image = idle3back;
              }
         } else if (spriteNum == 4) {
              if (direcao.equals("frente")) {
                   image = idle4;
              } else if (direcao.equals("costas")) {
                   image = idle4back;
              }
         } else if (spriteNum == 5) {
              if (direcao.equals("frente")) {
                   image = idle5;
              } else if (direcao.equals("costas")) {
                   image = idle5back;
              }
         } else if(spriteNum==6) {
              if (direcao.equals("frente")) {
                   image = idle6;

              } else if (direcao.equals("costas")) {
                   image = idle6back;
              }

         } else if (spriteNum ==7) {
              if(direcao.equals("frente")) {
                   image = idle7;
              } else if (direcao.equals("costas")) {
                   image = idle6back;
              }
         } else if (spriteNum ==8) {
              if(direcao.equals("frente")) {
                   image = idle8;
              } else if (direcao.equals("costas")) {
                   image = idle6back;
              }
         }
    } else {
         if (direcao.equals("frente")) {
              if (spriteNum == 1) {
                   image = run;
              } else if (spriteNum == 2) {
                   image = run2;
              } else if (spriteNum == 3) {
                   image = run3;
              } else if (spriteNum == 4) {
                   image = run4;
              } else if (spriteNum == 5) {
                   image = run5;
              } else if (spriteNum == 6) {
                   image = run6;
              } else if (spriteNum ==7) {
                   image = run7;
              }
         } else if (direcao.equals("costas")) {
              if (spriteNum == 1) {
                   image = runcostas;
              } else if (spriteNum == 2) {
                   image = runcostas2;
              } else if (spriteNum == 3) {
                   image = runcostas3;
              } else if (spriteNum == 4) {
                   image = runcostas4;
              } else if (spriteNum == 5) {
                   image = runcostas5;
              } else if (spriteNum == 6 ) {
                   image  = runcostas6;
              } else if (spriteNum == 7) {
                   image =runcostas7;
              }
         }
    }

    g2.drawImage(image,
            (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo * 9) / 4),
            (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo * 10) / 3),
            gp.tamanhoTitulo * 4,
            gp.tamanhoTitulo * 4,
            null);


}
}



