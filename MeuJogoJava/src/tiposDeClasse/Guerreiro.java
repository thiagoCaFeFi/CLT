package MeuJogoJava.src.tiposDeClasse;

import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.entidades.Personagens;
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
        bounds.width = 200;
        bounds.height = 250;

    }

    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiro1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiro2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiro3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiro4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiro5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiro6.png"));

            idleback = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroCosta.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroCosta2.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroCosta3.png"));
            idle4back = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroCosta4.png"));
            idle5back = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroCosta5.png"));
            idle6back = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroCosta6.png"));
            
            run = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRun.png"));
            run2 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRun2.png"));
            run3 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRun3.png"));
            run4 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRun4.png"));
            run5 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRun5.png"));
            run6 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRun6.png"));
            

            runcostas = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRunBack.png"));
            runcostas2 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRun2Back.png"));
            runcostas3 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRun3Back.png"));
            runcostas4 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRun4Back.png"));
            runcostas5 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRun5Back.png"));
            runcostas6 = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/guerreiroRun6Back.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}    
