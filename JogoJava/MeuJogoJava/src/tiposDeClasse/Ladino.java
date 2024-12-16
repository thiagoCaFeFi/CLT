package MeuJogoJava.src.tiposDeClasse;

import MeuJogoJava.src.Personagem;
import MeuJogoJava.src.principais.Personagens;

public class Ladino extends Personagens {

    public Ladino(String nome, int vida, int mana, int nivel) {
        super(nome, vida, mana, nivel);
        setVida(getVida() + getConstitution());
        setDexterity(getDexterity());
    }

    @Override
    public String getClasse() {
        return "Ladino";
    }
}