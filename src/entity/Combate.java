package entity;
import java.util.Random;

import main.GamePanel;
import UI.UI;
import java.util.Scanner;

public class Combate {
    private final Player player;
    private GamePanel gp;
    private int vidaInimigo;
    private boolean defendendo;
    private boolean jaCombateu;
    Random rand = new Random();

    public Combate(GamePanel gp, int vida, int dano) {
        this.gp = gp;
        this.player = gp.getPlayer();
        this.vidaInimigo = 20;
        this.defendendo = false;
        this.jaCombateu = false;
    }

    public void golpeFraco(Entity e){

        e.vida -= player.getDano() + rand.nextInt(6); // 6 exclusivo
    }

    public void golpeForte(Entity e){

        e.vida -= player.getDano()*2 + rand.nextInt(6);
    }

}
