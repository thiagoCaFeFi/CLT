package Item;

public abstract class Itens {
    private String nome;

    public Itens(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
