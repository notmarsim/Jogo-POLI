package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PisoElder extends Tile {
    public PisoElder(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoElder.class.getResourceAsStream("/tiles/water.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
