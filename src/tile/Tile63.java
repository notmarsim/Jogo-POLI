package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile63 extends Tile {
    public Tile63(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoLava.class.getResourceAsStream("/tiles/FogoTiles/tile63.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}