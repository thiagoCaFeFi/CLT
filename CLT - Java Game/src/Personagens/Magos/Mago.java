package Personagens.Magos;

import Personagens.Personagem;

public class Mago extends Personagem {

    public Mago(String nome, int vida, int mana, int nivel) {
        super(nome, vida, mana, nivel);
        setMana(getMana() + getIntelligence());
        setVida(getVida() + getConstitution());
    }

    @Override
    public String getClasse() {
        return "Mago";
    }
}
