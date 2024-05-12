package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TileEarth extends Tile {
    public TileEarth(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(Pisorock.class.getResourceAsStream("/tiles/earth.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


