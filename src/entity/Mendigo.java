package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mendigo extends Entity {

    public Mendigo(GamePanel gp, int startX, int startY) {
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -45;
        bounds.y = -70;
        bounds.width = 80;
        bounds.height = 100;
    }


    private void loadSprites() {
        try {
            image1 = ImageIO.read(getClass().getResourceAsStream("/npcs/mendigo/beggar_00.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/npcs/mendigo/beggar_01.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/npcs/mendigo/beggar_02.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/npcs/mendigo/beggar_03.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("/npcs/mendigo/beggar_04.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
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
            image = image1;
        } else if (spriteNum == 3) {
            image = image2;
        } else if (spriteNum == 4) {
            image = image2;
        }else if (spriteNum == 5) {
            image = image3;
        }else if (spriteNum == 6) {
            image = image4;
        }
        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela*15/10, gp.tamanhoJanela*15/10, null);



    }


    public int tipo() {
        return 2;
    }

    public String getFala(){
        return "M...Me...D-dá dinheiro por favor...";
    }

}