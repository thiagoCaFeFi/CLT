package MeuJogoJava.src;

public class Personagens {
    private String nome;
    private int vida, mana, vidaAtual, manaAtual, experiencia; //variavéis de status base
    private int strenght, dexterity, constitution, inteligence, wisdow, charisma; //atributos

//Construtor de personagem
    public Personagens(String nome, int vida){
    this.nome = nome;
    this.vida = vida;
    //this.mana = mana;
    //this.vidaAtual = vidaAtual;
    //this.manaAtual = manaAtual;
    //this.experiencia = experiencia;
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
}



