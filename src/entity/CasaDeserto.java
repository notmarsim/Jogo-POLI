package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CasaDeserto extends Entity{
    private GamePanel gp;
    private int startX;
    private int startY;
    public CasaDeserto(GamePanel gp, int startX, int startY) {
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -160;
        bounds.y = -180;
        bounds.width = 300;
        bounds.height = 420;
    }
    private void loadSprites() {
        try {
            image1 = ImageIO.read(getClass().getResourceAsStream("/objetos/CasaDeserto.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = image1;
        g2.drawImage(image,(int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)*2), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela*3)), gp.tamanhoJanela*4 , gp.tamanhoJanela*6,null);

    }

    public int tipo() {
        return 1;
    }

}
