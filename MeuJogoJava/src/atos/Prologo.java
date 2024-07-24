package MeuJogoJava.src.atos;

import MeuJogoJava.src.entidades.EntityManager;
import MeuJogoJava.src.entidades.npc.Narrador;
import MeuJogoJava.src.interfaceUsuario.UI;
import MeuJogoJava.src.mapas.Maps;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.main.KeyHandler;
import MeuJogoJava.src.tiposDeClasse.Guerreiro;


import java.awt.*;

public class Prologo {
    private PainelDeJogo painelDeJogo;
    private Guerreiro guerreiro;
    private Narrador narrador;
    private UI ui;
    private Maps mapaPrologo; // Move a declaração aqui
    private EntityManager entityManager;
    

    public Prologo(PainelDeJogo painelDeJogo, KeyHandler keyHandler) {
        this.painelDeJogo = painelDeJogo;
        entityManager = new EntityManager(painelDeJogo, painelDeJogo.getPlayer());
        entityManager.addEntity(new Narrador(painelDeJogo,painelDeJogo.tamanhoTitulo * 14,painelDeJogo.tamanhoTitulo * 8));
        this.ui = painelDeJogo.getUi();
        this.mapaPrologo = new Maps(painelDeJogo, "res/maps/mapaPrologo.txt", PainelDeJogo.Capitulos.Prologo);
    }

    public Maps getMap() {

        return mapaPrologo;
    }

    public void up() {
        ui.update();
        mapaPrologo.update();
        entityManager.update();
        painelDeJogo.getEntityManager().setEntities(entityManager.getEntities());
    }

    public void draw(Graphics2D g2){
        ui.draw(g2);
        if (ui.isPrologoDesaparecido()) {
            mapaPrologo.draw(g2);
            entityManager.desenhar(g2);
        }
    }
}
