package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Aeris extends Player {

    public Aeris(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        loadSprites();
        speed = 6;
    }


    public void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_6.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_7.png"));
            idle8 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_8.png"));

            idleback = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_1back.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_2back.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_3back.png"));
            idle4back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_4back.png"));
            idle5back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_5back.png"));
            idle6back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_6back.png"));
            idle7back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_7back.png"));
            idle8back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_8back.png"));

            run = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_1.png"));
            run2 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_2.png"));
            run3 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_3.png"));
            run4 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_4.png"));
            run5 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_5.png"));
            run6 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_6.png"));
            run7 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_7.png"));
            run8 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_8.png"));

            runcostas = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_1back.png"));
            runcostas2 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_2back.png"));
            runcostas3 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_3back.png"));
            runcostas4 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_4back.png"));
            runcostas5 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_5back.png"));
            runcostas6 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_6back.png"));
            runcostas7 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_7back.png"));
            runcostas8 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_8back.png"));



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

