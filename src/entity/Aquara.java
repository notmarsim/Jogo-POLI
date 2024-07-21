package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Aquara extends Player {

    public Aquara(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        loadSprites();
        speed = 6;
        bounds.y = -40;
        bounds.x = -30;
        bounds.width = 50;
        bounds.height = 80;
    }


    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_6.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_7.png"));
            idle8 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_8.png"));

            idleback = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_1back.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_2back.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_3back.png"));
            idle4back = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_4back.png"));
            idle5back = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_5back.png"));
            idle6back = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_6back.png"));
            idle7back = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_7back.png"));
            idle8back = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/idle/idle_8back.png"));

            run = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_1.png"));
            run2 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_2.png"));
            run3 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_3.png"));
            run4 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_4.png"));
            run5 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_5.png"));
            run6 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_6.png"));
            run7 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_7.png"));
            run8 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_8.png"));

            runcostas = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_back1.png"));
            runcostas2 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_back2.png"));
            runcostas3 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_back3.png"));
            runcostas4 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_back4.png"));
            runcostas5 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_back5.png"));
            runcostas6 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_back6.png"));
            runcostas7 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_back7.png"));
            runcostas8 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/run/surf_back8.png"));

            attack1 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/AtkNormal/1_atk_1.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/AtkNormal/1_atk_2.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/AtkNormal/1_atk_3.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/AtkNormal/1_atk_4.png"));
            attack5 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/AtkNormal/1_atk_4.png"));
            attack6 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/AtkNormal/1_atk_5.png"));
            attack7 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/AtkNormal/1_atk_5.png"));
            attack8 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/AtkNormal/1_atk_6.png"));
            attack9 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/AtkNormal/1_atk_6.png"));
            attack10 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/AtkNormal/1_atk_7.png"));


            specialAttack1 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_1.png"));
            specialAttack2 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_2.png"));
            specialAttack3 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_3.png"));
            specialAttack4 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_4.png"));
            specialAttack5 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_5.png"));
            specialAttack6 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_6.png"));
            specialAttack7 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_7.png"));
            specialAttack8 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_8.png"));
            specialAttack9 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_9.png"));
            specialAttack10 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_10.png"));
            specialAttack11 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_11.png"));
            specialAttack12 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_12.png"));
            specialAttack13 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_13.png"));
            specialAttack14 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_14.png"));
            specialAttack15 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_15.png"));
            specialAttack16 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_16.png"));
            specialAttack17 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_17.png"));
            specialAttack18 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_18.png"));

            specialAttack19 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_19.png"));
            specialAttack20 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_20.png"));
            specialAttack21 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_21.png"));
            specialAttack22 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_22.png"));
            specialAttack23 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_23.png"));
            specialAttack24 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_24.png"));
            specialAttack25 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_25.png"));
            specialAttack26 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_26.png"));
            specialAttack27 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_27.png"));
            specialAttack28 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_28.png"));
            specialAttack29 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_29.png"));
            specialAttack30 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_30.png"));
            specialAttack31 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_31.png"));
            specialAttack32 = ImageIO.read(getClass().getResourceAsStream("/player/Aquara/combate/Especial/sp_atk_32.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
