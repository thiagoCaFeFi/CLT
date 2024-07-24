package MeuJogoJava.src.objetos.Shields;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import MeuJogoJava.src.entidades.Personagens;
import MeuJogoJava.src.objetos.Objetos;

public class EscudoMagico extends Objetos {

    public EscudoMagico() {
        this.defesa = 20 * nivel;
        this.foto = foto;
    }

    public String getDescricao() {
        return "Um escudo mágico que oferece " + defesa + " de defesa.";
    }
    public void getFoto(BufferedImage foto){
        try{
            foto = ImageIO.read(getClass().getResourceAsStream("res/objetos/Shields/shield_blue.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void usouItem(Personagens personagem) {

    }
}