package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile97 extends Tile {
    public Tile97(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoTijoloPedra.class.getResourceAsStream("/tiles/FogoTiles/tile97.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


