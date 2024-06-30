package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GoldChest extends Tile {
    public GoldChest(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoTijoloPedra.class.getResourceAsStream("/tiles/FogoTiles/goldchest1.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}