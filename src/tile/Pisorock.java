package tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Pisorock extends Tile {
    public Pisorock(int id) {
        super(carregarImagem(), id);
    }

    private static BufferedImage carregarImagem() {
        try {
            return ImageIO.read(Pisorock.class.getResourceAsStream("/tiles/pisoPedra2.png"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
