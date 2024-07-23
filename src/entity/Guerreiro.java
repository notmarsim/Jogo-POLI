package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Guerreiro extends Entity{
    private GamePanel gp;
    public Guerreiro(GamePanel gp, int startX, int startY){
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        atacando = false;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = 110;
        bounds.y = -30;
        bounds.width = 90;
        bounds.height = 130;
        vida = 100;
        dano = 20;
        xpDrop = 50;
        moedaDrop = 100;
        boss = true;
    }

    private void loadSprites() {
        try {
            // PARADO
            idle = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/idle/idle-with-weapon-1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/idle/idle-with-weapon-2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/idle/idle-with-weapon-3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/idle/idle-with-weapon-4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/idle/idle-with-weapon-5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/idle/idle-with-weapon-6.png"));

            //ATACK
            attack1 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/atack/attack-A1.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/atack/attack-A2.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/atack/attack-A3.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/atack/attack-A4.png"));
            attack5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/atack/attack-A5.png"));
            attack6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/atack/attack-A6.png"));
            attack7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/atack/attack-A7.png"));

            // MORRENDO
            death1 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/morrendo/dead-1.png"));
            death2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/morrendo/dead-2.png"));
            death3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/morrendo/dead-3.png"));
            death4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/morrendo/dead-4.png"));
            death5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/morrendo/dead-5.png"));
            death6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesAr/guerreiro/morrendo/dead-6.png"));

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

        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela*9/2, gp.tamanhoJanela*5/2, null);
        g2.setColor(Color.RED);
        g2.drawRect((int) (x + bounds.x - gp.getCamera().getxOffSet()),
                (int) (y + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);
    }

    @Override
    public void update() {
        if (atacando && !gp.atacando) {
            attackSpriteCounter++;
            if (attackSpriteCounter >= 5) {
                attackSpriteCounter = 0;
                attackSpriteNum++;
            }
            if (attackSpriteNum > 7) {
                attackSpriteNum = 1;
                atacando = false;
            }
        } else if (morrendo && !gp.atacando) {
            deathSpriteCounter++;
            if(deathSpriteCounter>=5){
                deathSpriteCounter = 0;
                deathSpriteNum++;
            }
            if(deathSpriteNum >6){
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
