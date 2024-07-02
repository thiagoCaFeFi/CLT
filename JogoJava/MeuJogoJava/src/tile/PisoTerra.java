package MeuJogoJava.src.tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PisoTerra extends Tile{
    public PisoTerra(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoTerra.class.getResourceAsStream("/res/tiles/earth.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
