package MeuJogoJava.src.tiposDeClasse;

import MeuJogoJava.src.Personagem;
import MeuJogoJava.src.principais.Personagens;

public class Guerreiro extends Personagens {

    public Guerreiro(String nome, int vida, int mana, int nivel, int strength) {
        super(nome, vida, mana, nivel, strength);
        setVida(getVida() + getConstitution());  
    }

    @Override
    public String getClasse() {
        return "Guerreiro";
    }

}