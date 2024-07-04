package entity;

import Objetos.SuperObject;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    GamePanel gp;
    public int x, y, mana, level;
    protected int vida, dano;
    public int vidaMaxima;
    public int speed;
    public BufferedImage image1, image2, image3, image4, image5, image6, image7;
    public BufferedImage idle, idle2, idle3, idle4, idle5, idle6, idle7, idle8, run, run2, run3, run4, run5, run6, run7, run8, runcostas, runcostas2, runcostas3, runcostas4, runcostas5, runcostas6, runcostas7, runcostas8, idleback, idle2back, idle3back, idle4back, idle5back, idle6back, idle7back, idle8back;
    public String direcao;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public String movimentacao;
    protected Rectangle bounds;
    protected String currentWeapon;
    protected String currentShield;
    private SuperObject superObject;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void update() {
        spriteCounter++;
        if (spriteCounter >= 5) {
            spriteCounter = 0;
            spriteNum++;
            if (spriteNum > 7) {
                spriteNum = 1;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        if (spriteNum == 1) {
            image = image1;
        } else if (spriteNum == 2) {
            image = image2;
        } else if (spriteNum == 3) {
            image = image3;
        } else if (spriteNum == 4) {
            image = image4;
        } else if (spriteNum == 5) {
            image = image5;
        } else if (spriteNum == 6) {
            image = image6;
        } else if (spriteNum == 7) {
            image = image7;
        }
        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela, gp.tamanhoJanela, null);
    }

    public boolean checkEntityColissions(float xOffSet, float yOffSet) {
        for(Entity e : gp.getEntityManager().getEntities()) {
            if(e.equals(this)){
                continue;
            }
            if(e.getBoundsCollision(0f,0f).intersects(getBoundsCollision(xOffSet,yOffSet))) {
                System.out.println("colidiu");
                return true;
            }

        }
        return false;
    }

    public Rectangle getBoundsCollision(float xOffset, float yOffset) {
        return new Rectangle((int)(x+ bounds.x+ xOffset), (int) (y + yOffset + bounds.y ), bounds.width,bounds.height);
    }
}

