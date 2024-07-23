package entity;

import main.GamePanel;
import main.KeyHandler;
import tile.Tile;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Aeris extends Player {
    private Random rand = new Random();
    private KeyHandler keyH;
    public Aeris(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        this.keyH = keyH;
        loadSprites();
        speed = 10;
        bounds.y = -40;
        bounds.x = -30;
        bounds.width = 50;
        bounds.height = 80;

    }


    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_6.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_7.png"));
            idle8 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_8.png"));

            idleback = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_back1.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_back2.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_back3.png"));
            idle4back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_back4.png"));
            idle5back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_back5.png"));
            idle6back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_back6.png"));
            idle7back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_back7.png"));
            idle8back = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/idle/idle_back8.png"));

            run = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_1.png"));
            run2 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_2.png"));
            run3 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_3.png"));
            run4 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_4.png"));
            run5 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_5.png"));
            run6 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_6.png"));
            run7 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_7.png"));
            run8 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_8.png"));

            runcostas = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_back1.png"));
            runcostas2 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_back2.png"));
            runcostas3 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_back3.png"));
            runcostas4 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_back4.png"));
            runcostas5 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_back5.png"));
            runcostas6 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_back6.png"));
            runcostas7 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_back7.png"));
            runcostas8 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/run/run_back8.png"));

            attack1 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/AtkNormal/1_atk_1.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/AtkNormal/1_atk_2.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/AtkNormal/1_atk_3.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/AtkNormal/1_atk_4.png"));
            attack5 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/AtkNormal/1_atk_5.png"));
            attack6 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/AtkNormal/1_atk_6.png"));
            attack7 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/AtkNormal/1_atk_7.png"));
            attack8 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/AtkNormal/1_atk_7.png"));
            attack9 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/AtkNormal/1_atk_8.png"));
            attack10 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/AtkNormal/1_atk_8.png"));


            specialAttack1 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_1.png"));
            specialAttack2 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_2.png"));
            specialAttack3 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_3.png"));
            specialAttack4 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_4.png"));
            specialAttack5 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_5.png"));
            specialAttack6 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_6.png"));
            specialAttack7 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_7.png"));
            specialAttack8 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_8.png"));
            specialAttack9 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_9.png"));
            specialAttack10 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_10.png"));
            specialAttack11 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_11.png"));
            specialAttack12 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_12.png"));
            specialAttack13 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_13.png"));
            specialAttack14 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_14.png"));
            specialAttack15 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_15.png"));
            specialAttack16 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_16.png"));
            specialAttack17 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_17.png"));
            specialAttack18 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_18.png"));

            specialAttack19 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_19.png"));
            specialAttack20 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_20.png"));
            specialAttack21 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_21.png"));
            specialAttack22 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_22.png"));
            specialAttack23 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_23.png"));
            specialAttack24 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_24.png"));
            specialAttack25 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_25.png"));
            specialAttack26 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_26.png"));
            specialAttack27 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_27.png"));
            specialAttack28 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_28.png"));
            specialAttack29 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_29.png"));
            specialAttack30 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/Especial/sp_atk_30.png"));

            death1 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_1.png"));
            death2 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_4.png"));
            death3 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_5.png"));
            death4 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_7.png"));
            death5 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_8.png"));
            death6 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_10.png"));
            death7 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_11.png"));
            death8 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_12.png"));
            death9 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_13.png"));
            death10 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_14.png"));
            death11 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_15.png"));
            death12 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_16.png"));
            death13 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_17.png"));
            death14 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/death/death_18.png"));

            defesa = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/defesa/defend_1.png"));
            defesa2 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/defesa/defend_2.png"));
            defesa3 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/defesa/defend_3.png"));
            defesa4 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/defesa/defend_4.png"));
            defesa5 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/defesa/defend_5.png"));
            defesa6 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/defesa/defend_5.png"));
            defesa7 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/defesa/defend_5.png"));
            defesa8 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/defesa/defend_6.png"));
            defesa9 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/defesa/defend_7.png"));
            defesa10 = ImageIO.read(getClass().getResourceAsStream("/player/Aeris/combate/defesa/defend_8.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

