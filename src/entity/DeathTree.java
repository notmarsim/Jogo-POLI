package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DeathTree extends Entity {


    public DeathTree(GamePanel gp, int startX, int startY) {
        super(gp);
        this.x = startX;
        this.y = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -50;
        bounds.y = -50;
        bounds.width = 100;
        bounds.height = 150;
    }

    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/objetos/deathTree.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = idle;
        g2.drawImage(image,(int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela ) ), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela*2 , gp.tamanhoJanela*2 , null);
        g2.setColor(Color.RED);
        g2.drawRect((int) (x + bounds.x - gp.getCamera().getxOffSet()),
                (int) (y + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);
    }
}