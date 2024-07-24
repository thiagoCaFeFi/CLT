package MeuJogoJava.src.interfaceUsuario;

import MeuJogoJava.src.main.PainelDeJogo;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import MeuJogoJava.src.entidades.Personagens;
import MeuJogoJava.src.objetos.Objetos;

public class UI {
    Graphics2D g2;
    Font maruMonica;
    PainelDeJogo painelDeJogo;
    int fontSize;
    
    private int prologoOpacity, galanOpacity;
    private boolean fadingOutPrologo,fadingOutGalan;
     public ArrayList<String> message = new ArrayList<>();
    public ArrayList<Integer> messageCounter = new ArrayList<>();
    long startTime;
    long duration;
    private String currentDialogueText;
    private Personagens player;
    private Dialogos dialogos;
    private BufferedImage faceGuerreiro;
    BufferedImage image;
    public int slotRow = 0;
    public int slotCol = 0;
    public int selectedOption = 0;


    public UI(PainelDeJogo painelDeJogo, int fontSize) {
        this.painelDeJogo = painelDeJogo;
        player = painelDeJogo.getPlayer();
        this.fontSize = fontSize;
        this.prologoOpacity = 0;
        this.fadingOutPrologo = false;
        this.galanOpacity = 0;
        this.fadingOutGalan = false;
        this.startTime = System.currentTimeMillis();
        this.duration = 3000;
        this.dialogos = new Dialogos(painelDeJogo, fontSize);
        InputStream is = getClass().getResourceAsStream("/MeuJogoJava/res/font/x12y16pxMaruMonica.ttf");
        try {
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, fontSize);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadFaces(){
        try {
            faceGuerreiro = ImageIO.read(getClass().getResourceAsStream("/MeuJogoJava/res/personagens/guerreiro/19.png"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void drawProfile() {
        int screenWidth = painelDeJogo.getWidth();
        int screenHeight = painelDeJogo.getHeight();

        int profileWidth = 400; 
        int profileHeight = 270; 
        int profileX = (screenWidth - profileWidth) / 18;
        int profileY = (screenHeight - profileHeight) / 6;
        int spacing = 15;
        Color backgroundColor = new Color(0, 0, 0, 128);


        if(painelDeJogo.currentCapitulo.equals(PainelDeJogo.Capitulos.Prologo)){
            image = faceGuerreiro;
            backgroundColor = new Color(255, 0, 0, 80);
        } else if (painelDeJogo.currentCapitulo.equals(PainelDeJogo.Capitulos.galan)) {
            image = faceGuerreiro;
            backgroundColor = new Color(0, 0, 255, 128);
        }


        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
        g2.setColor(backgroundColor);
        g2.fillRect(profileX, profileY, profileWidth, profileHeight);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f)); 
        g2.setColor(new Color(0, 0, 0));
        g2.drawRect(profileX, profileY, profileWidth, profileHeight);

        g2.setFont(maruMonica.deriveFont(Font.BOLD, 20));
        g2.setColor(Color.white);

        String levelTexto = "Level " + painelDeJogo.getPlayer().getLevel();
        String vidaTexto = "Vida: " + painelDeJogo.getPlayer().getVida() + "/" + painelDeJogo.getPlayer().vidaMaxima;
        String manaTexto = "Mana: " + painelDeJogo.getPlayer().mana + "/" + painelDeJogo.getPlayer().manaMax;
        String xpTexto = "XP: " + painelDeJogo.getPlayer().xp + "/" + painelDeJogo.getPlayer().xpMax;
        String moedaTexto = "Moeda: " + painelDeJogo.getPlayer().moeda;
        String danoTexto = "Ataque: " + painelDeJogo.getPlayer().dano;


        int imageWidth = painelDeJogo.tamanhoTitulo * 2;
        int imageHeight = painelDeJogo.tamanhoTitulo * 2;
        int imageX = profileX + spacing;
        int imageY = profileY + spacing;
        g2.drawImage(image, imageX, imageY, imageWidth, imageHeight, null);

        // Calcula as posições dos textos
        int textX = imageX + imageWidth + spacing + 35;
        int levelTextoY = profileY + spacing + g2.getFontMetrics().getHeight();
        int vidaTextoY = levelTextoY + g2.getFontMetrics().getHeight() + spacing;
        int manaTextoY = vidaTextoY + g2.getFontMetrics().getHeight() + spacing;
        int xpTextoY = manaTextoY + g2.getFontMetrics().getHeight() + spacing;
        int moedaTextoY = xpTextoY + g2.getFontMetrics().getHeight() + spacing;
        int danoTextoY = moedaTextoY + g2.getFontMetrics().getHeight() + spacing;

        // Desenha os textos das informações
        g2.drawString(levelTexto, textX , levelTextoY);
        g2.drawString(vidaTexto, textX , vidaTextoY);
        g2.drawString(manaTexto, textX, manaTextoY);
        g2.drawString(xpTexto, textX, xpTextoY);
        g2.drawString(moedaTexto, textX, moedaTextoY);
        g2.drawString(danoTexto, textX, danoTextoY);
    }

        
    private void resetTimer() {
        startTime = System.currentTimeMillis();
    }
    public void iniciarCapitulo() {
        switch (painelDeJogo.currentCapitulo) {
            case Prologo:
                prologoOpacity = 0;
                fadingOutPrologo = false;
                break;
            case galan:
                galanOpacity = 0;
                fadingOutGalan = false;
                break;
        
        }
        resetTimer();
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
            drawPrologo();
        }
        else if (painelDeJogo.currentCapitulo.equals(PainelDeJogo.Capitulos.galan)) {
            g2.setColor(new Color(255, 255, 255, galanOpacity));
            drawGalan();
        }
        if(painelDeJogo.getEstadoDoJogo() != PainelDeJogo.EstadoDoJogo.Menu){
            desenharMissao();
        }
    }
    private void drawPrologo() {
        g2.setColor(new Color(255, 255, 255, prologoOpacity));
        printarTexto("O PROLOGO");
    }

    private void updatePrologo(long elapsedTime) {
        if (elapsedTime >= duration && !fadingOutPrologo) {
            iniciarDesaparecimentoPrologo();
        }
        if (fadingOutPrologo) {
            prologoOpacity -= 5;
            if (prologoOpacity <= 0) {
                prologoOpacity = 0;
                System.out.println("prologo desaparece");
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
    private void iniciarDesaparecimentoPrologo() {
        fadingOutPrologo = true;
    }

    public boolean isPrologoDesaparecido() {
        return prologoOpacity == 0;
    }
    private void drawGalan() {
        g2.setColor(new Color(255, 100, 100, galanOpacity));
        printarTexto("Galan");
    }

    private void updateGalan(long elapsedTime) {

        if (elapsedTime >= duration && !fadingOutGalan) {
            iniciarDesaparecimentoGalan();

        }
        if (fadingOutGalan) {
            galanOpacity -= 5;
            if (galanOpacity <= 0) {
                galanOpacity = 0;
                System.out.println("desapareceu Galan");
                painelDeJogo.setEstadoDoJogo(PainelDeJogo.EstadoDoJogo.Jogando);
            }
        } else {
            if (galanOpacity < 255) {
                galanOpacity += 5;
                if (galanOpacity >= 255) {
                    galanOpacity = 255;
                }
            }
        }
    }

    private void iniciarDesaparecimentoGalan() {
        System.out.println("desaparecendo Galan");
        fadingOutGalan = true;
    }

    public boolean isGalanDesaparecido() {
        return galanOpacity == 0;
    }

    private void printarTexto(String text) {
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
    public void drawHealthAndManaBars(Graphics2D g2) {
        // Dimensões e posição das barras
        int barX = 550;
        int barY = 20;
        int barWidth = 200; // Largura total das barras
        int barHeight = 20; // Altura das barras
        int spacing = 10;


        int currentHealthBarWidth = (int) ((double) painelDeJogo.getPlayer().getVida() / painelDeJogo.getPlayer().vidaMaxima * barWidth);


        int currentManaBarWidth = (int) ((double) painelDeJogo.getPlayer().mana / painelDeJogo.getPlayer().manaMax * barWidth);


        g2.setColor(Color.darkGray); // Cor do fundo da barra
        g2.fillRect(barX, barY, barWidth, barHeight);


        g2.setColor(Color.green); // Cor da vida
        g2.fillRect(barX, barY, currentHealthBarWidth, barHeight);

        // Desenha o contorno da barra de vida
        g2.setColor(Color.black);
        g2.drawRect(barX, barY, barWidth, barHeight);


        g2.setColor(Color.white);
        g2.setFont(maruMonica.deriveFont(Font.BOLD, 14)); // Fonte do texto
        String vidaTexto = painelDeJogo.getPlayer().getVida() + "/" + painelDeJogo.getPlayer().vidaMaxima;
        int vidaTextoX = barX + (barWidth - g2.getFontMetrics().stringWidth(vidaTexto)) / 2;
        int vidaTextoY = barY + barHeight - 5;
        g2.drawString(vidaTexto, vidaTextoX, vidaTextoY);


        int manaBarY = barY + barHeight + spacing;


        g2.setColor(Color.gray); // Cor do fundo da barra
        g2.fillRect(barX, manaBarY, barWidth, barHeight);


        g2.setColor(Color.blue); // Cor da mana
        g2.fillRect(barX, manaBarY, currentManaBarWidth, barHeight);

        // Desenha o contorno da barra de mana
        g2.setColor(Color.black);
        g2.drawRect(barX, manaBarY, barWidth, barHeight);

        // Texto da mana
        g2.setColor(Color.white);
        g2.setFont(maruMonica.deriveFont(Font.BOLD, 14)); // Fonte do texto
        String manaTexto = painelDeJogo.getPlayer().mana + "/" + painelDeJogo.getPlayer().manaMax;
        int manaTextoX = barX + (barWidth - g2.getFontMetrics().stringWidth(manaTexto)) / 2;
        int manaTextoY = manaBarY + barHeight - 5;
        g2.drawString(manaTexto, manaTextoX, manaTextoY);
    }


    public void usarItemSelecionado() {
        int selectedIndex = slotRow * 5 + slotCol; // Índice do item selecionado
        if (selectedIndex >= 0 && selectedIndex < painelDeJogo.getPlayer().inventario.size()) {
            Objetos selectedItem = painelDeJogo.getPlayer().inventario.get(selectedIndex);
            selectedItem.usouItem(painelDeJogo.getPlayer());
            System.out.println("Dano:"+painelDeJogo.getPlayer().getDano());
            painelDeJogo.getPlayer().inventario.remove(selectedIndex);
            painelDeJogo.repaint();
        }
    }
    public void usarAtaqueSelecionado() {
        if (selectedOption == 0){  // 0 = golpe simples
            painelDeJogo.setAcao(0);
            System.out.println("golpe fraco");
        }
        else if (selectedOption == 1){
            System.out.println("golpe forte"); // 1 == golpe forte
            painelDeJogo.setAcao(1);
        } else if (selectedOption == 2) {
            painelDeJogo.setAcao(2);
            System.out.println("defendeu");
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
        final int slotXstart = frameX + 5;
        final int slotYstart = frameY + 38;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                int slotX = slotXstart + (col * (slotSize + 10));
                int slotY = slotYstart + (row * (slotSize + 10));
                g2.drawRect(slotX, slotY, slotSize, slotSize);

                
                int index = row * 5 + col;
                if (index < painelDeJogo.getPlayer().inventario.size()) {
                    
                    Objetos item = painelDeJogo.getPlayer().inventario.get(index);

                    if (item.foto != null) {
                        // Converte BufferedImage para Image
                        Image img = (Image) item.foto;

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
    public void desenharMensagem(){
        int messageX = painelDeJogo.tamanhoTitulo;
        int messageY = painelDeJogo.tamanhoTitulo*5;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25));

        for(int i = 0;i<message.size();i++){

            if(message.get(i)!= null){
                g2.setColor(Color.white);
                g2.drawString(message.get(i),messageX,messageY);
                int counter = messageCounter.get(i) + 1;
                messageCounter.set(i,counter);
                messageY+= 50;


                if(messageCounter.get(i)>180){
                    message.remove(i);
                    messageCounter.remove(i);
                }
            }
        }
    }
    public void drawCombate() {
        int screenWidth = painelDeJogo.getWidth();
        int screenHeight = painelDeJogo.getHeight();

        int frameWidth = painelDeJogo.tamanhoTitulo * 5;
        int frameHeight = painelDeJogo.tamanhoTitulo * 3;

        int frameX = (screenWidth - frameWidth) / 2;
        int frameY = screenHeight - frameHeight - 50;


        g2.setColor(new Color(50, 50, 50, 200));
        g2.fillRoundRect(frameX, frameY, frameWidth, frameHeight, 10, 10);

        g2.setColor(Color.white);
        g2.drawRoundRect(frameX, frameY, frameWidth, frameHeight, 10, 10);


        g2.setColor(Color.white);
        g2.setFont(maruMonica.deriveFont(Font.BOLD, 25));
        String titulo = "Combate";
        int tituloWidth = g2.getFontMetrics().stringWidth(titulo);
        int tituloX = frameX + (frameWidth - tituloWidth) / 2;
        int tituloY = frameY + 30;
        g2.drawString(titulo, tituloX, tituloY);

        // Opções de combate
        g2.setFont(maruMonica.deriveFont(Font.PLAIN, 20)); // Fonte para as opções
        String[] opcoes = {"Golpe Fraco | Custo : 3 de mana", "Golpe Especial | Custo : 7 de mana", "Defender | + 5 de mana"};
        int opcaoYstart = frameY + 80; // Ponto de início vertical para as opções

        for (int i = 0; i < opcoes.length; i++) {
            String opcao = opcoes[i];
            int opcaoWidth = g2.getFontMetrics().stringWidth(opcao);
            int opcaoX = frameX + (frameWidth - opcaoWidth) / 2;
            int opcaoY = opcaoYstart + (i * 55); // Ajuste vertical entre opções
            g2.drawString(opcao, opcaoX, opcaoY);

            // Desenha a borda ao redor da opção selecionada
            if (i == selectedOption) { // 'selectedOption' deve ser uma variável que guarda a opção selecionada
                g2.setColor(Color.green);
                g2.drawRoundRect(opcaoX - 10, opcaoY - 20, opcaoWidth + 20, 30, 10, 10);
                g2.setColor(Color.white); // Restaura a cor branca para o texto
            }

        }
    }


    public void update() {
        long elapsedTime = System.currentTimeMillis() - startTime;

        if (painelDeJogo.getEstadoDoJogo() == PainelDeJogo.EstadoDoJogo.Menu) {
            switch (painelDeJogo.currentCapitulo) {
                case Prologo:
                    updatePrologo(elapsedTime);
                    break;
                case galan:
                    System.out.println("Atualizando Galan");
                    updateGalan(elapsedTime);
                    break;
                
            }
        }
    }
    public void addMensagem(String mensagem){
        message.add(mensagem);
        messageCounter.add(0);
    }
    public void desenharMissao() {
        String missao = "";
        if (painelDeJogo.currentCapitulo == PainelDeJogo.Capitulos.Prologo) {
            missao = "Missão: Interaja com o Narrador.";
        } else if (painelDeJogo.currentCapitulo == PainelDeJogo.Capitulos.galan) {
            missao = "Missão: Elimine os seres da Umbra e ajude os moradores locais.";
        
        }

        g2.setFont(maruMonica.deriveFont(Font.PLAIN, 19));
        g2.setColor(Color.WHITE);
        int x = 50; // Posição x do texto
        int y = painelDeJogo.tamanhoAltura - 60;
        g2.drawString(missao, x, y);
    }
    
        


}