package MeuJogoJava.src.objetos.Armas.Cajados;


import MeuJogoJava.src.entidades.Personagens;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import MeuJogoJava.src.objetos.Objetos;

public class CajadoDeDiamante extends Objetos {

    public CajadoDeDiamante() {
        consumoMana = 25 / nivel;
        danoItem = 35 * nivel;
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
            foto = ImageIO.read(getClass().getResourceAsStream("res/objetos/Armas/Cajado2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void usouItem(Personagens personagem) {

    }
}