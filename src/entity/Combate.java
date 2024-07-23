package entity;

import java.util.Random;
import main.GamePanel;

public class Combate {
    private GamePanel gp;
    private Entity inimigo;
    public boolean turnoDoJogador;
    private Random rand = new Random();
    private Player player;
    private int danoInimigo;
    public boolean golpeSimples;
    public boolean golpeEspecial;
    public boolean defendendo;
    public boolean bossMorto;
    public int dano;

    public Combate(GamePanel gp, Entity inimigo) {
        this.gp = gp;
        this.player = gp.getPlayer();
        this.inimigo = inimigo;
        this.turnoDoJogador = true;
        this.bossMorto = false;
    }

    public void turnoJogador() {
        if (turnoDoJogador ) {
            gp.getPlayer().variacaoAtaque();
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
            inimigo.variacaoAtaque();
            if (gp.defendendo) {
                danoInimigo = inimigo.dano / 2;
                System.out.println("dano com defesa");
            } else {
                danoInimigo = rand.nextInt(5) + inimigo.dano;
                System.out.println("dano sem defesa");
            }
            inimigo.atacando = true;
            player.receberDamage(danoInimigo);
            System.out.println("Inimigo atacou e causou " + danoInimigo + " de dano.");
            turnoDoJogador = true;

        }
    }

    public void golpeFraco() {
        if (gp.getPlayer().mana >= 3 && !gp.getPlayer().getSpecialAttack() && !inimigo.atacando) {
            gp.atacando = true;
            gp.getPlayer().mana -= 3;
            dano = gp.getPlayer().getDano() + rand.nextInt(6);
            gp.getUi().addMensagem("Você deu "+dano+" de dano!");
            inimigo.receberDamage(dano);
            System.out.println("vida inimigo: " + inimigo.getVida());
            turnoDoJogador = false;
        } else {
            System.out.println("Mana insuficiente para golpe fraco!");
        }
        gp.getCombate().golpeSimples = false;
    }

    public void golpeForte() {
        if (gp.getPlayer().mana >= 7 && !inimigo.atacando) {
            gp.getPlayer().setSpecialAttack(true);
            gp.atacando = true;
            gp.getPlayer().mana -= 7;
            dano = (gp.getPlayer().getDano() * 2) + rand.nextInt(6);
            inimigo.receberDamage(dano);
            gp.getUi().addMensagem("Você deu "+dano+" de dano!");
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
            gp.defendendo = true;
            if(gp.getPlayer().mana > gp.getPlayer().manaMax) {
                gp.getPlayer().mana = gp.getPlayer().manaMax;
            }
            turnoDoJogador = false;
        }
        gp.getCombate().defendendo = false;
    }

    public boolean fimCombate() {
        return player.getVida() <= 0 || inimigo.getVida() <= 0;
    }

    public void update() {
        System.out.println(inimigo.atacando+"atacando do combate");
        if (fimCombate()) {



            if(inimigo.getVida() <= 0) {
                inimigo.morrendo = true;
            } else if (player.getVida()<=0 && !inimigo.atacando){
                gp.setCharacterState(GamePanel.CharacterState.Morto);
                gp.stopMusic();
            }
            System.out.println("player:" + player.getVida() + "inimigo: " + inimigo.getVida());
            if(inimigo.morto){
                gp.getUi().addMensagem("Você matou o "+inimigo.getClass().getSimpleName()+ " !");
                gp.setCharacterState(GamePanel.CharacterState.Ocioso);
                gp.getPlayer().ganharXp(inimigo.xpDrop);

                gp.getPlayer().ganharMoeda(inimigo.moedaDrop);
                if(inimigo.boss){
                    gp.getCombate().bossMorto = true;
                    System.out.println("inimigo morto: "+ bossMorto);
                    gp.stopMusic();
                }
                //gp.stopMusic();
                //gp.playMusic(1);
            }
            //gp.setCharacterState(GamePanel.CharacterState.Ocioso);
            System.out.println("Combate terminado com: " + inimigo);

            return;
        }

        if (turnoDoJogador) {
            turnoJogador();
        } else {
            turnoInimigo();
        }
    }
}
