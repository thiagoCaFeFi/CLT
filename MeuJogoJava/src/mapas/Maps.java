package MeuJogoJava.src.mapas;

import MeuJogoJava.src.main.PainelDeJogo;
import MeuJogoJava.src.tile.Tile;
import MeuJogoJava.src.tile.TileManager;
import MeuJogoJava.src.auxiliar.Utils;

import java.awt.*;


public class Maps {
    private int width, height;
    private int[][] tiles;
    private TileManager tileManager;
    private PainelDeJogo.Capitulos chapter;
    public PainelDeJogo gp;
    


    public Maps(PainelDeJogo gp, String path,  PainelDeJogo.Capitulos chapter) {
        this.gp = gp;
        this.chapter = chapter;
        tileManager = new TileManager(gp);
        tileManager.carregarTile(chapter);
        loadMap(path);
    }

    public void update() {

    }
    public void draw(Graphics2D g2) {
        int xStart = (int) Math.max(0,gp.getCamera().getxOffSet()/ Tile.tileWidth);
        int yStart = (int) Math.max(0,gp.getCamera().getyOffSet()/ Tile.tileHeight);
        int xEnd = (int) Math.min(width,(gp.getCamera().getxOffSet() + gp.tamanhoComprimento) / Tile.tileWidth +1);
        int yEnd = (int) Math.min(height,(gp.getCamera().getyOffSet() + gp.tamanhoAltura) / Tile.tileHeight + 1);
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                Tile tile = getTile(x, y);
                if (tile != null) {
                    tile.draw(g2, (int) (x * Tile.tileWidth - gp.getCamera().getxOffSet()), (int) (y * Tile.tileHeight - gp.getCamera().getyOffSet()));
                } else {
                    System.err.println("Tile em (" + x + ", " + y + ") é nulo. Usando tile padrão.");
                    Tile defaultTile = TileManager.getTile(chapter, 1);
                    if (defaultTile != null) {
                        defaultTile.draw(g2, (int) (x * Tile.tileWidth - gp.getCamera().getxOffSet()), (int) (y * Tile.tileHeight - gp.getCamera().getyOffSet()));
                    } else {
                        System.err.println("Tile padrão (ID 1) não encontrado.");
                    }
                }
            }
        }
    }
    //pra colocar um npc unico no mapa depois
    public Point findTileCoordinates(int targetID) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (tiles[x][y] == targetID) {
                    return new Point(x, y);
                }
            }
        }
        return null;
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return TileManager.getTile(chapter, 1);
        }
        Tile t = TileManager.getTile(chapter, tiles[x][y]);
        if (t == null) {
            System.err.println("Tile não carregado em (" + x + ", " + y + "). Usando tile padrão.");
            return TileManager.getTile(chapter, 1);
        }
        return t;
    }

    private void loadMap(String path) {
        String map = Utils.carregarFileString(path);
        String[] lines = map.split("\\n");
        height = lines.length;
        width = lines[0].split(" ").length;
        tiles = new int[width][height];

        for (int y = 0; y < height; y++) {
            String[] tokens = lines[y].split(" ");
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[x]);

            }
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }
}
