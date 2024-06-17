package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Elder extends Entity {


    public Elder(GamePanel gp, int startX, int startY) {
        super(gp);
        this.x = startX;
        this.y = startY;
        loadSprites();
    }

    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/npcs/elder.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = idle;
        g2.drawImage(image,(int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela *15) / 14), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela * 8) / 5), gp.tamanhoJanela * 3, gp.tamanhoJanela * 3, null);
    }
}