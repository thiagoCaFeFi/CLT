package Personagens.Paladinos;

import Personagens.Personagem;

public class Paladino extends Personagem {

    public Paladino(String nome, int vida, int mana, int nivel) {
        super(nome, vida, mana, nivel);
        setVida(getVida() + getConstitution());
        setMana(getMana() + getCharisma());
    }

    @Override
    public String getClasse() {
        return "Paladino";
    }
}