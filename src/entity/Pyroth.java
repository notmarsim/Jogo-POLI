package entity;

import main.GamePanel;
import main.KeyHandler;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Pyroth extends Player {

    public Pyroth(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        loadSprites();
        speed = 4;
    }

    public void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle_6.png"));

            run = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run1.png"));
            run2 =  ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run2.png"));
            run3 =  ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run3.png"));
            run4 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run4.png"));
            run5 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run5.png"));
            run6 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run6.png"));
            run7 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run7.png"));


            runcostas = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run1costas.png"));
            runcostas2 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run2costas.png"));
            runcostas3 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run3costas.png"));
            runcostas4 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run4costas.png"));
            runcostas5 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run5costas.png"));
            runcostas6 =ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run6costas.png"));
            runcostas7 = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/run/run7costas.png"));

            idleback = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle1back.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle2back.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle3back.png"));
            idle4back = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle4back.png"));
            idle5back = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle5back.png"));
            idle6back = ImageIO.read(getClass().getResourceAsStream("/player/Pyroth/idle/idle6back.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
