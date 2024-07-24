package MeuJogoJava.src.objetos;

import java.io.IOException;
import javax.imageio.ImageIO;
import MeuJogoJava.src.entidades.Personagens;

public class PocaoDeForca extends Objetos {
    private int aumentoForca;

    public PocaoDeForca() {

        nome = "Poção de Aumento de Força";
        try {
            foto = ImageIO.read(getClass().getResourceAsStream("res/objetos/Consumiveis/Big Vial - PURPLE - 0000.png"));
        } catch (IOException e) {
            e.printStackTrace();
            
        }
        aumentoForca = 5;
    }
    public void usouItem(Personagens player) {
        player.aumentarDano(aumentoForca);
    }
}
