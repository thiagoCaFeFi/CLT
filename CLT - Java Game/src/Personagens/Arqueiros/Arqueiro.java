package Personagens.Arqueiros;

import Personagens.Personagem;

public class Arqueiro extends Personagem {

    public Arqueiro(String nome, int vida, int mana, int nivel) {
        super(nome, vida, mana, nivel);
        setVida(getVida() + getConstitution());
    }

    @Override
    public String getClasse() {
        return "Arqueiro";
    }
}
