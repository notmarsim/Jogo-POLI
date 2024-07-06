package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tocha extends Entity{
    private GamePanel gp;
    private int startX;
    private int startY;
    public Tocha(GamePanel gp, int startX, int startY) {
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -80;
        bounds.y = -80;
        bounds.width = 80;
        bounds.height = 80;
    }
    private void loadSprites() {
        try {
             image1 = ImageIO.read(getClass().getResourceAsStream("/objetos/torch1.png"));
             image2 = ImageIO.read(getClass().getResourceAsStream("/objetos/torch2.png"));
             image3 = ImageIO.read(getClass().getResourceAsStream("/objetos/torch3.png"));
             image4 = ImageIO.read(getClass().getResourceAsStream("/objetos/torch4.png"));
             image5 = ImageIO.read(getClass().getResourceAsStream("/objetos/torch5.png"));
             image6 = ImageIO.read(getClass().getResourceAsStream("/objetos/torch6.png"));
             image7 = ImageIO.read(getClass().getResourceAsStream("/objetos/torch7.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int tipo() {
        return 1;
    }

}
