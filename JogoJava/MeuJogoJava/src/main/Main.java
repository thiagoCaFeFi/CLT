package MeuJogoJava.src.main;


import javax.swing.JFrame;



public class Main {

    public static void main(String[] args) {
      
            
    
        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setTitle("Crônicas de Luz e Trevas");
        PainelDeJogo painelDeJogo = new PainelDeJogo();
    
        janela.add(painelDeJogo);
        janela.pack();

        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        painelDeJogo.startGameThread();

       // painelDeJogo.launchGame();

        
    }
}