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

    public void update() {
        spriteCounter++;
        if (spriteCounter >= 5) {
            spriteCounter = 0;
            spriteNum++;
            if (spriteNum > 7) {
                spriteNum = 1;
            }
        }
    }

    public void draw(Graphics2D g2) {
        if (gp == null) {
            System.err.println("Erro: GamePanel é null em Tocha.draw()");
            return;
        }
        BufferedImage image = null;
        if(spriteNum == 1) {
            image = image1;
        } else if(spriteNum == 2) {
            image = image2;
        } else if (spriteNum == 3) {
            image = image3;
        } else if (spriteNum == 4) {
            image = image4;
        } else if(spriteNum == 5) {
            image = image5;
        } else if (spriteNum == 6 ) {
            image = image6;
        } else if (spriteNum ==7) {
            image = image7;
        }
        g2.drawImage(image,(int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela ) ), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela , gp.tamanhoJanela , null);
    }

}
