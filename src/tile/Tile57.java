package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile57 extends Tile {
    public Tile57(int id) {
        super(carregarImagem(), id);
    }


    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoLava.class.getResourceAsStream("/tiles/FogoTiles/tile57.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}