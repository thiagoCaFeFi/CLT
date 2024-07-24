package MeuJogoJava.src.objetos.Armas.Espadas;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import MeuJogoJava.src.entidades.Personagens;
import MeuJogoJava.src.objetos.Objetos;

public class EspadaDeTitaneo extends Objetos {
     int danoItem;

    public EspadaDeTitaneo () {
        danoItem = 25 * nivel;
    }

    public String getDescricao() {

        return "Uma Espada de Titaneo que causa " + danoItem + " de dano.";
    }

    public int getDano() {

        return danoItem;
    }

    public void getFoto(BufferedImage foto){
        try{
            foto = ImageIO.read(getClass().getResourceAsStream("res/objetos/Armas/sword_2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void usouItem(Personagens personagem) {

    }
}