package MeuJogoJava.src.principais;

import MeuJogoJava.src.main.PainelDeJogo;

public abstract class SerVivo {
    PainelDeJogo gp;
    private boolean EstaVivo;
    private int vida;
    private String nome;
    private int posicaoX, posicaoY, velocidade;
    SerVivo( PainelDeJogo gp){

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

}
