package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sabedoria extends SuperObject{


    public Sabedoria() {

        nome = "Estátua da Sabedoria";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/sabedoria.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void usouItem(Player player) {

        player.manaMax += 10;
    }

}
