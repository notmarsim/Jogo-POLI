package entity;

import java.util.Random;
import main.GamePanel;

public class Combate {
    private GamePanel gp;
    private Entity inimigo;
    private boolean defendendo;
    private boolean turnoDoJogador;
    private Random rand = new Random();
    private Player player;
    private int danoInimigo;
    public boolean golpeSimples;

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
            }
        }
    }

    public void turnoInimigo() {
        if (!turnoDoJogador) {
            if (defendendo) {
                danoInimigo = inimigo.dano / 2;
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
        if (gp.getPlayer().mana >= 5) {
            gp.lutando = true;
            gp.getPlayer().mana -= 5;
            gp.getPlayer().attackSpriteNum = 1; // Reseta o sprite de ataque
            gp.getPlayer().attackSpriteCounter = 0;
            inimigo.receberDamage((gp.getPlayer().getDano() * 2) + rand.nextInt(6));
            System.out.println("Vida do inimigo: " + inimigo.getVida());
            turnoDoJogador = false;
        }
    }

    public void defender() {
        defendendo = true;
        if (gp.getPlayer().mana <= 5) {
            gp.getPlayer().mana += 5;
        } else {
            gp.getPlayer().mana = 10;
        }
        turnoDoJogador = false; // Finaliza o turno do jogador
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
            return;
        }

        if (turnoDoJogador) {
            turnoJogador();
        } else {
            turnoInimigo();
        }
    }
}
