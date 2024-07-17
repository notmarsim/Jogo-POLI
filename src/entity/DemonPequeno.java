package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DemonPequeno extends Entity{
    private GamePanel gp;
    public DemonPequeno(GamePanel gp, int startX, int startY){
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
            idle = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/idle/tile0.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/idle/tile1.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/idle/tile2.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/idle/tile3.png"));

            // atacando
            attack1 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile000.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile001.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile002.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile003.png"));
            attack5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile004.png"));
            attack6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile005.png"));
            attack7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile006.png"));
            attack8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile007.png"));
            attack9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile001.png"));
            attack10 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile002.png"));
            attack11 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile003.png"));
            attack12 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile004.png"));
            attack13 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile005.png"));
            attack14 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile006.png"));
            attack15 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/atack/tile007.png"));



            //morrendo

            death1 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/morrendo/tile000.png"));
            death2 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/morrendo/tile001.png"));
            death3 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/morrendo/tile002.png"));
            death4 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/morrendo/tile003.png"));
            death5 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/morrendo/tile004.png"));
            death6 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/morrendo/tile005.png"));
            death7 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesFogo/demonMini/morrendo/tile006.png"));

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
            } else if (attackSpriteNum == 15) {
                image = attack15;
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
                }
            }else {
            if (spriteNum == 1) {
                image = idle;
            } else if (spriteNum == 2) {
                image = idle;
            } else if (spriteNum == 3) {
                image = idle2;
            } else if (spriteNum == 4) {
                image = idle2;
            } else if (spriteNum == 5) {
                image = idle3;
            } else if (spriteNum == 6) {
                image = idle3;
            } else if (spriteNum == 7) {
                image = idle3;
            }
        }
            g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela * 13 / 10, gp.tamanhoJanela * 13 / 10, null);

/*
        g2.setColor(Color.RED);
        g2.drawRect((int) (x + bounds.x - gp.getCamera().getxOffSet()),
                (int) (y + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);
*/




    }
    @Override
    public void update() {
        if (atacando && !gp.lutando) {
            attackSpriteCounter++;
            if (attackSpriteCounter >= 5) {
                attackSpriteCounter = 0;
                attackSpriteNum++;
            }
            if (attackSpriteNum > 15) {
                attackSpriteNum = 1;
                atacando = false;
            }
        } else if (morrendo && !gp.lutando) {
            deathSpriteCounter++;
            if(deathSpriteCounter>=5){
                deathSpriteCounter = 0;
                deathSpriteNum++;
            }
            if(deathSpriteNum >7){
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
                if (spriteNum > 7) {
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
