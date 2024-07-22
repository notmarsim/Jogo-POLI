package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
public class FinalBoss extends Entity{
    private GamePanel gp;
    private Random rand = new Random();


    public FinalBoss(GamePanel gp, int startX, int startY){
        super(gp);
        this.gp = gp;
        this.x = startX;
        this.y = startY;
        atacando = false;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = 450;
        bounds.y = 250;
        bounds.width = 400;
        bounds.height = 400;
        vida = 500;
        dano = 5;
        xpDrop = 9999;
        moedaDrop = 9999;
        boss = true;

    }

    private void loadSprites() {
        try {
            // PARADO
            idle = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_1.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_4.png"));
            idle5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_5.png"));
            idle6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_6.png"));
            idle7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_7.png"));
            idle8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_8.png"));
            idle9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_9.png"));
            idle10 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_10.png"));
            idle11 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_11.png"));
            idle12 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_12.png"));
            idle13 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_13.png"));
            idle14 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_14.png"));
            idle15 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/idle/idle_15.png"));

            //ATACK
            attack1 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/2atk_1.png"));
            attack2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/2atk_2.png"));
            attack3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/2atk_3.png"));
            attack4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/2atk_4.png"));
            attack5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/2atk_5.png"));
            attack6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/2atk_6.png"));
            attack7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/2atk_7.png"));
            attack8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/2atk_8.png"));
            attack9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/2atk_9.png"));


            // MORRENDO
            death1 =  ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/morrendo/death_1.png"));
            death2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/morrendo/death_2.png"));
            death3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/morrendo/death_3.png"));
            death4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/morrendo/death_4.png"));
            death5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/morrendo/death_5.png"));
            death6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/morrendo/death_6.png"));
            death7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/morrendo/death_7.png"));
            death8 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/morrendo/death_8.png"));
            death9 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/morrendo/death_9.png"));
            death10 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/morrendo/death_10.png"));
            death11 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/morrendo/death_11.png"));

            attackVar2_1 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/1atk_1.png"));
            attackVar2_2 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/1atk_2.png"));
            attackVar2_3 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/1atk_3.png"));
            attackVar2_4 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/1atk_4.png"));
            attackVar2_5 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/1atk_5.png"));
            attackVar2_6 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/1atk_6.png"));
            attackVar2_7 = ImageIO.read(getClass().getResourceAsStream("/viloes/viloesVoid/final/atack/1atk_7.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void variacaoAtaque() {
        atacando = true;
        variacaoDeAtaque = 1 + rand.nextInt(2);
    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        if (atacando) {
            if (variacaoDeAtaque == 2) {
                if (attackSpriteNum == 1) {
                    image = attackVar2_1;
                } else if (attackSpriteNum == 2) {
                    image = attackVar2_2;
                } else if (attackSpriteNum == 3) {
                    image = attackVar2_3;
                } else if (attackSpriteNum == 4) {
                    image = attackVar2_4;
                } else if (attackSpriteNum == 5) {
                    image = attackVar2_5;
                } else if (attackSpriteNum == 6) {
                    image = attackVar2_6;
                } else if (attackSpriteNum == 7) {
                    image = attackVar2_7;
                }
            } else {
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
                }
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
                image = idle6;
            } else if (spriteNum == 7) {
                image = idle7;
            } else if (spriteNum == 8) {
                image = idle8;
            } else if (spriteNum == 9) {
                image = idle9;
            } else if (spriteNum == 10) {
                image = idle10;
            } else if (spriteNum == 11) {
                image = idle11;
            } else if (spriteNum == 12) {
                image = idle12;
            } else if (spriteNum == 13) {
                image = idle13;
            } else if (spriteNum == 14) {
                image = idle14;
            } else if (spriteNum == 15) {
                image = idle15;
            }
        }


        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela * 18, gp.tamanhoJanela * 10, null);
        g2.setColor(Color.RED);
        g2.drawRect((int) (x + bounds.x - gp.getCamera().getxOffSet()),
                (int) (y + bounds.y - gp.getCamera().getyOffSet()),
                bounds.width, bounds.height);


    }


    @Override
    public void update() {
        if (atacando && !gp.lutando) {
            attackSpriteCounter++;
            if (attackSpriteCounter >= 6) {
                attackSpriteCounter = 0;
                attackSpriteNum++;
            }
            if (variacaoDeAtaque == 1 && attackSpriteNum > 9) {
                attackSpriteNum = 1;
                atacando = false;
            } else if (variacaoDeAtaque == 2 && attackSpriteNum > 7) {
                attackSpriteNum = 1;
                atacando = false;
            }
        } else if (morrendo && !gp.lutando) {
            deathSpriteCounter++;
            if (deathSpriteCounter >= 5) {
                deathSpriteCounter = 0;
                deathSpriteNum++;
            }
            if (deathSpriteNum > 11) {
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
                if (spriteNum > 15) {
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
