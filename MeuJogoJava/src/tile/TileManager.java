package MeuJogoJava.src.tile;

import MeuJogoJava.src.main.PainelDeJogo;

public class TileManager {
    private static final int MAX_CAPITULOS = 2;
    private static final int MAX_TILES = 3000;
    private static Tile[][] tiles = new Tile[MAX_CAPITULOS][MAX_TILES];
    private PainelDeJogo gp;

    public TileManager(PainelDeJogo gp) {
        this.gp = gp;
    }

    public void carregarTile(PainelDeJogo.Capitulos capitulo) {
        if (capitulo.equals(PainelDeJogo.Capitulos.Prologo)) {
            carregarTilePrologo();
        } else if (capitulo.equals(PainelDeJogo.Capitulos.galan)) {
            carregarTilesGalan();
        } 
    }
        private void addTile(PainelDeJogo.Capitulos chapter, int id, String imagePath, boolean isSolid) {
            int chapterIndex = chapter.ordinal();
            if (tiles[chapterIndex][id] == null) {
                Tile tile = new Tile(imagePath, id, isSolid);
                tiles[chapterIndex][id] = tile;
            }
        }
    
        public static Tile getTile(PainelDeJogo.Capitulos chapter, int id) {
            int chapterIndex = chapter.ordinal();
            Tile tile = tiles[chapterIndex][id];
            if (tile == null) {
                System.err.println("Tile não carregado: " + id + " no capítulo " + chapter);
                return tiles[chapterIndex][1]; // Supondo que o tile 1 seja o padrão
            }
            return tile;
        }
    
    private void carregarTilePrologo() {
        addTile(PainelDeJogo.Capitulos.Prologo, 1, "/MeuJogoJava/res/tiles/wall.png", true);
        addTile(PainelDeJogo.Capitulos.Prologo, 2, "/MeuJogoJava/res/tiles/floor_1.png", false);
        addTile(PainelDeJogo.Capitulos.Prologo, 3, "/MeuJogoJava/res/tiles/floor_2.png", false);
    }
    private void carregarTilesGalan() {
        addTile(PainelDeJogo.Capitulos.Prologo, 1, "/MeuJogoJava/res/tiles/wall.png", true);
        addTile(PainelDeJogo.Capitulos.Prologo, 4, "/tiles/earth.png", false);
        addTile(PainelDeJogo.Capitulos.Prologo, 5, "/tiles/grass.png", false);
        addTile(PainelDeJogo.Capitulos.Prologo, 6, "/tiles/water.png", true);
        addTile(PainelDeJogo.Capitulos.Prologo, 7, "/tiles/caminho.png", false);
    }
}

