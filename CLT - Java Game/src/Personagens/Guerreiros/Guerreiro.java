package Personagens.Guerreiros;

import Personagens.Personagem;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome, int vida, int mana, int nivel) {
        super(nome, vida, mana, nivel);
        setVida(getVida() + getConstitution());
    }

    @Override
    public String getClasse() {
        return "Guerreiro";
    }
}