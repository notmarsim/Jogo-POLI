package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Tocha extends Entity{
    private GamePanel gp;
    private int startX;
    private int startY;
    public Tocha(GamePanel gp, int startX, int startY) {
        super(gp);
        this.x = startX;
        this.y = startY;

    }
    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/npcs/.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
