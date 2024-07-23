package MeuJogoJava.src.atos;

import MeuJogoJava.src.entidades.EntityManager;
import MeuJogoJava.src.interfaceUsuario.UI;
import MeuJogoJava.src.mapas.Maps;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.main.KeyHandler;


import java.awt.*;

public class Prologo {
    private PainelDeJogo painelDeJogo;
    private UI ui;
    private Maps mapaPrologo; // Move a declaração aqui
    private EntityManager entityManager;
    

    public Prologo(PainelDeJogo painelDeJogo, KeyHandler keyHandler) {
        entityManager = new EntityManager(painelDeJogo, painelDeJogo.getPlayer());
        this.painelDeJogo = painelDeJogo;
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
