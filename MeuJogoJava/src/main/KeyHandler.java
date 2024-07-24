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
        if(comando == KeyEvent.VK_ENTER && gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Dialogo) {
            gp.setEstadoDoJogo(PainelDeJogo.EstadoDoJogo.Menu);
            gp.setEstadoPersonagem(PainelDeJogo.EstadoPersonagem.Ocioso);
            gp.getPlayer().posicaoX = gp.getPlayer().posicaoX - gp.tamanhoTitulo;
            if (gp.getDialogues().getDialogueText().contains("Ouça bem, jovem aventureiro, pois o que estou prestes a revelar é de extrema importância. Uma força maligna, antiga como o próprio tempo, está despertando de seu sono profundo. Chama-se Umbra, um poder sombrio e insidioso que há muito foi selado pelos grandes magos do passado. Porém, os selos estão se enfraquecendo, e agora Umbra começa a se espalhar pela região de Galan. A terra, outrora fértil e cheia de vida, está se tornando desolada e perigosa. Se nada for feito, toda a nossa existência pode ser consumida pelas trevas. Você, com sua coragem e determinação, pode ser a chave para impedir que essa escuridão devore o nosso mundo.")){
                gp.setChapter(PainelDeJogo.Capitulos.galan);
            }

        }
        if(gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Dialogo && gp.getDialogues().getDialogueText().contains("Deseja comprar algo? \n" +
        "1 - Poção de Força  (G 40)\n" +
        "2 - Poção de Vitalidade (G 60)\n")){
    if(comando == KeyEvent.VK_1){
        gp.getPlayer().comprarPocaoForca();
    } else if (comando == KeyEvent.VK_2) {
        gp.getPlayer().comprarCura();
    }
}

        if (comando == KeyEvent.VK_Q && gp.getEstadoDoJogo() == PainelDeJogo.EstadoDoJogo.Jogando && gp.getEstadoPersonagem() != PainelDeJogo.EstadoPersonagem.Combate) {

            if (gp.getEstadoPersonagem() != PainelDeJogo.EstadoPersonagem.Profile) {
                gp.setEstadoPersonagem(PainelDeJogo.EstadoPersonagem.Profile);
            } else {
                gp.setEstadoDoJogo(PainelDeJogo.EstadoDoJogo.Jogando);
                gp.setEstadoPersonagem(PainelDeJogo.EstadoPersonagem.Ocioso);
            }
        }

        // INVENTARIO
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
        // USAR ITEM
        if (comando == KeyEvent.VK_ENTER && gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Inventario) {
            gp.getUi().usarItemSelecionado();
        }
        if (comando == KeyEvent.VK_ENTER && gp.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Combate) {
            gp.getUi().usarAtaqueSelecionado();
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
