package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CasaVermelha extends Entity {


    public CasaVermelha(GamePanel gp, int startX, int startY) {
        super(gp);
        this.x = startX;
        this.y = startY;
        bounds = new Rectangle();
        bounds.x = -230;
        bounds.y = -400;
        bounds.width = 450;
        bounds.height = 420;
        loadSprites();
    }

    private void loadSprites() {
        try {
            image1 = ImageIO.read(getClass().getResourceAsStream("/objetos/fireHouse.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = image1;
        g2.drawImage(image,(int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)*4), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)*7), gp.tamanhoJanela*8 , gp.tamanhoJanela *8, null);
    }

    public int tipo(){
        return 1;
    }
}