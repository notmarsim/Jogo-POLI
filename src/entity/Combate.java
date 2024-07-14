package entity;

import java.util.Random;
import main.GamePanel;

public class Combate {
    private GamePanel gp;
    private Entity inimigo;
    private boolean turnoDoJogador;
    private Random rand = new Random();
    private Player player;
    private int danoInimigo;
    public boolean golpeSimples;
    public boolean golpeEspecial;
    public boolean defendendo;

    public Combate(GamePanel gp, Entity inimigo) {
        this.gp = gp;
        this.player = gp.getPlayer();
        this.inimigo = inimigo;
        this.turnoDoJogador = true;
        this.defendendo  = false;
    }

    public void turnoJogador() {
        if (turnoDoJogador) {
            if (gp.getCombate().golpeSimples) {
                golpeFraco();
            } else if (gp.getCombate().golpeEspecial){
                golpeForte();
            } else if (gp.getCombate().defendendo) {
                System.out.println("DEFENDEU!");
                defender();
            }
        }
    }

    public void turnoInimigo() {
        if (!turnoDoJogador) {
            if (gp.getCombate().defendendo) {
                danoInimigo = inimigo.dano / 2;
                System.out.println("dano com defesa");
            } else {
                danoInimigo = rand.nextInt(5) + inimigo.dano;
                System.out.println("dano sem defesa");
            }
            player.receberDamage(danoInimigo);
            System.out.println("Inimigo atacou e causou " + danoInimigo + " de dano.");
            turnoDoJogador = true;
            gp.getCombate().defendendo = false;
        }
    }

    public void golpeFraco() {
        if (gp.getPlayer().mana >= 3 && !gp.getPlayer().getSpecialAttack()) {
            gp.lutando = true;
            gp.getPlayer().mana -= 3;
            inimigo.receberDamage(gp.getPlayer().getDano() + rand.nextInt(6));
            System.out.println("vida inimigo: " + inimigo.getVida());
            turnoDoJogador = false;
        } else {
            System.out.println("Mana insuficiente para golpe fraco!");
        }
        gp.getCombate().golpeSimples = false;
    }

    public void golpeForte() {
        if (gp.getPlayer().mana >= 7) {
            gp.getPlayer().setSpecialAttack(true);
            gp.lutando = true;
            gp.getPlayer().mana -= 7;
            inimigo.receberDamage((gp.getPlayer().getDano() * 2) + rand.nextInt(6));
            System.out.println("Vida do inimigo: " + inimigo.getVida());
            turnoDoJogador = false;
        } else {
            System.out.println("Mana insuficiente para golpe forte!");
        }
        gp.getCombate().golpeEspecial = false;
    }

    public void defender() {
        if(!gp.getPlayer().getSpecialAttack() && !gp.getCombate().golpeSimples && !gp.getCombate().golpeEspecial) {
            gp.getPlayer().mana += 5;
            if(gp.getPlayer().mana > 10) {
                gp.getPlayer().mana = 10;
            }
            turnoDoJogador = false;
        }
        gp.getCombate().defendendo = false;
    }

    public boolean fimCombate() {
        return player.getVida() <= 0 || inimigo.getVida() <= 0;
    }

    public void update() {
        System.out.println(inimigo.getVida());
        System.out.println(golpeSimples);

        if (fimCombate()) {
            if(inimigo.getVida() <= 0) {
                inimigo.setShouldBeRemoved(true);
                gp.getPlayer().mana = 10;
                gp.getPlayer().ganharXp(15);
//                if (gp.getPlayer().getXp() == gp.getPlayer().getXpMax()){
//                    gp.getPlayer().subirDeLevel();
//                }

            }
            System.out.println("player:" + player.getVida() + "inimigo: " + inimigo.getVida());
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
