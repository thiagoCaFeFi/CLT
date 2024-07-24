package MeuJogoJava.src.objetos.Armas.Espadas;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import MeuJogoJava.src.entidades.Personagens;
import MeuJogoJava.src.objetos.Objetos;

public class EspadaDeLaminaCurta extends Objetos {
     int danoItem;

    public EspadaDeLaminaCurta(int nivel, BufferedImage foto) {
        danoItem = 10 * nivel;
    }

    public String getDescricao() {
        return "Uma de Lamina curta que causa " + danoItem + " de dano.";
    }

    public int getDano() {

        return danoItem;
    }

    public void getFoto(BufferedImage foto){
        try{
            foto = ImageIO.read(getClass().getResourceAsStream("res/objetos/Armas/Lamina_curta.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void usouItem(Personagens personagem) {

    }
}