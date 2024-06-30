package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tile60 extends Tile {
    public Tile60(int id) {
        super(carregarImagem(), id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoLava.class.getResourceAsStream("/tiles/FogoTiles/tile60.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}