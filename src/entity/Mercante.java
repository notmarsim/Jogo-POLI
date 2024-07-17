package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mercante extends Entity{
    GamePanel gp;

    public Mercante(GamePanel gp, int startX, int startY) {
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
            image1 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile000.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile001.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile002.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile003.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile004.png"));
            image6 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile005.png"));
            image7 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile006.png"));
            image8 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile007.png"));
            image9 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile008.png"));
            image10 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile009.png"));
            image11 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile010.png"));
            image12 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile011.png"));
            image13 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile012.png"));
            image14 = ImageIO.read(getClass().getResourceAsStream("/npcs/mercante/tile013.png"));


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
            if (spriteNum > 13) {
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
        } else if (spriteNum == 5) {
            image = image5;
        }else if (spriteNum == 6) {
            image = image6;
        }else if (spriteNum == 7) {
            image = image7;
        }else if (spriteNum == 8) {
            image = image8;
        }else if (spriteNum == 9) {
            image = image9;
        }else if (spriteNum == 10) {
            image = image10;
        } else if (spriteNum == 11) {
            image = image11;
        }else if (spriteNum == 12) {
            image = image12;
        }else if (spriteNum == 13) {
            image = image13;
        }else if (spriteNum == 14) {
            image = image14;
        }
        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela*2, gp.tamanhoJanela*2, null);



    }


    public int tipo() {
        return 2;
    }

    public String getFala(){
        return "Deseja comprar algo? \n" +
                "1 - Poção de Força\n" +
                "2 - Poção de Cura\n";
    }

}
