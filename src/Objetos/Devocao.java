package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Devocao extends SuperObject{


    public Devocao() {

        nome = "Estátua da Devoção";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/devoção.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void usouItem(Player player) {
        player.reducaoDeDano += 4;
        player.manaMax += 5;
    }

}
