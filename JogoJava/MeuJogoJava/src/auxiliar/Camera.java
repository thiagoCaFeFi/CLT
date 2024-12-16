package MeuJogoJava.src.auxiliar;

import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.principais.SerVivo;


import MeuJogoJava.src.tile.Tile;

public class Camera {
    private float xOffSet, yOffSet;
    private PainelDeJogo gp;


    public Camera (PainelDeJogo gp,float xOffSet, float yOffSet) {
        this.gp = gp;
        this.xOffSet = xOffSet;
        this.yOffSet = yOffSet;

    }

    public void checkVoidSpace(){
        if(xOffSet<0){
            xOffSet = 0;
        } else if (xOffSet>gp.getCurrentMap().getWidth()* Tile.tileWidth - gp.tamanhoComprimento) {
            xOffSet = gp.getCurrentMap().getWidth()* Tile.tileWidth - gp.tamanhoComprimento;
        }
        if(yOffSet<0) {
            yOffSet = 0;
        } else if (yOffSet>gp.getCurrentMap().getHeight()*Tile.tileHeight- gp.tamanhoAltura) {
            yOffSet = gp.getCurrentMap().getHeight()*Tile.tileHeight- gp.tamanhoAltura;
        }
    }

    public void centerOnEntity(SerVivo e) {
        xOffSet = e.posicaoX -  gp.tamanhoComprimento / 2 ;
        yOffSet = e.posicaoY -  gp.tamanhoAltura / 2 ;
        checkVoidSpace();
    }

    public void move(float xAmt, float yAmt) {
        xOffSet = xOffSet + xAmt;
        yOffSet = yOffSet + yAmt;
        checkVoidSpace();
    }

    public float getxOffSet() {
        return xOffSet;
    }

    public void setxOffSet(float xOffSet) {
        this.xOffSet = xOffSet;
    }

    public float getyOffSet() {
        return yOffSet;
    }

    public void setyOffSet(float yOffSet) {
        this.yOffSet = yOffSet;
    }
}
