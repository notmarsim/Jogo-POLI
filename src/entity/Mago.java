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
        speed = 4;
    }

    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idlemago1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idlemago2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idlemago3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idlemago4.png"));
            run = ImageIO.read(getClass().getResourceAsStream("/player/Mago/runmago.png"));
            run2 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/runmago2.png"));
            run3 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/runmago3.png"));
            run4 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/runmago4.png"));
            run5 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/runmago5.png"));
            costas = ImageIO.read(getClass().getResourceAsStream("/player/Mago/runmagoback.png"));
            costas2 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/runmagoback2.png"));
            costas3 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/runmagoback3.png"));
            costas4 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/runmagoback4.png"));
            costas5 = ImageIO.read(getClass().getResourceAsStream("/player/Mago/runmagoback5.png"));
            idleback = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idleback.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idle2back.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idle3back.png"));
            idle4back = ImageIO.read(getClass().getResourceAsStream("/player/Mago/idle4back.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
