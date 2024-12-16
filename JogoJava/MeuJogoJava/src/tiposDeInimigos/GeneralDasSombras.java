package MeuJogoJava.src.tiposDeInimigos;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.principais.Inimigos;
public class GeneralDasSombras extends Inimigos{
    private String nomeInimigo;
    public GeneralDasSombras(PainelDeJogo gp, int dificuldadeInimigo, String nome){
        super(gp, dificuldadeInimigo);
        obterNomeInimigo("General das Sombras");
    }
}
