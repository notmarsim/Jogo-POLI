package entity;

import Objetos.SuperObject;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bau extends Entity {
    private GamePanel gp;

    public Bau(GamePanel gp, int startX, int startY) {
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        atacando = false;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -80;
        bounds.y = -80;
        bounds.width = 80;
        bounds.height = 80;
        xpDrop = 5;
        moedaDrop = 80;
        encostouBau = false;
    }

    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile020.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile021.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile022.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile023.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        if (encostouBau) {
            if (spriteNum == 1) {
                image = idle;
            } else if (spriteNum == 2) {
                image = idle2;
            } else if (spriteNum == 3) {
                image = idle3;
            } else if (spriteNum == 4) {
                image = idle4;
            }
        } else {
            image = idle;
        }

        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela, gp.tamanhoJanela, null);
    }

    @Override
    public void update() {
        if (encostouBau) {
            spriteCounter++;
            if (spriteCounter >= 5) {
                spriteCounter = 0;
                spriteNum++;
                if (spriteNum > 4) {
                    spriteNum = 4;
                }
            }
        } else {
            spriteNum = 0;
        }
    }

    public int getVida() {
        return vida;
    }

    public int tipo() {
        return 4;
    }
}

