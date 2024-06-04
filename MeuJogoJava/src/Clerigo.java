package MeuJogoJava.src;

public class Clerigo extends Personagem {

    public Clerigo(String nome, int vida, int mana, int nivel) {
        super(nome, vida, mana, nivel);
        setVida(getVida() + getConstitution());
        setMana(getMana() + getIntelligence());
        setCharisma(getCharisma() + getWisdom());
    }

    @Override
    public String getClasse() {
        return "Clerigo";
    }
}