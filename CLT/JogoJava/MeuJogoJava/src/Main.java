package MeuJogoJava.src;

public class Main {
    public static void main(String[] args) {
        Guerreiro guerreiro = new Guerreiro("Brunão", 100, 50, 1);
        Arqueiro arqueiro = new Arqueiro("Cleto", 80, 60, 1);
        Mago mago = new Mago("Ronaldinho", 60, 100, 1);
        Paladino paladino = new Paladino("Joba", 90, 70, 1);
        Bardo bardo = new Bardo ("Alfredo", 50, 70, 1);
        Clerigo clerigo = new Clerigo ("Miguel", 50, 70, 1);
        Ladino ladino = new Ladino("Luis", 40, 50, 1);

        System.out.println("Classe: " + guerreiro.getClasse() + ", Nome: " + guerreiro.getNome() + ", Vida: " + guerreiro.getVida() + ", Força: " + guerreiro.getStrength());
        System.out.println("Classe: " + arqueiro.getClasse() + ", Nome: " + arqueiro.getNome() + ", Vida: " + arqueiro.getVida() + ", Destreza: " + arqueiro.getDexterity());
        System.out.println("Classe: " + mago.getClasse() + ", Nome: " + mago.getNome() + ", Mana: " + mago.getMana() + ", Inteligência: " + mago.getIntelligence());
        System.out.println("Classe: " + paladino.getClasse() + ", Nome: " + paladino.getNome() + ", Vida: " + paladino.getVida() + ", Mana: " + paladino.getMana() + ", Constituição: " + paladino.getConstitution());

        // Level up examples
        guerreiro.levelUp();
        arqueiro.levelUp();
        mago.levelUp();
        paladino.levelUp();
        bardo.levelUp();
        clerigo.levelUp();
        ladino.levelUp();
        
        System.out.println("Após subir de nível:");
        System.out.println("Guerreiro nível: " + guerreiro.getNivel() + ", Vida: " + guerreiro.getVida() + ", Força: " + guerreiro.getStrength());
        System.out.println("Arqueiro nível: " + arqueiro.getNivel() + ", Vida: " + arqueiro.getVida() + ", Destreza: " + arqueiro.getDexterity());
        System.out.println("Mago nível: " + mago.getNivel() + ", Mana: " + mago.getMana() + ", Inteligência: " + mago.getIntelligence());
        System.out.println("Paladino nível: " + paladino.getNivel() + ", Vida: " + paladino.getVida() + ", Mana: " + paladino.getMana() + ", Constituição: " + paladino.getConstitution());
    }
}