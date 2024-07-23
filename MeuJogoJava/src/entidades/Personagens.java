package MeuJogoJava.src.entidades;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.entidades.tiposDeInimigos.GeneralDasSombras;
import MeuJogoJava.src.entidades.tiposDeInimigos.HobGoblin;
import MeuJogoJava.src.main.KeyHandler;
import java.awt.*;
import java.awt.image.BufferedImage;
import MeuJogoJava.src.tile.Tile;

import java.util.ArrayList;


import MeuJogoJava.src.objetos.Objetos;
import MeuJogoJava.src.objetos.PocaoDeForca;
import MeuJogoJava.src.objetos.PocaoVitalidade;
import MeuJogoJava.src.principais.Combate;

public class Personagens extends Entity {
     private KeyHandler keyH;
     private Combate combate; 
     public ArrayList<Objetos> inventario = new ArrayList<Objetos>();
     public final int maxInventarioSize = 20;
     public int mana,manaMax;
     public int xpMax;
     public int xp;
     public Entity atualEntity;
     public int moeda,dano;
     protected boolean isSpecialAttack = false;
     



//Construtor de personagem
    public Personagens(PainelDeJogo gp, KeyHandler keyH){
        super(gp);
        this.keyH = keyH;
        setDefaultValues();
        bounds = new Rectangle();
        direcao = "frente";
        
    }
    public void iniciarDialogo() {
     gp.setEstadoPersonagem(PainelDeJogo.EstadoPersonagem.Dialogo);
}
    
    public int getVida() { 
        return vida; 
        
    }
    public int getMana() { 
        return mana; 
        }
        public void ganharXp(int xpGanho){
          gp.getPlayer().xp += xpGanho;
          subirDeLevel();

     }
     public void comprarCura(){
          if(moeda>=60){
               PocaoVitalidade pocaoVitalidade = new PocaoVitalidade();
               inventario.add(pocaoVitalidade);
               gp.getUi().addMensagem("Você recebeu uma poção! i para abrir inventário");
               moeda -= 60;
          }
          }
          public void comprarPocaoForca() {
               if(moeda>=40){
                    PocaoDeForca pocao = new PocaoDeForca();
                    inventario.add(pocao);
                    gp.getUi().addMensagem("Você recebeu uma poção de força! I para abrir inventário");
                    moeda -= 40;
               }
     
          }
        public void alinharPersonagensCombate(Entity entity){
         if (entity instanceof HobGoblin){
               posicaoY = entity.posicaoY + gp.tamanhoTitulo * 24 / 10;
               posicaoX = entity.posicaoX + gp.tamanhoTitulo * 12 / 10;
          }else if (entity instanceof GeneralDasSombras){
               posicaoY = entity.posicaoY + gp.tamanhoTitulo * 50 / 10;
               posicaoX = entity.posicaoX + gp.tamanhoTitulo * 30 / 10;
          }
     }

