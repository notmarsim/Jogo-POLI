package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DemonPequeno extends Entity{
    private GamePanel gp;
    public DemonPequeno(GamePanel gp, int startX, int startY){
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -60;
        bounds.y = -70;
        bounds.width = 80;
        bounds.height = 100;
        vida = 20;
        dano = 4;
    }

    private void loadSprites() {
        try {

            idle = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demon/tile0.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demon/tile1.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demon/tile2.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demon/tile3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        if (spriteNum == 1) {
            image = idle;
        } else if (spriteNum == 2) {
            image = idle;
        } else if (spriteNum == 3) {
            image = idle2;
        } else if (spriteNum == 4) {
            image = idle2;
        } else if (spriteNum == 5) {
            image = idle3;
        } else if (spriteNum == 6) {
            image = idle3;
        } else if (spriteNum == 7) {
            image = idle3;
        }
        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela*13/10, gp.tamanhoJanela*13/10, null);


        g2.setColor(Color.RED);
        g2.drawRect((int) (x + bounds.x - gp.getCamera().getxOffSet()),
                (int) (y + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);


    }



    public int getVida(){
        return vida;
    }
    public int tipo() {
        return 3;
    }

}
