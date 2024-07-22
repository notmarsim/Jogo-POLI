package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GolemTerra extends Entity{
    private GamePanel gp;
    public GolemTerra(GamePanel gp, int startX, int startY){
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
        vida = 100;
        dano = 20;
        xpDrop = 50;
        moedaDrop = 100;
        boss = true;
    }

    private void loadSprites() {
        try {
            // PARADO
            idle = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/idle/tile007.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/idle/tile006.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/idle/tile005.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/idle/tile005.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/idle/tile004.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/idle/tile002.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/idle/tile001.png"));
            idle8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/idle/tile000.png"));
            //ATACK
            attack1 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/atack/tile010.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/atack/tile009.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/atack/tile008.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/atack/tile007.png"));
            attack5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/atack/tile006.png"));
            attack6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/atack/tile005.png"));
            attack7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/atack/tile004.png"));
            attack8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/atack/tile003.png"));
            attack9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/atack/tile002.png"));
            attack10 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/atack/tile001.png"));
            attack11 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/atack/tile000.png"));

            // MORRENDO
            death1 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile012.png"));
            death2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile011.png"));
            death3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile010.png"));
            death4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile009.png"));
            death5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile008.png"));
            death6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile007.png"));
            death7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile006.png"));
            death8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile005.png"));
            death9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile004.png"));
            death10 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile003.png"));
            death11 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile002.png"));
            death12 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile001.png"));
            death13 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/golem/morrendo/tile000.png"));


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
            }
        } else {
            if (spriteNum == 1) {
                image = idle;
            } else if (spriteNum == 2) {
                image = idle2;
            } else if (spriteNum == 3) {
                image = idle3;
            } else if (spriteNum == 4) {
                image = idle4;
            } else if (spriteNum == 5) {
                image = idle5;
            } else if (spriteNum == 6) {
                image = idle6;
            } else if (spriteNum == 7) {
                image = idle7;
            } else if (spriteNum == 8){
                image = idle8;
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
            if (attackSpriteNum > 11) {
                attackSpriteNum = 1;
                atacando = false;
            }
        } else if (morrendo && !gp.atacando) {
            deathSpriteCounter++;
            if(deathSpriteCounter>=5){
                deathSpriteCounter = 0;
                deathSpriteNum++;
            }
            if(deathSpriteNum >13){
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
