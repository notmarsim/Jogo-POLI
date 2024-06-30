package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RochaAfundada extends Tile {
    public RochaAfundada(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoLava.class.getResourceAsStream("/tiles/FogoTiles/rochaafundada.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}