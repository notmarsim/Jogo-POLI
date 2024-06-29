package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TijoloLava extends Tile {
    public TijoloLava(int id) {
        super(carregarImagem(), id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(PisoLava.class.getResourceAsStream("/tiles/tijoloLava.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}