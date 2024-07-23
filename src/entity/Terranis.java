package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Terranis extends Player{

    public Terranis(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        loadSprites();
        speed = 8;
        bounds.y = -40;
        bounds.x = -30;
        bounds.width = 50;
        bounds.height = 80;
    }


    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_6.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_6.png"));
            idle8 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_6.png"));


            idleback = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_1back.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_2back.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_3back.png"));
            idle4back = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_4back.png"));
            idle5back = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_5back.png"));
            idle6back = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_6back.png"));
            idle7back = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_6back.png"));
            idle7back = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/idle/idle_6back.png"));


            run = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_1.png"));
            run2 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_2.png"));
            run3 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_3.png"));
            run4 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_4.png"));
            run5 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_5.png"));
            run6 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_6.png"));
            run7 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_7.png"));
            run8 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_8.png"));

            runcostas = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_1back.png"));
            runcostas2 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_2back.png"));
            runcostas3 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_3back.png"));
            runcostas4 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_4back.png"));
            runcostas5 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_5back.png"));
            runcostas6 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_6back.png"));
            runcostas7 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_7back.png"));
            runcostas8 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/run/run_8back.png"));

            attack1 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/AtkNormal/2_atk_1.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/AtkNormal/2_atk_2.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/AtkNormal/2_atk_3.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/AtkNormal/2_atk_4.png"));
            attack5 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/AtkNormal/2_atk_5.png"));
            attack6 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/AtkNormal/2_atk_6.png"));
            attack7 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/AtkNormal/2_atk_7.png"));
            attack8 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/AtkNormal/2_atk_8.png"));
            attack9 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/AtkNormal/2_atk_9.png"));
            attack10 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/AtkNormal/2_atk_10.png"));


            specialAttack1 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_1.png"));
            specialAttack2 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_2.png"));
            specialAttack3 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_3.png"));
            specialAttack4 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_4.png"));
            specialAttack5 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_5.png"));
            specialAttack6 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_6.png"));
            specialAttack7 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_7.png"));
            specialAttack8 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_8.png"));
            specialAttack9 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_9.png"));
            specialAttack10 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_10.png"));
            specialAttack11 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_11.png"));
            specialAttack12 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_12.png"));
            specialAttack13 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_13.png"));
            specialAttack14 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_14.png"));
            specialAttack15 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_15.png"));
            specialAttack16 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_16.png"));
            specialAttack17 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_17.png"));
            specialAttack18 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/Especial/sp_atk_18.png"));


            defesa = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/defesa/defend_1.png"));
            defesa2 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/defesa/defend_2.png"));
            defesa3 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/defesa/defend_3.png"));
            defesa4 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/defesa/defend_4.png"));
            defesa5 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/defesa/defend_5.png"));
            defesa6 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/defesa/defend_6.png"));
            defesa7 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/defesa/defend_7.png"));
            defesa8 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/defesa/defend_8.png"));
            defesa9 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/defesa/defend_9.png"));
            defesa10 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/combate/defesa/defend_10.png"));

            death1 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_2.png"));
            death2 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_3.png"));
            death3 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_4.png"));
            death4 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_5.png"));
            death5 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_6.png"));
            death6 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_7.png"));
            death7 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_8.png"));
            death8 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_9.png"));
            death9 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_10.png"));
            death10 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_11.png"));
            death11 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_12.png"));
            death12 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_13.png"));
            death13 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_14.png"));
            death14 = ImageIO.read(getClass().getResourceAsStream("/player/Terranis/death/death_15.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
