package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bonfire extends Entity{
    private GamePanel gp;
    private int startX;
    private int startY;
    public Bonfire(GamePanel gp, int startX, int startY) {
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -80;
        bounds.y = -60;
        bounds.width = 80;
        bounds.height = 60;
    }
    private void loadSprites() {
        try {
            image1 = ImageIO.read(getClass().getResourceAsStream("/objetos/Bonfire_1.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objetos/Bonfire_2.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objetos/Bonfire_3.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/objetos/Bonfire_4.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        spriteCounter++;
        if (spriteCounter >= 8) {
            spriteCounter = 0;
            spriteNum++;
            if (spriteNum > 4) {
                spriteNum = 1;
            }
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        if (spriteNum == 1) {
            image = image1;
        } else if (spriteNum == 2) {
            image = image2;
        } else if (spriteNum == 3) {
            image = image3;
        } else if (spriteNum == 4) {
            image = image4;
        }
        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela, gp.tamanhoJanela*2, null);

    }
    public int tipo() {
        return 1;
    }

}
