package Item.Acessorios;

import Item.Itens;

public abstract class Acessorio extends Itens {
    private int BonusAcessorio;

    public Acessorio(String nome, int BonusAcessorio) {
        super(nome);
        this.BonusAcessorio = BonusAcessorio;
    }

    public int getBonus() {
        return BonusAcessorio;
    }
}

