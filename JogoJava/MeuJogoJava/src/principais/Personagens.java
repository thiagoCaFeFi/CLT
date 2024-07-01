package MeuJogoJava.src.principais;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.main.KeyHandler;
import java.awt.*;

import MeuJogoJava.src.main.PainelDeJogo;

public class Personagens extends SerVivo {
    private String nome;
    private int vida, mana, experiencia; //variavéis de status base
    private int strenght, dexterity, constitution, inteligence, wisdow, charisma; //atributos
    private KeyHandler keyH;
     private int xp, nivel;
     private Combate combate;


//Construtor de personagem
    public Personagens(PainelDeJogo gp, KeyHandler keyH){
        super(gp);
        this.keyH = keyH;
        this.combate = new Combate();
    
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
}



