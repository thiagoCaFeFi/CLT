package MeuJogoJava.src.objetos;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import MeuJogoJava.src.entidades.Personagens;

public abstract class Objetos {
    public BufferedImage foto;
    public String nome;
    public List<Objetos> listaItens;
    public String descricao;
    public int nivel;
    public int defesa;
    public int consumoMana;
    public int danoItem;

    public Objetos() {

        listaItens = new ArrayList<>();
    }

    public void addItem(Objetos item) {

        listaItens.add(item);
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void usouItem(Personagens personagem);
}

