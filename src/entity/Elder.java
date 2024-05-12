package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Elder extends Entity{
    private GamePanel gp;

    public Elder(GamePanel gp){
        this.gp = gp;
        loadSprites();
        setDefaultValues();

    }
    public void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/npcs/elder.png"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        }
    protected void setDefaultValues() {
        x = 100;
        y = 100;
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        image = idle;
        g2.drawImage(image,x, y, gp.tamanhoJanela *2 , gp.tamanhoJanela*2, null);


    }
    }


