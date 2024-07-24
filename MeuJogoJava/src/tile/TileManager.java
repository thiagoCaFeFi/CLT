package MeuJogoJava.src.tile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;
import MeuJogoJava.src.main.PainelDeJogo;

public class TileManager {
    private static final int MAX_CAPITULOS = 2;
    private static final int MAX_TILES = 1000;
    private static Tile[][] tiles = new Tile[MAX_CAPITULOS][MAX_TILES];
    private PainelDeJogo gp;
    private int mapTileNum[][];

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
        addTile(PainelDeJogo.Capitulos.galan, 1, "/MeuJogoJava/res/tiles/wall.png", true);
        addTile(PainelDeJogo.Capitulos.galan, 4, "/MeuJogoJava/res/tiles/earth.png", false);
        addTile(PainelDeJogo.Capitulos.galan, 5, "/MeuJogoJava/res/tiles/grass.png", false);
        addTile(PainelDeJogo.Capitulos.galan, 6, "/MeuJogoJava/res/tiles/water.png", true);
        addTile(PainelDeJogo.Capitulos.galan, 7, "/MeuJogoJava/res/tiles/caminho.png", false);
    }

    /*public void loadMapPrologo(String filePath){
        carregarTilePrologo();
        try {

            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.tamanhoMaximoVertical && row  < gp.tamanhoMaximoHorizontal){

                String line = br.readLine();

                while (col < gp.tamanhoMaximoVertical){
                    
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.tamanhoMaximoVertical){
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }
    public void drawPrologo (Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.tamanhoMaximoVertical && row < gp.tamanhoMaximoHorizontal){
            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tamanhoTitulo, gp.tamanhoTitulo, null);
            col++;
            x += gp.tamanhoTitulo;

            if(col == gp.tamanhoMaximoVertical){
                col = 0;
                x = 0;
                row++;
                y += gp.tamanhoTitulo;
            }  
        }
    }
}  
   
   /* public void loadMapPrologo(String filePath){
        try {
            
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.tamanhoMaximoVertical && row  < gp.tamanhoMaximoHorizontal){

                String line = br.readLine();

                while (col < gp.tamanhoMaximoVertical){
                    
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.tamanhoMaximoVertical){
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }
    public void drawPrologo (Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.tamanhoMaximoVertical && row < gp.tamanhoMaximoHorizontal){
            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tamanhoTitulo, gp.tamanhoTitulo, null);
            col++;
            x += gp.tamanhoTitulo;

            if(col == gp.tamanhoMaximoVertical){
                col = 0;
                x = 0;
                row++;
                y += gp.tamanhoTitulo;
            }
        }
    }
    public void loadMapGalan(String filePath){
        carregarTilesGalan();
        try {
            
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.tamanhoMaximoVertical && row  < gp.tamanhoMaximoHorizontal){

                String line = br.readLine();

                while (col < gp.tamanhoMaximoVertical){
                    
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.tamanhoMaximoVertical){
                    col = 0;
                    row++;
                }
            }
            br.close();

        } catch (Exception e) {

        }
    }
    public void draw (Graphics2D g2){

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < gp.tamanhoMaximoVertical && row < gp.tamanhoMaximoHorizontal){
            int tileNum = mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gp.tamanhoTitulo, gp.tamanhoTitulo, null);
            col++;
            x += gp.tamanhoTitulo;

            if(col == gp.tamanhoMaximoVertical){
                col = 0;
                x = 0;
                row++;
                y += gp.tamanhoTitulo;
            }
        }
    }

        }
    }*/
}