package MeuJogoJava.lib;

public class Personagens {
    private String nome, classe; //nome do personagem e a classe dele (guerreiro, mago, etc.)
    private int vida, mana, vidaAtual, manaAtual, experiencia, nivel; //variavéis de status base
    private int strenght, dexterity, constitution, inteligence, wisdow, charisma; //atributos

//Construtor de personagem
    public void Personagem (String nome, String classe, int vida, int mana, int experiencia, int nivel){
    this.classe = classe;
    this.nome = nome;
    this.vida = vida;
    this.mana = mana;
    this.experiencia = 0;
    this.nivel = 1;
    definirNomePorClasse(classe);
    }

    public String getClasse(){
        return classe;
    }
    public String getNome() {
        return nome;
    }
    private void definirNomePorClasse(String classe) {
        switch (classe) {
            case "Guerreiro":
                this.nome = "Cleto";
                break;
            case "Mago":
                this.nome = "Ronaldo";
                break;
            case "Paladino":
                this.nome = "Marcelo";
                break;
            case "Bardo":
                this.nome = "Wesley";
                break;
            default:
                break;
        }
    }
    public int getNivel () {
        return nivel;
    }
    public int getVida (){
        return vida;
    }
    public void setVida (){
        if (vidaAtual != vida) {
            vida = vidaAtual;
        }
    }
    public int getMana (){
        return mana;
    }
    public void setMana (){
        if (manaAtual != mana) {
            mana = manaAtual;
        }
    }
    public int getEXperiencia (){
        return experiencia;
    }
    public int getStrenght (){
        return strenght;
    }
    public int getDexterity (){
        return dexterity;
    }
    public int getConstitution (){
        return constitution;
    }
    public int getInteligence (){
        return inteligence;
    }
    public int getWisdow (){
        return wisdow;
    }
    public int getCharisma (){
        return charisma;
    }
    public void setExperiencia(int experienciaAtual) {
        experiencia = experienciaAtual;
        // Verifica se o personagem ganhou um novo nível
        if (experiencia >= 100) {
            nivel++; 
            experiencia = 0; 
        }
    }
}