        public void setSpecialAttack(boolean valor){
          this.isSpecialAttack = valor;
     }
     public boolean getSpecialAttack(){
          return isSpecialAttack;
     }
     
       
    protected void setDefaultValues() {
        posicaoX = gp.tamanhoTitulo*15;
        posicaoY = gp.tamanhoTitulo*18;
        vida = 50;
        vidaMaxima =50;
        velocidade =4;
   }
   protected boolean collisionWithTile(int x, int y) {
     return gp.getCurrentMap().getTile(x,y).isSolid();
}
   public void update() {
     Entity collidedEntity = null;
     if (gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Combate  && combate != null) {
          direcao = "frente";
          combate.update();
          alinharPersonagensCombate(atualEntity);
          System.out.println(isSpecialAttack + "player");
          System.out.println(gp.getPlayer().isSpecialAttack + "gp");
     }
      else {
    if (keyH.paraCima) {
         if(direcao=="frente"){
              direcao = "frente";
         } else {
              direcao = "costas";
         }
         movimentacao = "movendo";

         collidedEntity = checkEntityColissions(0, -velocidade);
                    if (collidedEntity == null) {
                         int ty = (int) ((posicaoY - velocidade + bounds.y) / Tile.tileHeight);
                         if (!collisionWithTile((int) ((posicaoX + bounds.x) / Tile.tileWidth), ty) &&
                                 !collisionWithTile((int) ((posicaoX + bounds.x + bounds.width) / Tile.tileWidth), ty)) {
                              posicaoY -= velocidade;
                         }
         }
    } else if (keyH.paraBaixo) {
         if(direcao=="frente") {
              direcao = "frente";
         } else {
              direcao = "costas";
         }
         movimentacao = "movendo";

         collidedEntity = checkEntityColissions(0, velocidade);
                    if (collidedEntity == null) {
                         int by = (int) ((posicaoY + velocidade + bounds.y + bounds.height) / Tile.tileHeight);
                         if (!collisionWithTile((int) ((posicaoX + bounds.x) / Tile.tileWidth), by) &&
                                 !collisionWithTile((int) ((posicaoX + bounds.x + bounds.width) / Tile.tileWidth), by)) {
                              posicaoY += velocidade;
                                 }
                         }
    } else if (keyH.paraEsquerda) {
         direcao = "costas";
         movimentacao = "movendo";

         collidedEntity = checkEntityColissions(-velocidade, 0);
                    if (collidedEntity == null) {
                         int tx = (int) ((posicaoX - velocidade + bounds.x) / Tile.tileWidth);
                         if (!collisionWithTile(tx, (int) ((posicaoY + bounds.y) / Tile.tileHeight)) &&
                                 !collisionWithTile(tx, (int) ((posicaoY + bounds.y + bounds.height) / Tile.tileHeight))) {
                              posicaoX -= velocidade;
                         }
         }
    } else if (keyH.paraDireita) {
         direcao = "frente";
         movimentacao = "movendo";

         collidedEntity = checkEntityColissions(velocidade, 0);
                    if (collidedEntity == null) {
                         int bx = (int) ((posicaoX + velocidade + bounds.x + bounds.width) / Tile.tileWidth);
                         if (!collisionWithTile(bx, (int) ((posicaoY + bounds.y) / Tile.tileHeight)) &&
                                 !collisionWithTile(bx, (int) ((posicaoY + bounds.y + bounds.height) / Tile.tileHeight))) {
                              posicaoX += velocidade;
                         }
                    }
    } else {
         movimentacao = "parado";
    }

    spriteCounter++;
    if (spriteCounter >= 5) {
         spriteCounter = 0; 
         spriteNum++; 
         if (spriteNum > 6) {
              spriteNum = 1; 
         }
    }
    gp.getCamera().centerOnEntity(this);
}
   }
public void draw(Graphics2D g2) {
    BufferedImage image = null;

    if (movimentacao != null && movimentacao.equals("parado")) {
         if (spriteNum == 1) {
              if (direcao.equals("frente")) {
                   image = idle;
              } else if (direcao.equals("costas")) {
                   image = idleback;
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
              }
         }
    }

    g2.drawImage(image,
            (int) (posicaoX - gp.getCamera().getxOffSet() - (gp.tamanhoTitulo * 9) / 4),
            (int) (posicaoY - gp.getCamera().getyOffSet() - (gp.tamanhoTitulo * 10) / 3),
            gp.tamanhoTitulo * 4,
            gp.tamanhoTitulo * 4,
            null);


}
public void subirDeLevel(){
     if (gp.getPlayer().xp >= gp.getPlayer().xpMax) {
          gp.getUi().addMensagem("Você aumentou o nível! Pressione P para abrir o perfil");
          gp.getPlayer().level += 1;
          gp.getPlayer().xp -= gp.getPlayer().xpMax;
          vidaMaxima += level*2;
          vida = vidaMaxima;
          gp.getPlayer().manaMax += level*2;
          mana = manaMax;
          dano += 1;
          // defesa += 1;
          setXpMax();
     }
}
public int getXp(){
     return xp;
}
public int getLevel(){
     return level;
}
public void setXpMax(){
     if (level > 1){
          xpMax += level*15/10;

     }
}
public int getXpMax(){
     return xpMax;
}
public void receberDamage(int dano){
     int vidaTeste = vida - dano;
     if(vidaTeste < 0 ) {
          this.vida = 0;
     } else {
          this.vida = vida - dano;
     }
}
public void curarVida(){
     vida += vidaMaxima*75/100;
}

public int getDano(){
     return dano;
}

public void aumentarDano(int aumento){
     dano = dano + aumento;
}
public void ganharMoeda(int moedaGanha){
     gp.getPlayer().moeda += moedaGanha;

}



public void iniciarCombate(Entity entity) {

     gp.getPlayer().atualEntity = entity;
     combate = new Combate(gp, entity);
     entity.posicaoX += (gp.tamanhoTitulo);
}
protected void handleCollision(Entity entity) {
     int entityType = entity.tipo();
     boolean jaDialogou = false;
     switch (entityType) {
          case 1:
               break;
          case 2:
               if (!jaDialogou) {
                    iniciarDialogo();
                    String fala = entity.getFala();

                    gp.getDialogues().setDialogueText(fala);

                    jaDialogou = true;
               }
               break;
          case 3:
               atualEntity = entity;
               keyH.paraCima = false;
               keyH.paraBaixo = false;
               keyH.paraEsquerda = false;
               keyH.paraDireita = false;              
               gp.setEstadoPersonagem(PainelDeJogo.EstadoPersonagem.Combate);
               iniciarCombate(entity);
               break;
     }
}
public int tipo() {
     return 1;
}
}





