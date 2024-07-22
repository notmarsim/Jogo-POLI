package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Esqueleto extends Entity{
    private GamePanel gp;
    public Esqueleto(GamePanel gp, int startX, int startY){
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
            idle = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/idle/tile039.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/idle/tile040.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/idle/tile041.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/idle/tile042.png"));

            // atacando
            attack1 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile000.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile001.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile002.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile003.png"));
            attack5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile004.png"));
            attack6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile005.png"));
            attack7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile006.png"));
            attack8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile007.png"));
            attack9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile008.png"));
            attack10 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile009.png"));
            attack11 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile010.png"));
            attack12 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile011.png"));
            attack13 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/atack/tile012.png"));


            //morrendo

            death1 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile013.png"));
            death2 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile014.png"));
            death3 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile015.png"));
            death4 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile016.png"));
            death5 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile017.png"));
            death6 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile018.png"));
            death7 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile019.png"));
            death8 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile020.png"));
            death9 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile021.png"));
            death10 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile022.png"));
            death11 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile023.png"));
            death12 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile024.png"));
            death13 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesTerra/esqueleto/morrendo/tile025.png"));

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
            }else if (deathSpriteNum == 11) {
                image = death11;
            }else if (deathSpriteNum == 12) {
                image = death12;
            }else if (deathSpriteNum == 13) {
                image = death13;
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
            }
        }
        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela * 2, gp.tamanhoJanela * 2, null);

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
            if (attackSpriteNum > 13) {
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
            if (spriteCounter >= 5) {
                spriteCounter = 0;
                spriteNum++;
                if (spriteNum > 4) {
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
