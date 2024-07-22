package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Nightborne extends Entity{
    private GamePanel gp;
    public Nightborne(GamePanel gp, int startX, int startY){
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
            idle = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/idle/tile000.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/idle/tile001.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/idle/tile002.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/idle/tile003.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/idle/tile004.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/idle/tile005.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/idle/tile006.png"));
            idle8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/idle/tile007.png"));
            idle9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/idle/tile008.png"));

            // atacando
            attack1 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile046.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile047.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile048.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile049.png"));
            attack5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile050.png"));
            attack6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile051.png"));
            attack7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile052.png"));
            attack8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile053.png"));
            attack9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile054.png"));
            attack10 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile055.png"));
            attack11 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile056.png"));
            attack12 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/atack/tile057.png"));

            //morrendo

            death1 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile092.png"));
            death2 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile093.png"));
            death3 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile094.png"));
            death4 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile095.png"));
            death5 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile096.png"));
            death6 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile097.png"));
            death7 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile098.png"));
            death8 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile099.png"));
            death9 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile100.png"));
            death10 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile101.png"));
            death11 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile102.png"));
            death12 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile103.png"));
            death13 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile104.png"));
            death14 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile105.png"));
            death15 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile106.png"));
            death16 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile107.png"));
            death17 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile108.png"));
            death18 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile109.png"));
            death19 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile110.png"));
            death20 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile111.png"));
            death21 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile112.png"));
            death22 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile113.png"));
            death23 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/nightborne/morrendo/tile114.png"));

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
            }else if (deathSpriteNum == 14) {
                image = death14;
            }else if (deathSpriteNum == 15) {
                image = death15;
            }else if (deathSpriteNum == 16) {
                image = death16;
            }else if (deathSpriteNum == 17) {
                image = death17;
            }else if (deathSpriteNum == 18) {
                image = death18;
            }else if (deathSpriteNum == 19) {
                image = death19;
            }else if (deathSpriteNum == 20) {
                image = death20;
            }else if (deathSpriteNum == 21) {
                image = death21;
            }else if (deathSpriteNum == 22) {
                image = death22;
            }else if (deathSpriteNum == 23) {
                image = death23;
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
            }else if (spriteNum == 9) {
                image = idle9;
            }
        }
        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela * 4, gp.tamanhoJanela * 4, null);

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
            if (attackSpriteNum > 12) {
                attackSpriteNum = 1;
                atacando = false;
            }
        } else if (morrendo && !gp.atacando) {
            deathSpriteCounter++;
            if(deathSpriteCounter>=5){
                deathSpriteCounter = 0;
                deathSpriteNum++;
            }
            if(deathSpriteNum >23){
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
                if (spriteNum > 9) {
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
