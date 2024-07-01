package MeuJogoJava.src.tiposDeClasse;

import MeuJogoJava.src.Personagem;
import MeuJogoJava.src.principais.Personagens;

public class Paladino extends Personagens {
    

    public Paladino(String nome, int vida, int mana, int nivel, int strength) {
        super(nome, vida, mana, nivel, strength);
        setVida(getVida() + getConstitution());  
    }

    @Override
    public String getClasse() {
        return "Paladino";
    }
}
