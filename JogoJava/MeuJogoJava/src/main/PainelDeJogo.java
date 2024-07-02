package MeuJogoJava.src.main;

import MeuJogoJava.src.auxiliar.Camera;
import MeuJogoJava.src.interfaceUsuario.UI;
import MeuJogoJava.src.mapas.Maps;
import MeuJogoJava.src.objetos.Objetos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import MeuJogoJava.src.atos.Prologo;


import javax.swing.JPanel;


import MeuJogoJava.src.principais.Personagens;

public class PainelDeJogo extends JPanel implements Runnable  {
    public final int tituloTamanhoOriginal = 16;
    public final int escala = 5;
    public final int tamanhoTitulo = tituloTamanhoOriginal * escala;
    public final int tamanhoMaximoHorizontal = 16;
    public final int tamanhoMaximoVertical = 12;
    public final int tamanhoComprimento = tamanhoTitulo * tamanhoMaximoHorizontal;
    public final int tamanhoAltura = tamanhoTitulo * tamanhoMaximoVertical;
    final int fps = 60;
    private Maps currentMap;
    private Prologo prologo;
    private UI ui;
    KeyHandler keyH = new KeyHandler(this);
    Thread threadDoJogo;
    Camera camera = new Camera(this, 0, 0);
    private static Personagens personagens;
    private Objetos objetos;


    public Camera getCamera() {
        return camera;
    }

    

    public PainelDeJogo() {
        this.setPreferredSize(new Dimension(tamanhoComprimento, tamanhoAltura));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        Personagens personagens = new Personagens(this,keyH);
        this.ui = new UI(this, 80);
        this.prologo = new Prologo(this, keyH);
        setChapter(Capitulos.Prologo);
    }   
    public Personagens getPlayer() {
        return personagens;
    }

    public UI getUi() {
        return ui;
    }
    public enum Capitulos {
        Prologo,
         //Galan,
    }
    public Capitulos currentCapitulo = Capitulos.Prologo;
    public void setChapter(Capitulos chapter) {
        this.currentCapitulo = chapter;
        switch (chapter) {
            case Prologo:
                this.currentMap = prologo.getMap();
                break;
            //case Galan:
                //this.currentMap = Galan.getMap();
                //break;
        }
    }


     public void startGameThread() {
         threadDoJogo = new Thread(this);
         threadDoJogo.start();
     }
     public void run(){
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while(threadDoJogo != null){
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/drawInterval;
            timer += currentTime-lastTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000){
                System.out.println("FPS: "+drawCount);
                drawCount = 0;
                timer = 0;
            }
            
        }
    }
        public enum EstadoDoJogo {
            Menu,
            Pausado,
            Jogando
        }
        public enum EstadoPersonagem {
            Dialogo,
            Inventario,
            Combate,
            Ocioso
        }
        
        private EstadoPersonagem estadoPersonagem = EstadoPersonagem.Ocioso;

        public void setEstadoPersonagem(EstadoPersonagem novoEstado) {
            this.estadoPersonagem = novoEstado;
            repaint();
        }
        public EstadoPersonagem getEstadoPersonagem() {
            return estadoPersonagem;
        }
        public EstadoDoJogo estadoDoJogo = EstadoDoJogo.Menu;

    public void setEstadoDoJogo(EstadoDoJogo novoEstado) {
        this.estadoDoJogo = novoEstado;
        repaint();
    }

    public EstadoDoJogo getEstadoDoJogo() {
        return estadoDoJogo;
    }

     public void update(){
         if (currentCapitulo == Capitulos.Prologo) {
            prologo.up();

        }
     }


     public void paintComponent(Graphics g) {
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D)g;
         if (currentCapitulo == Capitulos.Prologo) {
            prologo.draw(g2);
        }

        

        if (estadoDoJogo == EstadoDoJogo.Jogando) {
            ui.drawHealthBar(g2);
            if (estadoPersonagem == EstadoPersonagem.Inventario) {
                ui.draw(g2);
            } else if (estadoPersonagem == EstadoPersonagem.Dialogo) {
                ui.draw(g2);
            }
        }
        g2.dispose();
    }
    public Maps getCurrentMap() {
        return currentMap;
    }



        }


