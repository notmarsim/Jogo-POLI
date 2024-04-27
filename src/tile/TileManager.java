package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }
    public void getTileImage() {
            try  {
                tile[0] = new Tile();
                tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));
                tile[1] = new Tile();
                tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
                tile[2] = new Tile();
                tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void draw(Graphics2D g2){
        int col;
        int row;
        int x = 0;
        int y = 0;
    }
}
