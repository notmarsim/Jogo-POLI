package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Demonio extends Entity{
    private GamePanel gp;
    public Demonio(GamePanel gp, int startX, int startY){
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = 220;
        bounds.y = 120;
        bounds.width = 160;
        bounds.height = 170;
        vida = 70;
        dano = 8;
    }

    private void loadSprites() {
        try {
            // PARADO
            idle = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demon_idle_1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demon_idle_2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demon_idle_3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demon_idle_4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demon_idle_5.png"));

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
            image = idle3;
        } else if (spriteNum == 5) {
            image = idle4;
        } else if (spriteNum == 6) {
            image = idle4;
        } else if (spriteNum == 7) {
            image = idle5;
        }
        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela*9, gp.tamanhoJanela*5, null);


      /*  g2.setColor(Color.RED);
        g2.drawRect((int) (x + bounds.x - gp.getCamera().getxOffSet()),
                (int) (y + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);

       */
    }



    public int getVida(){
        return vida;
    }
    public int tipo() {
        return 3;
    }

}
