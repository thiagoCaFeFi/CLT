package Item.Armas;

import Item.Itens;

public abstract class Arma extends Itens {
    private int dano;
    private int custoMana;
    private int custoVida;
    private int bonusArma;

    public Arma(String nome, int dano, int custoMana, int custoVida, int bonusArma) {
        super(nome);
        this.dano = dano;
        this.custoMana = custoMana;
        this.custoVida = custoVida;
        this.bonusArma = bonusArma;
    }

    public int getDano() {
        return dano;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public int getCustoVida() {
        return custoVida;
    }

    public int getBonus() {
        return bonusArma;
    }
}
