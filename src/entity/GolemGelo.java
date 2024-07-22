package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GolemGelo extends Entity{
    private GamePanel gp;
    public GolemGelo(GamePanel gp, int startX, int startY){
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        atacando = false;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = 220;
        bounds.y = 120;
        bounds.width = 160;
        bounds.height = 170;
        vida = 200;
        dano = 40;
        xpDrop = 100;
        moedaDrop = 200;
        boss = true;
    }

    private void loadSprites() {
        try {
            // PARADO
            idle = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/idle/idle_1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/idle/idle_2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/idle/idle_3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/idle/idle_4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/idle/idle_5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/idle/idle_6.png"));

            //ATACK
            attack1 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_1.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_2.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_3.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_4.png"));
            attack5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_5.png"));
            attack6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_6.png"));
            attack7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_7.png"));
            attack8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_8.png"));
            attack9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_9.png"));
            attack10 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_10.png"));
            attack11 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_11.png"));
            attack12 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_12.png"));
            attack13 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_13.png"));
            attack14 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/atack/1_atk_14.png"));

            // MORRENDO
            death1 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_1.png"));
            death2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_2.png"));
            death3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_3.png"));
            death4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_4.png"));
            death5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_5.png"));
            death6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_6.png"));
            death7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_7.png"));
            death8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_8.png"));
            death9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_9.png"));
            death10 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_10.png"));
            death11 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_11.png"));
            death12 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_12.png"));
            death13 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_13.png"));
            death14 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_14.png"));
            death15 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_15.png"));
            death16 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesGelo/golemGelo/morrendo/death_16.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        if (atacando) {
            if (attackSpriteNum == 1) {
                image = attack1;
            } else if (attackSpriteNum == 2) {
                image = attack2;
            } else if (attackSpriteNum == 3) {
                image = attack3;
            } else if (attackSpriteNum == 4) {
                image = attack4;
            } else if (attackSpriteNum == 5) {
                image = attack5;
            } else if (attackSpriteNum == 6) {
                image = attack6;
            } else if (attackSpriteNum == 7) {
                image = attack7;
            } else if (attackSpriteNum == 8) {
                image = attack8;
            } else if (attackSpriteNum == 9) {
                image = attack9;
            } else if (attackSpriteNum == 10) {
                image = attack10;
            } else if (attackSpriteNum == 11) {
                image = attack11;
            } else if (attackSpriteNum == 12) {
                image = attack12;
            } else if (attackSpriteNum == 13) {
                image = attack13;
            } else if (attackSpriteNum == 14) {
                image = attack14;
            }
        } else if (morrendo) {
            if (deathSpriteNum == 1) {
                image = death1;
            } else if (deathSpriteNum == 2) {
                image = death2;
            } else if (deathSpriteNum == 3) {
                image = death3;
            } else if (deathSpriteNum == 4) {
                image = death4;
            } else if (deathSpriteNum == 5) {
                image = death5;
            } else if (deathSpriteNum == 6) {
                image = death6;
            } else if (deathSpriteNum == 7) {
                image = death7;
            } else if (deathSpriteNum == 8) {
                image = death8;
            } else if (deathSpriteNum == 9) {
                image = death9;
            } else if (deathSpriteNum == 10) {
                image = death10;
            } else if (deathSpriteNum == 11) {
                image = death11;
            } else if (deathSpriteNum == 12) {
                image = death12;
            } else if (deathSpriteNum == 13) {
                image = death13;
            } else if (deathSpriteNum == 14) {
                image = death14;
            } else if (deathSpriteNum == 15) {
                image = death15;
            } else if (deathSpriteNum == 16) {
                image = death16;
            } else if (deathSpriteNum == 17) {
                image = death17;
            } else if (deathSpriteNum == 18) {
                image = death18;

            }
        } else {
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
            } else if (spriteNum == 8){
                image = idle6;
            }
        }

        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela*9, gp.tamanhoJanela*5, null);

    }

    @Override
    public void update() {
        if (atacando && !gp.atacando) {
            attackSpriteCounter++;
            if (attackSpriteCounter >= 5) {
                attackSpriteCounter = 0;
                attackSpriteNum++;
            }
            if (attackSpriteNum > 14) {
                attackSpriteNum = 1;
                atacando = false;
            }
        } else if (morrendo && !gp.atacando) {
            deathSpriteCounter++;
            if(deathSpriteCounter>=5){
                deathSpriteCounter = 0;
                deathSpriteNum++;
            }
            if(deathSpriteNum >18){
                deathSpriteNum = 1;
                morrendo = false;
                morto = true;
                setShouldBeRemoved(true);
                gp.stopMusic();
            }
        } else {
            spriteCounter++;
            if (spriteCounter >= 6) {
                spriteCounter = 0;
                spriteNum++;
                if (spriteNum > 8) {
                    spriteNum = 1;
                }
            }
        }
    }



    public int getVida(){
        return vida;
    }
    public int tipo() {
        return 3;
    }

}
