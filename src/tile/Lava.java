package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Lava extends Tile {
    public Lava(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoTijoloPedra.class.getResourceAsStream("/tiles/FogoTiles/lava.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


