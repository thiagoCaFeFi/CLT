package MeuJogoJava.src;

public class Guerreiro extends Personagem {

    public Guerreiro(String nome, int vida, int mana, int nivel, int strength) {
        super(nome, vida, mana, nivel, strength);
        setVida(getVida() + getConstitution());  
    }

    @Override
    public String getClasse() {
        return "Guerreiro";
    }

}