package MeuJogoJava.src;

public class Bardo extends Personagem {

    public Bardo(String nome, int vida, int mana, int nivel) {
        super(nome, vida, mana, nivel);
        setVida(getVida() + getConstitution());
        setCharisma(getCharisma() + getWisdom() + 10);
        setMana(getMana() + getIntelligence());
    }

    @Override
    public String getClasse() {
        return "Bardo";
    }
}
