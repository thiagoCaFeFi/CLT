package Inimigos;

public abstract class Inimigo {
    private String tipo;
    private int health;
    private int damage;

    public Inimigo(String tipo, int health, int damage) {
        this.tipo = tipo;
        this.health = health;
        this.damage = damage;
    }

    public String getNome() {
        return tipo;
    }

    public int getHealth() {
        return health;
    }

    public int getDano() {
        return damage;
    }
}