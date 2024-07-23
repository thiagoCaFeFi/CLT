package MeuJogoJava.src.atos;

import MeuJogoJava.src.entidades.EntityManager;
import MeuJogoJava.src.entidades.npc.Aldeao;
import MeuJogoJava.src.entidades.npc.Casa;
import MeuJogoJava.src.entidades.npc.Mercante;
import MeuJogoJava.src.entidades.tiposDeInimigos.GeneralDasSombras;
import MeuJogoJava.src.entidades.tiposDeInimigos.Goblin;
import MeuJogoJava.src.entidades.tiposDeInimigos.HobGoblin;
import MeuJogoJava.src.entidades.tiposDeInimigos.Imp;
import MeuJogoJava.src.interfaceUsuario.UI;
import MeuJogoJava.src.main.KeyHandler;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.mapas.Maps;

public class Galan {
    private PainelDeJogo gp;
    private Maps mapaGalan;
    private UI ui;
    private EntityManager entityManager;


    public Galan(PainelDeJogo gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.ui = gp.getUi();
        this.mapaGalan = new Maps(gp, "res/maps/mapaGalan.txt", PainelDeJogo.Capitulos.galan);
        entityManager = new EntityManager(gp ,gp.getPlayer());
        NPCs();
        inicializarInimigos();
        entityManager.addEntity(new Casa(gp,gp.tamanhoTitulo*9,gp.tamanhoTitulo*15));
        entityManager.addEntity(new Casa(gp,gp.tamanhoTitulo*18,gp.tamanhoTitulo*15));
        
    }



    private void NPCs(){
        entityManager.addEntity(new Mercante(gp,gp.tamanhoTitulo*5,gp.tamanhoTitulo*15));
        entityManager.addEntity(new Aldeao(gp, gp.tamanhoTitulo*22, gp.tamanhoTitulo*15));
    }


    private void inicializarInimigos(){
        entityManager.addEntity(new HobGoblin(gp, gp.tamanhoTitulo*16, gp.tamanhoTitulo*26));
        entityManager.addEntity(new Goblin(gp, gp.tamanhoTitulo*15, gp.tamanhoTitulo*20));
        entityManager.addEntity(new Goblin(gp, gp.tamanhoTitulo*17, gp.tamanhoTitulo*23));
        entityManager.addEntity(new Goblin(gp, gp.tamanhoTitulo*19, gp.tamanhoTitulo*21));
        entityManager.addEntity(new Goblin(gp, gp.tamanhoTitulo*20, gp.tamanhoTitulo*20));
        entityManager.addEntity(new GeneralDasSombras(gp, gp.tamanhoTitulo*30, gp.tamanhoTitulo*1));
        entityManager.addEntity(new Imp(gp, gp.tamanhoTitulo*33, gp.tamanhoTitulo*4));
        entityManager.addEntity(new Imp(gp, gp.tamanhoTitulo*36, gp.tamanhoTitulo*5));
        entityManager.addEntity(new Imp(gp, gp.tamanhoTitulo*34, gp.tamanhoTitulo*8));
        entityManager.addEntity(new Imp(gp, gp.tamanhoTitulo*36, gp.tamanhoTitulo*10));
    }

    
    public Maps getMap() {
        return mapaGalan;
    }

    public void up() {
        ui.update();
        mapaGalan.update();
        entityManager.update();
        gp.getEntityManager().setEntities(entityManager.getEntities());
    }
}
