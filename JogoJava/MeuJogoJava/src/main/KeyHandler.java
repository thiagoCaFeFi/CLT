package MeuJogoJava.src.main;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class KeyHandler implements KeyListener {
    public boolean paraCima, paraBaixo, paraEsquerda, paraDireita;
    private PainelDeJogo gp;
    public boolean enter =false;
    public KeyHandler(PainelDeJogo gp){
        this.gp=gp;
    }
         public void keyTyped(KeyEvent e) {

         }
     @Override
     public void keyPressed(KeyEvent e) {
         int comando = e.getKeyCode();

        if (comando ==KeyEvent.VK_W && gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Ocioso || comando==KeyEvent.VK_UP && gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Ocioso) {
             paraCima = true;
         }
         if (comando==KeyEvent.VK_S && gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Ocioso || comando==KeyEvent.VK_DOWN && gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Ocioso) {
             paraBaixo = true;
         }
        if (comando==KeyEvent.VK_A && gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Ocioso || comando==KeyEvent.VK_LEFT && gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Ocioso) {
             paraEsquerda = true;
         }
         if (comando==KeyEvent.VK_D && gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Ocioso || comando==KeyEvent.VK_RIGHT && gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Ocioso) {
             paraDireita = true;
         }
         if (comando == KeyEvent.VK_I && gp.getEstadoDoJogo() == PainelDeJogo.EstadoDoJogo.Jogando) {
            // Verifica se o jogo tá no estado Jogando e o inventário não tá sendo usado no momento
            if (gp.getEstadoPersonagem() != PainelDeJogo.EstadoPersonagem.Inventario) {
                gp.setEstadoPersonagem(PainelDeJogo.EstadoPersonagem.Inventario);
            } else {

                gp.setEstadoDoJogo(PainelDeJogo.EstadoDoJogo.Jogando);
                gp.setEstadoPersonagem(PainelDeJogo.EstadoPersonagem.Ocioso);
            }
        }
        if(gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Inventario) {
            if(comando==KeyEvent.VK_W || comando==KeyEvent.VK_UP) {
                if (gp.getUi().slotRow != 0) {
                    gp.getUi().slotRow--;
                }
            }
            if(comando == KeyEvent.VK_S || comando==KeyEvent.VK_DOWN) {
                if(gp.getUi().slotRow != 3){
                    gp.getUi().slotRow++;
                }
            }
            if(comando == KeyEvent.VK_A || comando==KeyEvent.VK_LEFT) {
                if(gp.getUi().slotCol != 0 ) {
                    gp.getUi().slotCol--;
                }
            }
            if(comando==KeyEvent.VK_D || comando==KeyEvent.VK_RIGHT) {
                if(gp.getUi().slotCol != 4) {
                    gp.getUi().slotCol++;
                }
            }
        }
        if (comando == KeyEvent.VK_ENTER) {
            gp.getUi().usarItemSelecionado();
        }
     }

     @Override
     public void keyReleased(KeyEvent e) {
        int comando = e.getKeyCode();
        if (comando == KeyEvent.VK_W || comando==KeyEvent.VK_UP) {
            paraCima = false;
        }
        if (comando == KeyEvent.VK_S || comando==KeyEvent.VK_DOWN) {
            paraBaixo = false;
        }
       if (comando == KeyEvent.VK_A || comando==KeyEvent.VK_LEFT) {
            paraEsquerda = false;
        }
        if (comando == KeyEvent.VK_D || comando==KeyEvent.VK_RIGHT) {
            paraDireita = false;
        }
        
     }
}
