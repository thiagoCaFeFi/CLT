package MeuJogoJava.src;

public class Ladino extends Personagem {

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