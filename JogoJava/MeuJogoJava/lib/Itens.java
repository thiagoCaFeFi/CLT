package MeuJogoJava.lib;

public class Itens {
    private String arma, escudo, magia;
    private int nivelArma, nivelMagia, danoBase, defesaBase, custoManaBase, custoVidaBase, bonus;

    public Itens(String arma, String escudo, int nivelArma, int nivelMagia, int danoBase, int defesaBase, int custoManaBase, int custoVidaBase, int bonus) {
        this.arma = arma;
        this.escudo = escudo;
        this.nivelArma = nivelArma;
        this.nivelMagia = nivelMagia;
        this.danoBase = danoBase;
        this.defesaBase = defesaBase;
        this.custoManaBase = custoManaBase;
        this.custoVidaBase = custoVidaBase;
        this.bonus = bonus;
    }

    public void definirItens(Personagens personagem) {
        String classeDoPersonagem = personagem.getClasse();
        int nivelDoPersonagem = personagem.getNivel();

        switch (classeDoPersonagem) {
            case "Guerreiro":
                if (nivelDoPersonagem == 1) {
                    arma = "Clava de Madeira";
                    escudo = "Escudo de Madeira";
                    danoBase = 5;
                    defesaBase = 2;
                } else if (nivelDoPersonagem == 2) {
                    arma = "Clava de Ferro";
                    escudo = "Escudo de pedra";
                    danoBase = 7;
                    defesaBase = 4;
                } else if (nivelDoPersonagem == 3) {
                    arma = "Martelo de Titâneo";
                    escudo = "Escudo de Titâneo";
                    danoBase = 11;
                    defesaBase = 6;
                } else if (nivelDoPersonagem == 4) {
                    arma = "Martelo Aurora";
                    escudo = "Armadura Viking";
                    danoBase = 20;
                    defesaBase = 8;
                    custoVidaBase = 4;
                } else if (nivelDoPersonagem == 5) {
                    arma = "Mjolnir";
                    escudo = "Armadura Titã";
                    danoBase = 28;
                    defesaBase = 15;
                    custoManaBase = 2;
                    bonus = personagem.getStrenght() + 6;
                }
                break;
            case "Mago":
                if (nivelDoPersonagem == 1) {
                    arma = "Cajado de Madeira";
                    danoBase = 10;
                    custoManaBase = 2;
                } else if (nivelDoPersonagem == 2) {
                    arma = "Cajado de Ferro";
                    danoBase = 14;
                    custoManaBase = 3;
                } else if (nivelDoPersonagem == 3) {
                    arma = "Cajado de Titâneo";
                    danoBase = 18;
                    custoManaBase = 4;
                } else if (nivelDoPersonagem == 4) {
                    arma = "Cajado de Merlim";
                    danoBase = 26;
                    custoManaBase = 7;
                    bonus = personagem.getMana() + 8;
                } else if (nivelDoPersonagem == 5) {
                    arma = "Cajado Bifrost";
                    danoBase = 34;
                    custoManaBase = 10;
                    bonus = personagem.getMana() + 12;
                }
                break;
            case "Paladino":
                if (nivelDoPersonagem == 1) {
                    arma = "Espada de Madeira";
                    escudo = "Armadura de Madeira";
                    danoBase = 5;
                    defesaBase = 5;
                } else if (nivelDoPersonagem == 2) {
                    arma = "Espada de Ferro";
                    escudo = "Armadura de Ferro";
                    danoBase = 8;
                    custoManaBase = 10;
                } else if (nivelDoPersonagem == 3) {
                    arma = "Espada de Titâneo";
                    escudo = "Aramdura de Titâneo";
                    danoBase = 11;
                    custoManaBase = 15;
                } else if (nivelDoPersonagem == 4) {
                    arma = "Espada Sagrada";
                    escudo = "Armadura de Pegasus";
                    danoBase = 16;
                    defesaBase = 22;
                    bonus = personagem.getVida() + 5;
                } else if (nivelDoPersonagem == 5) {
                    arma = "Excalibur";
                    escudo = "Escudo Divino: Aegis";
                    danoBase = 21;
                    bonus = personagem.getVida() + 10;
                }
                break;
            case "Bardo":
                if (nivelDoPersonagem == 1) {
                    arma = "Flauta de Madeira";
                    danoBase = 3;
                    custoManaBase = 1;
                } else if (nivelDoPersonagem == 2) {
                    arma = "Baixo";
                    danoBase = 8;
                    custoManaBase = 1;
                } else if (nivelDoPersonagem == 3) {
                    arma = "Bateria";
                    danoBase = 15;
                    custoManaBase = 2;
                } else if (nivelDoPersonagem == 4) {
                    arma = "Harpa Sagrada";
                    danoBase = 20;
                    custoManaBase = 4;
                    bonus = personagem.getCharisma() + 6;
                } else if (nivelDoPersonagem == 5) {
                    arma = "Guitarra do Slash";
                    danoBase = 34;
                    custoManaBase = 6;
                    bonus = personagem.getCharisma() + 12;
                }
                break;
            default:
                arma = "Espada Quebrada";
                escudo = "Escudo Quebrado";
                break;
        }
    }
}
