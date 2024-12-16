package Item.Armaduras;

import Item.Itens;

public abstract class Armadura extends Itens {
    private int Constitution;
    private int bonusArmadura;

    public Armadura(String nome, int Constitution, int bonusArmadura) {
        super(nome);
        this.Constitution = Constitution;
        this.bonusArmadura = bonusArmadura;
    }

    public int getConstitution() {
        return Constitution;
    }

    public int getBonus() {
        return bonusArmadura;
    }
}
