package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Semente extends SuperObject{


    public Semente() {

        nome = "Semente do Caos";
        descricao = "Aumenta consideravelmente a vida máxima, aumenta o dano e a mana máxima";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/semente.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void usouItem(Player player) {
        player.dano += 2;
        player.vidaMaxima += 10;
        player.manaMax += 3;
    }

}
