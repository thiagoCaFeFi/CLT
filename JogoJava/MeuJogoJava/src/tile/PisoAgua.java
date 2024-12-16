package MeuJogoJava.src.tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PisoAgua extends Tile {
    public PisoAgua(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoAgua.class.getResourceAsStream("/res/tiles/water.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
