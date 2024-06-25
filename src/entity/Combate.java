package entity;

import main.GamePanel;

import java.util.Scanner;

public class Combate {
    private final Player player;
    private GamePanel gp;
    private int vidaInimigo;
    private boolean defendendo;
    private boolean jaCombateu;

    public Combate(GamePanel gp, int vida, int dano) {
        this.gp = gp;
        this.player = gp.getPlayer();
        this.vidaInimigo = 20;
        this.defendendo = false;
        this.jaCombateu = false;
    }

    public void iniciarTurnoCombate(int dano) {
        if(!jaCombateu) {
            System.out.println("Combate iniciado!");

            boolean turnoDoPersonagem = true;
            Scanner scanner = new Scanner(System.in);

            while (player.getVida() > 0 && vidaInimigo > 0) {
                if (turnoDoPersonagem) {
                    System.out.println("Seu turno! Digite 1 para atacar ou 2 para defender:");
                    int escolha = scanner.nextInt();

                    if (escolha == 1) {
                        vidaInimigo -= dano;
                        System.out.println("Você causou " + dano + " de dano. Vida do inimigo: " + vidaInimigo);
                        defendendo = false;
                    } else if (escolha == 2) {
                        System.out.println("Você está se defendendo!");
                        defendendo = true;
                    } else {
                        System.out.println("Escolha inválida. O turno é perdido.");
                        defendendo = false;
                    }
                } else {
                    int danoInimigo = (int) (Math.random() * 10) + 1;
                    if (defendendo) {
                        danoInimigo /= 2;
                        System.out.println("Você defendeu. Dano reduzido para " + danoInimigo);
                    }
                    player.receberDamage(danoInimigo);
                    System.out.println("O inimigo causou " + danoInimigo + " de dano. Sua vida: " + player.getVida());
                }
                turnoDoPersonagem = !turnoDoPersonagem;
            }

            if (player.getVida() <= 0) {
                System.out.println("Você foi derrotado!");
            } else if (vidaInimigo <= 0) {
                System.out.println("Você derrotou o inimigo!");
            }
            jaCombateu = true;
        }
    }
}
