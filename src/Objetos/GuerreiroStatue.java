package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class GuerreiroStatue extends SuperObject{


    public GuerreiroStatue() {

        nome = "Estátua do Guerreiro";
        descricao = "Aumenta consideravelmente o dano";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/guerreiro.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void usouItem(Player player) {
        player.dano += 8;

    }

}
