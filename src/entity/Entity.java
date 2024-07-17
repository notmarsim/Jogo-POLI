package entity;

import Objetos.SuperObject;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    GamePanel gp;
    public int x, y,level;
    protected int vida, dano;
    public int vidaMaxima;
    public int speed;
    public boolean atacando;
    public boolean morrendo;
    public boolean morto;

    // sprites
    public BufferedImage image1, image2, image3, image4, image5, image6, image7;
    public BufferedImage death1, death2, death3, death4, death5, death6, death7, death8, death9,death10, death11, death12, death13, death14, death15, death16, death17, death18;
    public BufferedImage attack1, attack2, attack3, attack4, attack5, attack6, attack7,attack8,attack9,attack10,attack11,attack12,attack13,attack14,attack15;
    public BufferedImage idle, idle2, idle3, idle4, idle5, idle6, idle7, idle8, run, run2, run3, run4, run5, run6, run7, run8, runcostas, runcostas2, runcostas3, runcostas4, runcostas5, runcostas6, runcostas7, runcostas8, idleback, idle2back, idle3back, idle4back, idle5back, idle6back, idle7back, idle8back;
    protected BufferedImage specialAttack1,specialAttack2,specialAttack3,specialAttack4,specialAttack5,specialAttack6,specialAttack7,specialAttack8,specialAttack9,specialAttack10,specialAttack11,specialAttack12,specialAttack13,specialAttack14,specialAttack15,specialAttack16,specialAttack17,specialAttack18;
    public String direcao;

    // sprites counters
    public int deathSpriteCounter = 0;
    public int deathSpriteNum = 1;
    public int attackSpriteCounter = 0;
    public int attackSpriteNum = 1;
    public int spriteCounter = 0;
    public int spriteNum = 1;


    public String movimentacao;
    protected Rectangle bounds;
    protected String currentWeapon;
    protected String currentShield;
    private SuperObject superObject;
    private boolean shouldBeRemoved;
    public boolean recebeuDano;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void update() {
        if(morrendo){
            morto = true;
            setShouldBeRemoved(true);
            gp.stopMusic();
        }
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

    public Entity checkEntityColissions(float xOffSet, float yOffSet) { // tipo Entity

        for(Entity e : gp.getEntityManager().getEntities()) {

            if(e.equals(this)){
                continue;
            }

                if (e.getBoundsCollision(0f, 0f).intersects(getBoundsCollision(xOffSet, yOffSet))) {
                    System.out.println("colidiu com " + e.getClass().getSimpleName());
                    return e; // retornar e
                }
            }

        return null;
    }

    public Rectangle getBoundsCollision(float xOffset, float yOffset) {
        return new Rectangle((int)(x+ bounds.x+ xOffset), (int) (y + yOffset + bounds.y ), bounds.width,bounds.height);
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public int getHeightBounds() {
        return bounds.height;
    }

    public abstract int tipo(); // 1 para colisao normal , 2 para npcs com dialogo e 3 para viloes com combate

    protected String getFala(){
        return "";
    }
    
    public int getVida(){
        return vida;
    }

    public void receberDamage(int i) {
        if(vida>=i) {
            vida-=i;
        } else {
            vida = 0;
        }
    }
    public boolean shouldBeRemoved() {
        return shouldBeRemoved;
    }

    public void setShouldBeRemoved(boolean shouldBeRemoved) {
        this.shouldBeRemoved = shouldBeRemoved;
    }
}
