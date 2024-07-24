package MeuJogoJava.src.objetos.Armas.Cajados;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import MeuJogoJava.src.entidades.Personagens;
import MeuJogoJava.src.objetos.Objetos;

public class CajadoDeEsmeralda extends Objetos {

    public CajadoDeEsmeralda() {
        consumoMana = 15 / nivel;
        danoItem = 20 * nivel;
    }

    public String getDescricao() {
        return "Um cajado de Esmeralda que consome " + consumoMana + " de mana.";
    }

    public int getDanoItem() {
        return danoItem;
    }

    public void setDanoItem(int danoItem) {
        this.danoItem = danoItem;
    }
    public void getFoto(BufferedImage foto){
        try{
            foto = ImageIO.read(getClass().getResourceAsStream("res/objetos/Armas/Cajado1.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void usouItem(Personagens personagem) {

    }
}