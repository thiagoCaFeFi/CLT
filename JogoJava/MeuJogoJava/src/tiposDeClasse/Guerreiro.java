package MeuJogoJava.src.tiposDeClasse;

import MeuJogoJava.src.objetos.Objetos;
import MeuJogoJava.src.principais.Personagens;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.main.KeyHandler;
import javax.imageio.ImageIO;

import java.io.IOException;


public class Guerreiro extends Personagens {

    public Guerreiro(PainelDeJogo gp, KeyHandler keyH) {
        super(gp, keyH);
        loadSprites();
        velocidade = 6;
        bounds.y = -30;
        bounds.x = -45;
        bounds.width = 50;
        bounds.height = 70;

    }

    private void loadSprites() {
        try {
             sprite1 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_1.png"));
            sprite2 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_2.png"));
            sprite3 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_3.png"));
            sprite4 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_4.png"));
            sprite5 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_5.png"));
            sprite6 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_6.png"));
            sprite7 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_7.png"));
            sprite8 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_8.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}    
