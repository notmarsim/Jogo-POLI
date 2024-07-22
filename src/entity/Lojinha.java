package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Lojinha extends Entity{
    private GamePanel gp;
    private int startX;
    private int startY;
    public Lojinha(GamePanel gp, int startX, int startY) {
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -80;
        bounds.y = -80;
        bounds.width = 80;
        bounds.height = 80;
    }
    private void loadSprites() {
        try {
            image1 = ImageIO.read(getClass().getResourceAsStream("/objetos/lojinha.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){
        BufferedImage image = image1;
        g2.drawImage(image,(int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)*2), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela*3)), gp.tamanhoJanela*4 , gp.tamanhoJanela*4,null);
        g2.setColor(Color.RED);
        g2.drawRect((int) (x + bounds.x - gp.getCamera().getxOffSet()),
                (int) (y + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);
    }

    public int tipo() {
        return 1;
    }

}
