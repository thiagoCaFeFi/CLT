package MeuJogoJava.src.tiposDeInimigos;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.principais.Inimigos;
public class MagoDasSombras extends Inimigos {
    private String nomeInimigo = "Mago das Sombras";
    public MagoDasSombras(PainelDeJogo gp, int dificuldadeInimigo, String nome){
        super(gp, dificuldadeInimigo);
        obterNomeInimigo("General das Sombras");
    }
}
