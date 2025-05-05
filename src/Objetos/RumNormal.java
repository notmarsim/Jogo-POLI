package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class RumNormal extends SuperObject{


    public RumNormal() {

        nome = "Rum";
        descricao = "Aumenta a vida máxima";
        peso = 2.0;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/Rum.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
    @Override
    public void usouItem(Player player) {
        player.vidaMaxima += 10;
    }

}
