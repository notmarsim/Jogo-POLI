package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Elder extends Entity {
    private GamePanel gp;

    public Elder(GamePanel gp, int startX, int startY) {
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        loadSprites();
    }

    public void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/npcs/elder.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = idle;
        g2.drawImage(image,(int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela *6) / 4), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela * 8) / 3), gp.tamanhoJanela * 3, gp.tamanhoJanela * 3, null);
    }
}
