package MeuJogoJava.src.main;

import MeuJogoJava.src.interfaceUsuario.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;

import MeuJogoJava.src.principais.Personagens;

public class PainelDeJogo extends JPanel implements Runnable  { //implements KeyListener, ActionListener, Runnable
    public final int tituloTamanhoOriginal = 16;
    public final int escala = 5;
    public final int tamanhoTitulo = tituloTamanhoOriginal * escala;
    public final int tamanhoMaximoHorizontal = 16;
    public final int tamanhoMaximoVertical = 12;
    public final int tamanhoComprimento = tamanhoTitulo * tamanhoMaximoHorizontal;
    public final int tamanhoAltura = tamanhoTitulo * tamanhoMaximoVertical;
    final int fps = 60;
    private UI ui;
    KeyHandler keyH = new KeyHandler(this);
    Thread threadDoJogo;

    

    public PainelDeJogo() {
        this.setPreferredSize(new Dimension(tamanhoComprimento, tamanhoAltura));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        personagens = new Personagens(this,keyH);
        this.ui = new UI(this, 80);
        this.prologo = new Prologo(this, keyH);
    }   
    public Personagens getPlayer() {
        return personagens;
    }

    public UI getUi() {
        return ui;
    }


     public void startGameThread() {
         threadDoJogo = new Thread(this);
         threadDoJogo.start();
     }
     public void run(){
        while(threadDoJogo != null){
            update();
            repaint();
            
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

     }


     public void paintComponent(Graphics g) {
         super.paintComponent(g);
         Graphics2D g2 = (Graphics2D)g;
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



        }


