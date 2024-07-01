package MeuJogoJava.src.interfaceUsuario;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.main.KeyHandler;
import MeuJogoJava.src.principais.Personagens;
import java.io.IOException;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import java.awt.*;
import MeuJogoJava.src.objetos.Objetos;

public class UI {
    Graphics2D g2;
    Font maruMonica;
    PainelDeJogo painelDeJogo;
    int fontSize;
    private int prologoOpacity;
    private boolean fadingOut;
    long startTime;
    long duration;
    private Dialogos dialogos;
    public int slotRow = 0;
    public int slotCol = 0;


    public UI(PainelDeJogo painelDeJogo, int fontSize) {
        this.painelDeJogo = painelDeJogo;
        this.fontSize = fontSize;
        this.prologoOpacity = 0;
        this.fadingOut = false;
        this.startTime = System.currentTimeMillis();
        this.duration = 3000;
        this.dialogos = new Dialogos(painelDeJogo, fontSize);


        InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
        try {
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, fontSize);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(maruMonica);


        if (painelDeJogo.getEstadoPersonagem()==PainelDeJogo.EstadoPersonagem.Dialogo) {
            dialogos.drawDialogoscreen(g2);

        } else if (painelDeJogo.getEstadoPersonagem() == PainelDeJogo.EstadoPersonagem.Inventario) {
            drawInventory();

        }


        if (painelDeJogo.currentCapitulo.equals(PainelDeJogo.Capitulos.Prologo)) {
            g2.setColor(new Color(255, 255, 255, prologoOpacity));
            printarPrologo();
        }
    }

    public void update() {
        long elapsedTime = System.currentTimeMillis() - startTime;




        if (elapsedTime >= duration && !fadingOut) {
            iniciarDesaparecimento();
        }

        if (fadingOut) {
            prologoOpacity -= 5;
            if (prologoOpacity <= 0) {
                prologoOpacity = 0;
                painelDeJogo.setEstadoDoJogo(PainelDeJogo.EstadoDoJogo.Jogando); 

            }
        } else {
            if (prologoOpacity < 255) {
                prologoOpacity += 5;
                if (prologoOpacity >= 255) {
                    prologoOpacity = 255;
                }
            }
        }
    }

    public void printarPrologo() {
        String text = "O PROLOGO";
        int x = textoCentralizadoX(text);
        int y = painelDeJogo.tamanhoAltura / 2;
        g2.drawString(text, x, y);
    }

    public int textoCentralizadoX(String text) {
        int x;
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = painelDeJogo.tamanhoComprimento / 2 - length / 2;
        return x;
    }

    public void iniciarDesaparecimento() {
        fadingOut = true;
    }

    public boolean isPrologoDesaparecido() {
        return prologoOpacity == 0;
    }

    public void drawHealthBar(Graphics2D g2) {
        
        int barX = 50;
        int barY = 50;
        int barWidth = 200; 
        int barHeight = 20; 

        
        int currentBarWidth = (int) ((double) painelDeJogo.getPlayer().getVida() / painelDeJogo.getPlayer().vidaMaxima * barWidth);

       
        g2.setColor(Color.gray); 
        g2.fillRect(barX, barY, barWidth, barHeight);

        
        g2.setColor(Color.red); 
        g2.fillRect(barX, barY, currentBarWidth, barHeight);

        
        g2.setColor(Color.black);
        g2.drawRect(barX, barY, barWidth, barHeight);

        
        g2.setColor(Color.white);
        g2.setFont(maruMonica.deriveFont(Font.BOLD, 14)); 
        String vidaTexto = painelDeJogo.getPlayer().getVida() + "/" + painelDeJogo.getPlayer().vida;
        int vidaTextoX = barX + (barWidth - g2.getFontMetrics().stringWidth(vidaTexto)) / 2;
        int vidaTextoY = barY + barHeight - 5;
        g2.drawString(vidaTexto, vidaTextoX, vidaTextoY);
    }

    public void usarItemSelecionado() {
        int selectedIndex = slotRow * 5 + slotCol; 
        if (selectedIndex >= 0 && selectedIndex < painelDeJogo.getPlayer().inventario.size()) {
            SuperObject selectedItem = painelDeJogo.getPlayer().inventario.get(selectedIndex);
            selectedItem.usouItem(painelDeJogo.getPlayer());
            System.out.println("Dano:"+painelDeJogo.getPlayer().getDano());
            painelDeJogo.getPlayer().inventario.remove(selectedIndex);
            painelDeJogo.repaint();
        }
    }

    public void drawInventory() {
        int frameX = painelDeJogo.tamanhoTitulo * 9;
        int frameY = painelDeJogo.tamanhoTitulo;
        int frameWidth = painelDeJogo.tamanhoTitulo * 6;
        int frameHeight = painelDeJogo.tamanhoTitulo * 11 / 2;

        
        g2.setColor(new Color(50, 50, 50, 200)); 
        g2.fillRoundRect(frameX, frameY, frameWidth, frameHeight, 10, 10);

        g2.setColor(Color.white);
        g2.drawRoundRect(frameX, frameY, frameWidth, frameHeight, 10, 10); 

        
        g2.setColor(Color.white);
        g2.setFont(maruMonica.deriveFont(Font.BOLD, 25)); 
        String titulo = "Inventário";
        int tituloWidth = g2.getFontMetrics().stringWidth(titulo);
        int tituloX = frameX + (frameWidth - tituloWidth) / 2;
        int tituloY = frameY + 30; 
        g2.drawString(titulo, tituloX, tituloY);

       
        g2.setFont(maruMonica.deriveFont(Font.PLAIN, 14)); 
        int selectedIndex = slotRow * 5 + slotCol; 
        if (selectedIndex >= 0 && selectedIndex < painelDeJogo.getPlayer().inventario.size()) {
            Objetos selectedItem = painelDeJogo.getPlayer().inventario.get(selectedIndex);
            String descricao = selectedItem.nome;
            int descricaoWidth = g2.getFontMetrics().stringWidth(descricao);
            int descricaoX = frameX + (frameWidth - descricaoWidth) / 2;
            int descricaoY = frameY + 50;
            g2.drawString(descricao, descricaoX, descricaoY);
        }

        
        final int slotSize = painelDeJogo.tamanhoTitulo;
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 80;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                int slotX = slotXstart + (col * (slotSize + 10));
                int slotY = slotYstart + (row * (slotSize + 10));
                g2.drawRect(slotX, slotY, slotSize, slotSize);

                
                int index = row * 5 + col;
                if (index < painelDeJogo.getPlayer().inventario.size()) {
                    
                    Objeto item = painelDeJogo.getPlayer().inventario.get(index);

                    if (item.image != null) {
                        // Converte BufferedImage para Image
                        Image img = (Image) item.image;

                        // Desenha a imagem do inventário na posição atual
                        g2.drawImage(img, slotX, slotY, null);
                    }
                }
            }
        }

        // Cursor
        int cursorX = slotXstart + (slotSize + 10) * slotCol;
        int cursorY = slotYstart + (slotSize + 10) * slotRow;
        g2.setColor(Color.yellow);
        g2.drawRoundRect(cursorX, cursorY, slotSize, slotSize, 10, 10);
    }

}