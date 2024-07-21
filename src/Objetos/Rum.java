package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Rum extends SuperObject{
    private int aumentoForca;

    public Rum() {

        nome = "Rum lendário do mendigo";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/Rum.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }
        aumentoForca = 10;

    }
    @Override
    public void usouItem(Player player) {
        player.aumentarDano(aumentoForca);
        player.vidaMaxima += 30;
    }

}
