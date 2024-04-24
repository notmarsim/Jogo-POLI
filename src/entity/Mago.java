package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Mago extends Player {

    public Mago(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        loadSprites();
    }

    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idlemago1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idlemago2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idlemago3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idlemago4.png"));
            run = ImageIO.read(getClass().getResourceAsStream("/player/Mago/run.png"));
            run2 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/run2.png"));
            run3 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/run3.png"));
            run4 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/run4.png"));
            run5 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/run5.png"));
            costas = ImageIO.read(getClass().getResourceAsStream("/player/Mago/back.png"));
            costas2 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/back2.png"));
            costas3 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/back3.png"));
            costas4 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/back4.png"));
            costas5 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/back5.png"));
            idleback = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idleback.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idle2back.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idle3back.png"));
            idle4back = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idle4back.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
