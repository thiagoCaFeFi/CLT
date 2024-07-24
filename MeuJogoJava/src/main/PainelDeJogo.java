package MeuJogoJava.src.main;

import MeuJogoJava.src.auxiliar.Camera;
import MeuJogoJava.src.entidades.EntityManager;
import MeuJogoJava.src.entidades.Personagens;
import MeuJogoJava.src.interfaceUsuario.UI;
import MeuJogoJava.src.interfaceUsuario.Dialogos;
import MeuJogoJava.src.mapas.Maps;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import MeuJogoJava.src.atos.Galan;
import MeuJogoJava.src.atos.Prologo;
import javax.swing.JPanel;

import MeuJogoJava.src.principais.Combate;
import MeuJogoJava.src.tiposDeClasse.Guerreiro;

public class PainelDeJogo extends JPanel implements Runnable  {
    public final int tituloTamanhoOriginal = 16;
    public final int escala = 3;
    public final int tamanhoTitulo = tituloTamanhoOriginal * escala;
    public final int tamanhoMaximoHorizontal = 16;
    public final int tamanhoMaximoVertical = 12;
    public final int tamanhoComprimento = tamanhoTitulo * tamanhoMaximoHorizontal;
    public final int tamanhoAltura = tamanhoTitulo * tamanhoMaximoVertical;
    final int fps = 60;
    private Maps currentMap;
    private Prologo prologo;
    private Galan galan;
    private Guerreiro guerreiro;
    private UI ui;
    KeyHandler keyH = new KeyHandler(this);
    Thread threadDoJogo;
    Camera camera = new Camera(this, 0, 0);
    private Combate combate;
    public Dialogos dialogos;
    Personagens player = new Personagens(this,keyH);
    EntityManager entityManager = new EntityManager(this, player);
    public boolean lutando;
    public boolean defendendo;

    public PainelDeJogo() {
        this.setPreferredSize(new Dimension(tamanhoComprimento, tamanhoAltura));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

        this.ui = new UI(this, 90);
        this.prologo = new Prologo(this, keyH);
        setChapter(Capitulos.Prologo);
        this.combate = new Combate(this, player.atualEntity);
    }   
    public Personagens getPlayer() {

        return player;
    }

    public void setPlayer(Personagens player){

        this.player = player;

    }

    public Camera getCamera() {

        return camera;
    }
    public Combate getCombate() {

        return combate;
    }

    public EntityManager getEntityManager() {
        return entityManager;

    }

    public UI getUi() {
        return ui;
    }
    public void setAcao(int acao) {
        if (acao == 0) {
            getCombate().golpeSimples = true;
        } else if (acao == 1) {
            getCombate().golpeEspecial = true;
        } else if (acao == 2) {
            defendendo = true;
        }
    }
    public enum Capitulos {
        Prologo,
         galan
    }
    public Capitulos currentCapitulo = Capitulos.Prologo;
    


     public void startGameThread() {
         threadDoJogo = new Thread(this);
         threadDoJogo.start();
     }
     public void run(){
        
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (threadDoJogo != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
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
            Ocioso,
            Profile
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
            ui.drawHealthAndManaBars(g2);
            ui.desenharMissao();
            if (estadoPersonagem == EstadoPersonagem.Inventario) {
                ui.draw(g2);
            } else if (estadoPersonagem == EstadoPersonagem.Dialogo) {
                ui.draw(g2);
            } else if (estadoPersonagem == EstadoPersonagem.Profile){
                ui.draw(g2);
            }
        }
        g2.dispose();
    }
    public Maps getCurrentMap() {
        return currentMap;
    }
    public Dialogos getDialogues() {
        return dialogos;
    }
    public void setChapter(Capitulos chapter) {
        this.currentCapitulo = chapter;
        ui.iniciarCapitulo();
        switch (chapter) {
            case Prologo:
                if (prologo == null) {
                   prologo = new Prologo(this, keyH);
                    setPlayer(guerreiro);
                }
                this.currentMap = prologo.getMap();
                break;
            case galan:
                if (galan == null) {
                    if (guerreiro == null){
                        guerreiro = new Guerreiro(this,keyH);
                    }
                    setPlayer(guerreiro);
                        guerreiro.posicaoX = tamanhoTitulo*2;
                        guerreiro.posicaoY = tamanhoTitulo*18;
                        galan = new Galan(this, keyH);
                    } else{
                        setPlayer(guerreiro);
                    }
                    this.currentMap = galan.getMap();
                    break;
                }
                
            }

}
