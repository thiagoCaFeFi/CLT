package MeuJogoJava.src;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Mapa extends JPanel {
    //config de tela
    final int tituloTamanhoOriginal = 16;
    final int escala = 3;
    final int tamanhoTitulo = tituloTamanhoOriginal*escala;
    final int tamanhoMaximoHorizontal = 16;
    final int tamanhoMaximoVertical = 12;
    final int tamanhoComprimento = tamanhoTitulo*tamanhoMaximoHorizontal;
    final int tamanhoAltura = tamanhoTitulo*tamanhoMaximoVertical;

    public void gamePanel(){
        this.setPreferredSize(new Dimension(tamanhoComprimento, tamanhoAltura));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
