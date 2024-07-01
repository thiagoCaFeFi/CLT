package MeuJogoJava.src.principais;

import java.util.Random;


import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.tiposDeInimigos.CavaleiroDasSombras;
import MeuJogoJava.src.tiposDeInimigos.GeneralDasSombras;
import MeuJogoJava.src.tiposDeInimigos.HobGoblin;
import MeuJogoJava.src.tiposDeInimigos.Javali;
import MeuJogoJava.src.tiposDeInimigos.MagoDasSombras;

public class Inimigos extends SerVivo{
    private int XP;
    private double coeficienteXP;
    private int dificuldadeInimigo;
    private String nomeInimigo;
    public Inimigos(int dificuldadeInimigo, String nome, int vida, boolean EstaVivo,int posicaoX, int posicaoY, int velocidade, PainelDeJogo gp){
        super(nome,vida,EstaVivo,posicaoX,posicaoY,velocidade,gp);
        this.dificuldadeInimigo = dificuldadeInimigo;
    }
    public String obterNomeInimigo(String nome){
        this.nomeInimigo = nome;
        return nomeInimigo;

    }
    public static Inimigos escolherInimigo(String nomeInimigo, int dificuldadeInimigo) {
        Random random = new Random();
        int personagemIndex = random.nextInt(7) + 1;

        switch (personagemIndex) {
            case 1:
                return new Javali(nomeInimigo, dificuldadeInimigo);
            case 2:
                return new Goblin(nomeInimigo, dificuldadeInimigo);
            case 3:
                return new HobGoblin(nomeInimigo, dificuldadeInimigo);
            case 4:
                return new SoldadoDasSombbras(nomeInimigo, dificuldadeInimigo);
            case 5:   
                return new CavaleiroDasSombras(nomeInimigo, dificuldadeInimigo);
            case 6:
                return new MagoDasSombras(nomeInimigo, dificuldadeInimigo);
            case 7:
                return new GeneralDasSombras(nomeInimigo, dificuldadeInimigo);
            default:
                System.out.println("Escolha inválida");
                return null;
        }
    }

    public int gerarXP(){
        switch (dificuldadeInimigo) {
            case 1:
                coeficienteXP = 0.50;
                break;
        
            case 2:
                coeficienteXP = 0.70;
                break;
            
            case 3:
                coeficienteXP = 1;
                break;
            case 4:
                coeficienteXP = 1.25;
                break;
            case 5:
                coeficienteXP = 1.50;
                break;
            case 6:
                coeficienteXP = 1.75;
                break;
            case 7:
                coeficienteXP = 2;
                break;
        }

        XP = (int) ((double)(coeficienteXP*300));
        return XP;
    }
    public int getXP() {
        return XP;
    }
    public void setXP(int xP) {
        XP = xP;
    }

    public double getCoeficienteXP() {
        return coeficienteXP;
    }
    public void setCoeficienteXP(int coeficienteXP) {
        this.coeficienteXP = coeficienteXP;
    }

    public int getDificuldadeInimigo() {
        return dificuldadeInimigo;  
    }
    public void setDificuldadeInimigo(int dificuldadeInimigo) {
        this.dificuldadeInimigo = dificuldadeInimigo;
    }

    }

