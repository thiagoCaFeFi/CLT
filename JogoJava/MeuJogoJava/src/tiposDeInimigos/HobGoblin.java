package MeuJogoJava.src.tiposDeInimigos;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.principais.Inimigos;
public class HobGoblin extends Inimigos {
    private String nomeInimigo = "HobGoblin";
    public HobGoblin(PainelDeJogo gp, int dificuldadeInimigo, String nome){
        super(gp, dificuldadeInimigo);
        obterNomeInimigo("General das Sombras");
    }
}
