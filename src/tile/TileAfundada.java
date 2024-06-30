package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TileAfundada extends Tile {
    public TileAfundada(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoLava.class.getResourceAsStream("/tiles/FogoTiles/pedraafundada.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}