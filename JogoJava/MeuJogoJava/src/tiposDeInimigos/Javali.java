package MeuJogoJava.src.tiposDeInimigos;

import MeuJogoJava.src.principais.Inimigos;
import java.io.IOException;
import java.awt.*;
import javax.imageio.ImageIO;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.main.KeyHandler;

public class Javali extends Inimigos {
    private String nomeInimigo = "Javali";
    public Javali(PainelDeJogo gp, int dificuldadeInimigo, String nome){
        super(gp, dificuldadeInimigo);
        obterNomeInimigo("General das Sombras");
    }
    //private void loadSprites() {
        //try {
            //idle = ImageIO.read(getClass().getResourceAsStream("res/inimigos/Javali.png"));
       // } catch (IOException e) {
           // e.printStackTrace();
        //}
    //}
}
