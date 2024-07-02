package MeuJogoJava.src.tiposDeInimigos;
import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.principais.Inimigos;
public class SoldadoDasSombras extends Inimigos {
    private String nomeInimigo = "Soldado das Sombras";
    public SoldadoDasSombras(PainelDeJogo gp, int dificuldadeInimigo, String nome){
        super(gp, dificuldadeInimigo);
        obterNomeInimigo("General das Sombras");
    }
}
