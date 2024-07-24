package MeuJogoJava.src.objetos.Armas.Espadas;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import MeuJogoJava.src.entidades.Personagens;
import MeuJogoJava.src.objetos.Objetos;

public class EspadaDeFerro extends Objetos {
    private int danoItem;

    public EspadaDeFerro() {
        danoItem = 20 * nivel;
    }


    public String getDescricao() {
        return "Uma de Espada de Ferro que causa " + danoItem + " de dano.";
    }

    public int getDano() {

        return danoItem;
    }

    public void setDano(int dano) {
        this.danoItem = danoItem;
    }
    public void getFoto(BufferedImage foto){
        try{
            foto = ImageIO.read(getClass().getResourceAsStream("res/objetos/Armas/sword_normal.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void usouItem(Personagens personagem) {

    }
}