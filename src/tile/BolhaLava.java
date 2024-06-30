package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BolhaLava extends Tile {
    public BolhaLava(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoTijoloPedra.class.getResourceAsStream("/tiles/FogoTiles/bolha.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}