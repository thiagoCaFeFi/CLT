package MeuJogoJava.src;
/*import java.awt.Color;
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

    public PainelDeJogo(){
        this.setPreferredSize(new Dimension(tamanhoComprimento, tamanhoAltura));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
}
*/
import java.util.Scanner;

public class MapaNoConsole {
    private static final int largura = 10;
    private static final int altura = 10;
    private static int posicaoX = largura / 2;
    private static int posicaoY = altura / 2;
    public void desenharConsole(){
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[altura][largura];
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                board[i][j] = ' ';
            }
        }

        while (true) {
            
            System.out.print("\033[H\033[2J");
            System.out.flush();

            
            board[posicaoY][posicaoX] = '@';

            for (int i = 0; i < altura; i++) {
                for (int j = 0; j < largura; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }

            
            board[posicaoY][posicaoX] = ' ';

            
            System.out.println("Use W (cima), A (esquerda), S (baixo), D (direita) para mover. Q para sair.");
            char move = scanner.nextLine().toLowerCase().charAt(0);

            if (move == 'q') {
                break;
            }

            switch (move) {
                case 'w':
                    if (posicaoY > 0) posicaoY--;
                    break;
                case 'a':
                    if (posicaoX > 0) posicaoX--;
                    break;
                case 's':
                    if (posicaoY < altura - 1) posicaoY++;
                    break;
                case 'd':
                    if (posicaoX < largura - 1) posicaoX++;
                    break;
                default:
                    System.out.println("Movimento inválido. Use W, A, S, D ou Q.");
                    break;
            }
        }

        scanner.close();
    }
}
    