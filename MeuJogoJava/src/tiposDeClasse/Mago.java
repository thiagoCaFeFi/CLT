package MeuJogoJava.src.tiposDeClasse;

import java.io.IOException;

import javax.imageio.ImageIO;

import MeuJogoJava.src.entidades.Personagens;
import MeuJogoJava.src.main.KeyHandler;
import MeuJogoJava.src.main.PainelDeJogo;

public class Mago extends Personagens {

    public Mago(PainelDeJogo gp, KeyHandler keyH) {
         super(gp, keyH);
        loadSprites();
        velocidade = 6;
        bounds.y = -40;
        bounds.x = -30;
        bounds.width = 50;
        bounds.height = 80;
    }
    

    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle6.png"));

            idleback = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle1-ezgif.com-rotate.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle2-ezgif.com-rotate.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle3-ezgif.com-rotate.png"));
            idle4back = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle4-ezgif.com-rotate.png"));
            idle5back = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle5-ezgif.com-rotate.png"));
            idle6back = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Idle6-ezgif.com-rotate.png"));
            
            run = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Run1.png"));
            run2 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Run2.png"));
            run3 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Run3.png"));
            run4 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Run4.png"));
            run5 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Run5.png"));
            run6 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/Run6.png"));
            

            runcostas = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/run/Run1-ezgif.com-rotate.png"));
            runcostas2 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/run/Run2-ezgif.com-rotate.png"));
            runcostas3 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/run/Run3-ezgif.com-rotate.png"));
            runcostas4 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/run/Run4-ezgif.com-rotate.png"));
            runcostas5 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/run/Run5-ezgif.com-rotate.png"));
            runcostas6 = ImageIO.read(getClass().getResourceAsStream("/res/personagens/mago/run/Run6-ezgif.com-rotate.png"));
             } catch (IOException e) {
            e.printStackTrace();
        }
}
    }
