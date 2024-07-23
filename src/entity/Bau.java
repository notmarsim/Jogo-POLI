package entity;

import Objetos.SuperObject;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bau extends Entity{
    private GamePanel gp;

    public Bau(GamePanel gp, int startX, int startY){
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        atacando = false;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = 220;
        bounds.y = 120;
        bounds.width = 160;
        bounds.height = 170;
        vida = 100;
        dano = 20;
        xpDrop = 50;
        moedaDrop = 100;
        boss = true;
    }

    private void loadSprites() {
        try {

            idle = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile020.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile021.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile022.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile023.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile024.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile025.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile026.png"));
            idle8 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile027.png"));
            idle9 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile028.png"));
            idle10 = ImageIO.read(getClass().getResourceAsStream("/objetos/bau/tile029.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        if(gp.getPlayer().encostouBau){
            if (spriteNum == 1) {
                image = idle;
            } else if (spriteNum == 2) {
                image = idle2;
            } else if (spriteNum == 3) {
                image = idle3;
            } else if (spriteNum == 4) {
                image = idle4;
            } else if (spriteNum == 5) {
                image = idle5;
            } else if (spriteNum == 6) {
                image = idle6;
            } else if (spriteNum == 7) {
                image = idle7;
            }else if (spriteNum == 8) {
                image = idle8;
            }else if (spriteNum == 9) {
                image = idle9;
            }else if (spriteNum == 10) {
                image = idle10;
            }

        }else{image = idle;}

        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela*9/6, gp.tamanhoJanela*5/6, null);
        g2.setColor(Color.RED);
        g2.drawRect((int) (x + bounds.x - gp.getCamera().getxOffSet()),
                (int) (y + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);
    }

    @Override
    public void update() {
        if (gp.getPlayer().encostouBau) {
            spriteCounter++;
            if (spriteCounter >= 5) {
                spriteCounter = 0;
                spriteNum++;
                if (spriteNum > 10) {
                    spriteNum = 1;
                    setShouldBeRemoved(true);
                }
            }
        }else {
            spriteNum = 0;
        }

    }



    public int getVida(){
        return vida;
    }
    public int tipo() {
        return 4;
    }

}
