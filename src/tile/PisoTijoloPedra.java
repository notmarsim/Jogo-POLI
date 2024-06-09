package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PisoTijoloPedra extends Tile {
    public PisoTijoloPedra(int id) {
        super(carregarImagem(), id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoTijoloPedra.class.getResourceAsStream("/tiles/pisoTijoloPedra.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
