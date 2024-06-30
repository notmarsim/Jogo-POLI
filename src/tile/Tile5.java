package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile5 extends Tile {
    public Tile5(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoLava.class.getResourceAsStream("/tiles/FogoTiles/tile5.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}