package entity;

import java.util.Scanner;

public class Combate {

    private int vidaInimigo;
    private boolean defendendo;
    private boolean jaCombateu;


    public Combate(int vida, int dano) {
        vidaInimigo = 20;
        this.defendendo = false;
        jaCombateu = false;
    }

    public void iniciarTurnoCombate(int vida,int dano) {
        if(!jaCombateu) {
            System.out.println("Combate iniciado!");

            int vidaInimigo = 10;
            boolean turnoDoPersonagem = true;
            boolean defendendo = false; // Estado de defesa

            Scanner scanner = new Scanner(System.in);

            while (vida > 0 && vidaInimigo > 0) {
                if (turnoDoPersonagem) {
                    System.out.println("teste");
                    System.out.println("Seu turno! Digite 1 para atacar ou 2 para defender:");
                    int escolha = scanner.nextInt();

                    if (escolha == 1) {
                        int danoCausado = dano; // Combina o dano do personagem com o input do jogador
                        vidaInimigo -= danoCausado;
                        System.out.println("Você causou " + danoCausado + " de dano. Vida do inimigo: " + vidaInimigo);
                        defendendo = false; // Reset defesa
                    } else if (escolha == 2) {
                        System.out.println("Você está se defendendo!");
                        defendendo = true; // Marca o estado de defesa
                    } else {
                        System.out.println("Escolha inválida. O turno é perdido.");
                        defendendo = false; // Reset defesa em caso de escolha inválida
                    }
                } else {
                    int danoInimigo = (int) (Math.random() * 10) + 1;
                    if (defendendo) {
                        danoInimigo /= 2;
                        System.out.println("Você defendeu. Dano reduzido para " + danoInimigo);
                    }
                    vida -= danoInimigo;
                    System.out.println("O inimigo causou " + danoInimigo + " de dano. Sua vida: " + vida);
                }
                turnoDoPersonagem = !turnoDoPersonagem; // alterna o turno
            }

            if (vida <= 0) {
                System.out.println("Você foi derrotado!");
                jaCombateu = true;
            } else if (vidaInimigo <= 0) {
                System.out.println("Você derrotou o inimigo!");
                jaCombateu = true;
            }
        }

    }
}
