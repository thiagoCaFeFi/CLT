package Item;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Itens> itens;

    public Inventario() {
        itens = new ArrayList<>();
    }

    public void addItem(Itens item) {
        itens.add(item);
    }

    public void removeItem(Itens item) {
        itens.remove(item);
    }

    public List<Itens> getItems() {
        return itens;
    }

    public void showInventory() {
        if (itens.isEmpty()) {
            System.out.println("O inventário está vazio.");
        } else {
            System.out.println("Itens no inventário:");
            for (Itens item : itens) {
                System.out.println(item);
            }
        }
    }
}
