package entity;

import java.util.Random;
import main.GamePanel;

public class Combate {
    private GamePanel gp;
    private Entity inimigo;
    public boolean defendendo;
    private boolean turnoDoJogador;
    private Random rand = new Random();
    private Player player;
    private int danoInimigo;
    public boolean golpeSimples;
    public boolean golpeEspecial;

    public Combate(GamePanel gp, Entity inimigo) {
        this.gp = gp;
        this.player = gp.getPlayer();
        this.inimigo = inimigo;
        this.defendendo = false;
        this.turnoDoJogador = true;
    }

    public void turnoJogador() {
        if (turnoDoJogador) {
            if (gp.getCombate().golpeSimples) {
                golpeFraco();
            } else if (gp.getCombate().golpeEspecial){
                golpeForte();
            } else if (gp.getCombate().defendendo) {
                defender();
            }
        }
    }

    public void turnoInimigo() {
        if (!turnoDoJogador) {
            if (defendendo) {
                danoInimigo = inimigo.dano;
            } else {
                danoInimigo = rand.nextInt(5) + inimigo.dano;
            }
            player.receberDamage(danoInimigo);
            System.out.println("Inimigo atacou e causou " + danoInimigo + " de dano.");
            turnoDoJogador = true;
            defendendo = false;
        }
    }

    public void golpeFraco() {
        if (gp.getPlayer().mana >= 3) {
            gp.lutando = true;
            gp.getPlayer().mana -= 3;
            inimigo.receberDamage(gp.getPlayer().getDano() + rand.nextInt(6));
            System.out.println("vida inimigo: " + inimigo.getVida());
            turnoDoJogador = false;
            gp.getCombate().golpeSimples = false;
        }
    }

    public void golpeForte() {
        if (gp.getPlayer().mana >= 7) {
            gp.lutando = true;
            gp.getPlayer().mana -= 7;
            inimigo.receberDamage((gp.getPlayer().getDano() * 2) + rand.nextInt(6));
            System.out.println("Vida do inimigo: " + inimigo.getVida());
            turnoDoJogador = false;
            gp.getCombate().golpeEspecial = false;
        }
    }

    public void defender() {
        defendendo = true;
        if (gp.getPlayer().mana <= 5) {
            gp.getPlayer().mana += 5;
        } else {
            gp.getPlayer().mana = 10;
        }
        turnoDoJogador = false;
        gp.getCombate().defendendo = false;
    }

    public boolean fimCombate() {
        return player.getVida() <= 0 || inimigo.getVida() <= 0;
    }

    public void update() {
        System.out.println(inimigo.getVida());
        System.out.println(golpeSimples);
        if (fimCombate()) {
            System.out.println("eu:" + player.getVida() + "inimigo: " + inimigo.getVida());
            gp.setCharacterState(GamePanel.CharacterState.Ocioso);
            System.out.println("Combate terminado com: " + inimigo);
            gp.stopMusic();
            if(inimigo.getVida()<=0){
                gp.getEntityManager().getEntities().remove(inimigo);
            }
            return;
        }

        if (turnoDoJogador) {
            turnoJogador();
        } else {
            turnoInimigo();
        }
    }
}