package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    GamePanel gp;
    public int x, y, vida, dano, mana, level;
    public int speed;
    public BufferedImage idle,idle2,idle3,idle4,idle5,idle6,idle7,idle8,run,run2,run3,run4,run5,run6,run7,run8,runcostas,runcostas2,runcostas3,runcostas4,runcostas5,runcostas6,runcostas7,runcostas8,idleback,idle2back,idle3back,idle4back,idle5back,idle6back,idle7back,idle8back;
    public String direcao;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public String movimentacao;
    protected Rectangle bounds;
    protected String currentWeapon;
    protected String currentShield;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

}
