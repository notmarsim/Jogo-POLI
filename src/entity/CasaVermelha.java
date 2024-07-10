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
        bounds.x = 220;
        bounds.y = 120;
        bounds.width = 160;
        bounds.height = 170;
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
       /*
        g2.setColor(Color.RED);
        g2.drawRect((int) (x + bounds.x - gp.getCamera().getxOffSet()),
                (int) (y + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);

        */
    }

    public int tipo(){
        return 1;
    }
}