package MeuJogoJava.src;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Combate teste = new Combate();
        Scanner leitor = new Scanner(System.in);
        int continua = 1;
        while( continua == 1) {
            teste.batalha();
            System.out.println("Fim de Jogo!");
            continua =2;
            leitor.close();
            
        }
        
    }
}