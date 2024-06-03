package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PisoMadeira extends Tile {
    public PisoMadeira(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoTijoloPedra.class.getResourceAsStream("/tiles/pisoMadeira.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


