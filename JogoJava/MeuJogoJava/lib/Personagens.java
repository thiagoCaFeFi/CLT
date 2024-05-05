package MeuJogoJava.lib;

public class Personagens {
    private String nome;
    private int vida, mana, vidaAtual, manaAtual, experiencia; //variavéis de status base
    private int strenght, dexterity, constitution, inteligence, wisdow, charisma; //atributos

//Construtor de personagem
    public void Personagem(String nome, int vida, int mana, int vidaAtual, int manaAtual, int experiencia){
    this.nome = nome;
    this.vida = vida;
    this.mana = mana;
    this.vidaAtual = vidaAtual;
    this.manaAtual = manaAtual;
    this.experiencia = experiencia;
    }

}
