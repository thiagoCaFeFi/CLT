package MeuJogoJava.src.objetos.Shields;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import MeuJogoJava.src.entidades.Personagens;
import MeuJogoJava.src.objetos.Objetos;

public class EscudoDeMadeira extends Objetos {
    public EscudoDeMadeira() {
        this.defesa = 10 * nivel;
    }
    public String getDescricao() {
        return "Um escudo de madeira que oferece " + defesa + " de defesa.";
    }
    public void getFoto(BufferedImage foto){
        try{
            foto = ImageIO.read(getClass().getResourceAsStream("res/objetos/Shields/shield_wood.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void usouItem(Personagens personagem) {

    }
}

