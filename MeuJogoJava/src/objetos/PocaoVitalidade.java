package MeuJogoJava.src.objetos;

import java.io.IOException;

import javax.imageio.ImageIO;

import MeuJogoJava.src.entidades.Personagens;

public class PocaoVitalidade extends Objetos {
   public PocaoVitalidade() {

        nome = "Poção da Vitalidade";
        try {
            foto = ImageIO.read(getClass().getResourceAsStream("res/objetos/Consumiveis/Big Vial - RED - 0000.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void usouItem(Personagens player) {
        player.curarVida();
        System.out.println(player.getVida());
    }

}