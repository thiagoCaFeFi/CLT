package MeuJogoJava.src.tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class PisoGrama extends Tile{
    public PisoGrama(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoGrama.class.getResourceAsStream("/res/tiles/grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
