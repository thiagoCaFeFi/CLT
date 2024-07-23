package MeuJogoJava.src.principais;

import java.util.Random;
import MeuJogoJava.src.entidades.Entity;
import MeuJogoJava.src.entidades.Personagens;
import MeuJogoJava.src.main.PainelDeJogo;

public class Combate{
    private PainelDeJogo gp;
    private Entity inimigo;
    public boolean turnoDoJogador;
    private Random rand = new Random();
    private Personagens player;
    private int danoInimigo;
    public boolean golpeSimples;
    public boolean golpeEspecial;
    public boolean defendendo;
    public boolean bossMorto;

    public Combate(PainelDeJogo gp, Entity inimigo) {
        this.gp = gp;
        this.player = gp.getPlayer();
        this.inimigo = inimigo;
        this.turnoDoJogador = true;
        this.bossMorto = false;
    }

    public void turnoJogador() {
        if (turnoDoJogador ) {
            gp.getPlayer().variacaoAtaque();
            if (gp.getCombate().golpeSimples) {
                golpeFraco();
            } else if (gp.getCombate().golpeEspecial){
                golpeForte();
            } else if (gp.defendendo) {
                System.out.println("DEFENDEU!");
                defender();
            }
        }
    }

    public void turnoInimigo() {
        if (!turnoDoJogador) {
            inimigo.variacaoAtaque();
            if (gp.defendendo) {
                danoInimigo = inimigo.dano / 2;
                System.out.println("dano com defesa");
            } else {
                danoInimigo = rand.nextInt(5) + inimigo.dano;
                System.out.println("dano sem defesa");
            }
            inimigo.atacando = true;
            player.receberDamage(danoInimigo);
            System.out.println("Inimigo atacou e causou " + danoInimigo + " de dano.");
            turnoDoJogador = true;
            gp.defendendo = false;
        }
    }

    public void golpeFraco() {
        if (gp.getPlayer().mana >= 3 && !gp.getPlayer().getSpecialAttack()) {
            gp.lutando = true;
            gp.getPlayer().mana -= 3;
            inimigo.receberDamage(gp.getPlayer().getDano() + rand.nextInt(6));
            System.out.println("vida inimigo: " + inimigo.getVida());
            turnoDoJogador = false;
        } else {
            System.out.println("Mana insuficiente para golpe fraco!");
        }
        gp.getCombate().golpeSimples = false;
    }

    public void golpeForte() {
        if (gp.getPlayer().mana >= 7) {
            gp.getPlayer().setSpecialAttack(true);
            gp.lutando = true;
            gp.getPlayer().mana -= 7;
            inimigo.receberDamage((gp.getPlayer().getDano() * 2) + rand.nextInt(6));
            System.out.println("Vida do inimigo: " + inimigo.getVida());
            turnoDoJogador = false;
        } else {
            System.out.println("Mana insuficiente para golpe forte!");
        }
        gp.getCombate().golpeEspecial = false;
    }

    public void defender() {
        if(!gp.getPlayer().getSpecialAttack() && !gp.getCombate().golpeSimples && !gp.getCombate().golpeEspecial) {
            gp.getPlayer().mana += 5;
            if(gp.getPlayer().mana > gp.getPlayer().manaMax) {
                gp.getPlayer().mana = gp.getPlayer().manaMax;
            }
            turnoDoJogador = false;
        }

    }

    public boolean fimCombate() {
        return player.getVida() <= 0 || inimigo.getVida() <= 0;
    }

    public void update() {
        System.out.println(inimigo.atacando+"atacando do combate");
        if (fimCombate()) {
            if(inimigo.getVida() <= 0) {
                inimigo.morrendo = true;

            }
            System.out.println("player:" + player.getVida() + "inimigo: " + inimigo.getVida());
            if(inimigo.morto){
                gp.getUi().addMensagem("Você matou o "+inimigo.getClass().getSimpleName()+ " !");
                gp.setEstadoPersonagem(PainelDeJogo.EstadoPersonagem.Ocioso);
                gp.getPlayer().ganharXp(inimigo.xpDrop);

                gp.getPlayer().ganharMoeda(inimigo.moedaDrop);
                if(inimigo.boss){
                    gp.getCombate().bossMorto = true;
                    System.out.println("inimigo morto: "+ bossMorto);
                }
                
            }
            
            System.out.println("Combate terminado com: " + inimigo);

            return;
        }

        if (turnoDoJogador) {
            turnoJogador();
        } else {
            turnoInimigo();
        }
    }
}
         
        
