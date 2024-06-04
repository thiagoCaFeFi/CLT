package Personagens;

public abstract class Personagem {
    private String nome;
    private int vida, mana, nivel;
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;

    
    //inteligencia entra no somatório da mana, enquanto a sabedoria entra no somatório de buscar item e em interações com NPCs (sabedoria e carisma).
    

    public Personagem(String nome, int vida, int mana, int nivel) {
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.nivel = nivel;
        this.strength = 1;
        this.dexterity = 1;
        this.constitution = 1;
        this.intelligence = 1;
        this.wisdom = 1;
        this.charisma = 1;
    }
    public String getNome() { 
        return nome; 
    }
    public int getVida() { 
        return vida;
    }
    public int getMana() { 
        return mana;
    }
    public int getNivel() { 
        return nivel;
    }
    public int getStrength() {
         return strength;
    }
    public int getDexterity() {
         return dexterity;
    }
    public int getConstitution() {
         return constitution;
    }
    public int getIntelligence() { 
        return intelligence;
    }
    public int getWisdom() {
         return wisdom; 
    }
    public int getCharisma() { 
        return charisma;
    }
    public void setVida(int vida) { 
        this.vida = vida;
    }
    public void setMana(int mana) { 
        this.mana = mana;
    }
    public void setNivel(int nivel) { 
        this.nivel = nivel;
    }
    public void setStrength(int strength) { 
        this.strength = strength; 
    }
    public void setDexterity(int dexterity) { 
        this.dexterity = dexterity;
    }
    public void setConstitution(int constitution) { 
        this.constitution = constitution; 
    }
    public void setIntelligence(int intelligence) { 
        this.intelligence = intelligence;
    }
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom; 
    }
    public void setCharisma(int charisma) { 
        this.charisma = charisma;
    }
    public void levelUp() {

        setNivel(getNivel() + 1);
        setStrength(getStrength() + 1);
        setDexterity(getDexterity() + 1);
        setConstitution(getConstitution() + 1);
        setIntelligence(getIntelligence() + 1);
        setWisdom(getWisdom() + 1);
        setCharisma(getCharisma() + 1);
    }
    public abstract String getClasse();
}
