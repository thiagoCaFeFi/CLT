package MeuJogoJava.src;

//Javali Silvestre estalone, (Goblin, Xamã, Hobgoblin, Ogro); (Mago das Sombras, Cavaleiro das Sombras, General das Sombras, Soldado das Sombras).

public class Inimigos {
    private String nome1;
    private int vida1;
    public Inimigos(String nome1, int vida1){
        this.nome1 = nome1;
        this.vida1 = vida1;
    }
    public String getNome1() { 
        return nome1; 
    }
    public int getVida1(){
        return vida1;
    }

}

