package MeuJogoJava.src.tiposDeClasse;

import MeuJogoJava.src.Personagem;
import MeuJogoJava.src.principais.Personagens;

public class Mago extends Personagens {

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