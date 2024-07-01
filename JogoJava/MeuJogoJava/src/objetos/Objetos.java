package MeuJogoJava.src.objetos;
import MeuJogoJava.src.principais.Personagens;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Objetos {
    public BufferedImage image;
    public String nome;
    public List<Objetos> listaItens;

    public Objetos() {
        listaItens = new ArrayList<>();
    }

    public void addItem(Objetos item) {
        listaItens.add(item);
    }

    public abstract void usouItem(Personagens personagem);
}

