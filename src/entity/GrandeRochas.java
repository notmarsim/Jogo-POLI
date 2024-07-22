package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GrandeRochas extends Entity {


    public GrandeRochas(GamePanel gp, int startX, int startY) {
        super(gp);
        this.x = startX;
        this.y = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -30;
        bounds.y = -30;
        bounds.width = 155;
        bounds.height = 100;
    }

    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/objetos/GrandesRochas.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = idle;
        g2.drawImage(image,(int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela ) ), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela*7/2 , gp.tamanhoJanela*5/2, null);

    }

    public int tipo() {
        return 1;
    }
}