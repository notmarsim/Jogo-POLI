package entity;

import java.util.Random;
import main.GamePanel;
import main.KeyHandler;

public class Combate {
    private GamePanel gp;
    private int vidaInimigo;
    private boolean defendendo;
    private boolean jaCombateu;
    Random rand = new Random();
    private Player player;



    public Combate(GamePanel gp, int vida, int dano) {
        this.gp = gp;
        this.vidaInimigo = 20;
        this.defendendo = false;
        this.jaCombateu = false;

    }

    public void golpeFraco() {
        if(gp.getMana() >=3){
            // e.vida -= gp.getPlayer().getDano() + rand.nextInt(6); // 6 exclusivo
            gp.attacking = true;
            gp.getPlayer().mana -= 3;
            gp.getPlayer().attackSpriteNum = 1; // Reseta o sprite de ataque
            gp.getPlayer().attackSpriteCounter = 0;
        }

    }

    public void golpeForte(Entity e) {
        //e.vida -= gp.getPlayer().getDano() * 2 + rand.nextInt(6);
    }

    public void defender(){
        if(gp.getPlayer().mana<=5){
            gp.getPlayer().mana += 5;
        } else {
            gp.getPlayer().mana = 10;
        }
    }
}
