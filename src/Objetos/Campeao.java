package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Campeao extends SuperObject{


    public Campeao() {

        nome = "Estátua do Campeão";
        descricao = "Aumenta o dano, a vida máxima e mana máxima";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/campeão.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void usouItem(Player player) {
        player.dano += 5;
        player.vidaMaxima += 5;
        player.manaMax += 5;
    }

}
