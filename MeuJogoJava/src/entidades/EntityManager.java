package MeuJogoJava.src.entidades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.awt.*;

import MeuJogoJava.src.main.PainelDeJogo;

public class EntityManager {
    private PainelDeJogo gp;
    private ArrayList<Entity> entities;
    private Personagens player;

    // Comparator para ordenar entidades pela coordenada Y
    private Comparator<Entity> ordemRender = new Comparator<Entity>() {
        @Override
        public int compare(Entity o1, Entity o2) {
            int y1 = o1.getY() + o1.getHeightBounds();
            int y2 = o2.getY() + o2.getHeightBounds();
            return Integer.compare(y1, y2);
        }
    };

    public EntityManager(PainelDeJogo gp, Personagens player) {
        this.gp = gp;
        this.player = player;
        entities = new ArrayList<>();
        addEntity(player);
    }

    public void update() {

        // Sincroniza a iteração sobre a lista de entidades
        synchronized (entities) {
            Iterator<Entity> iterator = entities.iterator();
            while (iterator.hasNext()) {
                Entity ser = iterator.next();
                ser.update();
                if (ser.shouldBeRemoved()) {
                    iterator.remove();  // Remove de maneira segura usando Iterator
                }
            }
        }
    }

    public void desenhar(Graphics2D g2) {


        // Sincroniza a ordenação e a iteração sobre a lista de entidades
        synchronized (entities) {
            entities.sort(ordemRender);
            for (Entity e : entities) {
                e.draw(g2);
            }
        }
    }

    public void setEntities(ArrayList<Entity> entities) {
        synchronized (this.entities) {
            this.entities = entities;
        }
    }

    public void addEntity(Entity e) {
        synchronized (entities) {
            entities.add(e);
            entities.sort(ordemRender);
        }
    }

    public ArrayList<Entity> getEntities() {
        synchronized (entities) {
            return new ArrayList<>(entities); // Retorna uma cópia da lista
        }
    }
}

