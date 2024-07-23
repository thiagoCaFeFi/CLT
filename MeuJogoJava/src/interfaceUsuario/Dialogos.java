package MeuJogoJava.src.interfaceUsuario;
import MeuJogoJava.src.main.PainelDeJogo;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

public class Dialogos {
    private PainelDeJogo painelDeJogo;
    private int fontSize;
    private Graphics2D g2;
    private String currentDialogueText = "";

    public Dialogos(PainelDeJogo painelDeJogo, int fontSize) {
        this.painelDeJogo = painelDeJogo;
        this.fontSize = fontSize;
    }
    

    public void drawDialogoscreen(Graphics2D g2) {
        this.g2 = g2;
        int x = painelDeJogo.tamanhoTitulo * 2;
        int y = painelDeJogo.tamanhoTitulo / 2;
        int comprimento = painelDeJogo.tamanhoComprimento - painelDeJogo.tamanhoTitulo * 4;
        int altura = painelDeJogo.tamanhoTitulo * 4;

        drawSubWindow(x, y, comprimento, altura);
        System.out.println("no dialogues: " + currentDialogueText);
        if (currentDialogueText != null && !currentDialogueText.isEmpty()) {
            drawTextoDialogo(currentDialogueText, x + 20, y + 40, comprimento - 40);
        }

    }
    public void setDialogueText(String text) {
        this.currentDialogueText = text;
    }

    public String getDialogueText() {
        return currentDialogueText;
    }

    public void drawSubWindow(int x, int y, int comprimento, int altura) {
        Color color = new Color(0, 0, 0, 200);
        g2.setColor(color);
        g2.fillRoundRect(x, y, comprimento, altura, 35, 35);
        color = new Color(255, 255, 255); // Cor da borda
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, comprimento - 10, altura - 10, 25, 25);
    }

    private void drawTextoDialogo(String texto, int x, int y, int maxComprimento) {
        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20));

        FontMetrics metrics = g2.getFontMetrics();

        String[] linhas = texto.split("\n");

        for (String linha : linhas) {
            List<String> linhasQuebradas = new ArrayList<>();
            String[] palavras = linha.split(" ");
            StringBuilder linhaAtual = new StringBuilder();

            for (String palavra : palavras) {
                if (metrics.stringWidth(linhaAtual + palavra) < maxComprimento) {
                    linhaAtual.append(palavra).append(" ");
                } else {
                    linhasQuebradas.add(linhaAtual.toString());
                    linhaAtual = new StringBuilder(palavra).append(" ");
                }
            }
            linhasQuebradas.add(linhaAtual.toString());

            for (String linhaQuebrada : linhasQuebradas) {
                g2.drawString(linhaQuebrada, x, y);
                y += metrics.getHeight();
            }
        }
    }
    
}
