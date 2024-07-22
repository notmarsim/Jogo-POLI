package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Bringer extends Entity{
    private GamePanel gp;
    public Bringer(GamePanel gp, int startX, int startY){
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        atacando = false;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -60;
        bounds.y = -70;
        bounds.width = 80;
        bounds.height = 100;

        vida = 40;
        dano = 10;
        xpDrop = 10;
        moedaDrop = 15;
    }

    private void loadSprites() {
        try {
            //idle
            idle = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/idle/Bringer-of-Death_Idle_1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/idle/Bringer-of-Death_Idle_2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/idle/Bringer-of-Death_Idle_3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/idle/Bringer-of-Death_Idle_4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/idle/Bringer-of-Death_Idle_5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/idle/Bringer-of-Death_Idle_6.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/idle/Bringer-of-Death_Idle_7.png"));
            idle8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/idle/Bringer-of-Death_Idle_8.png"));

            // atacando
            attack1 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/atack/Bringer-of-Death_Attack_1.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/atack/Bringer-of-Death_Attack_2.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/atack/Bringer-of-Death_Attack_3.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/atack/Bringer-of-Death_Attack_4.png"));
            attack5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/atack/Bringer-of-Death_Attack_5.png"));
            attack6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/atack/Bringer-of-Death_Attack_6.png"));
            attack7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/atack/Bringer-of-Death_Attack_7.png"));
            attack8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/atack/Bringer-of-Death_Attack_8.png"));
            attack9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/atack/Bringer-of-Death_Attack_9.png"));
            attack10 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/atack/Bringer-of-Death_Attack_10.png"));

            //morrendo

            death1 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/morrendo/Bringer-of-Death_Death_1.png"));
            death2 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/morrendo/Bringer-of-Death_Death_2.png"));
            death3 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/morrendo/Bringer-of-Death_Death_3.png"));
            death4 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/morrendo/Bringer-of-Death_Death_4.png"));
            death5 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/morrendo/Bringer-of-Death_Death_5.png"));
            death6 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/morrendo/Bringer-of-Death_Death_6.png"));
            death7 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/morrendo/Bringer-of-Death_Death_7.png"));
            death8 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/morrendo/Bringer-of-Death_Death_8.png"));
            death9 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/morrendo/Bringer-of-Death_Death_9.png"));
            death10 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/bringerOfDeath/morrendo/Bringer-of-Death_Death_10.png"));

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
            }
        }
        else if (morrendo) {
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
            }else if (deathSpriteNum == 8) {
                image = death8;
            }else if (deathSpriteNum == 9) {
                image = death9;
            }else if (deathSpriteNum == 10) {
                image = death10;
            }
        }else {
            if (spriteNum == 1) {
                image = idle;
            } else if (spriteNum == 2) {
                image = idle2;
            } else if (spriteNum == 3) {
                image = idle3;
            } else if (spriteNum == 4) {
                image = idle4;
            }else if (spriteNum == 5) {
                image = idle5;
            }else if (spriteNum == 6) {
                image = idle6;
            }else if (spriteNum == 7) {
                image = idle7;
            }else if (spriteNum == 8) {
                image = idle8;
            }
        }
        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela * 23/10, gp.tamanhoJanela * 2, null);

/*
        g2.setColor(Color.RED);
        g2.drawRect((int) (x + bounds.x - gp.getCamera().getxOffSet()),
                (int) (y + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);
*/




    }
    @Override
    public void update() {
        if (atacando && !gp.atacando) {
            attackSpriteCounter++;
            if (attackSpriteCounter >= 5) {
                attackSpriteCounter = 0;
                attackSpriteNum++;
            }
            if (attackSpriteNum > 10) {
                attackSpriteNum = 1;
                atacando = false;
            }
        } else if (morrendo && !gp.atacando) {
            deathSpriteCounter++;
            if(deathSpriteCounter>=5){
                deathSpriteCounter = 0;
                deathSpriteNum++;
            }
            if(deathSpriteNum >10){
                deathSpriteNum = 1;
                morrendo = false;
                morto = true;
                setShouldBeRemoved(true);
                gp.stopMusic();
            }
        } else {
            spriteCounter++;
            if (spriteCounter >= 5) {
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
