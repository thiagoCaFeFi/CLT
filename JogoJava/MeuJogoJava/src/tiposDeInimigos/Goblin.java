package MeuJogoJava.src.tiposDeInimigos;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.principais.Inimigos;
public class Goblin extends Inimigos{
    private String nomeInimigo = "Goblin";
    public Goblin(PainelDeJogo gp, int dificuldadeInimigo, String nome){
        super(gp, dificuldadeInimigo);
        obterNomeInimigo("General das Sombras");
    }
}
