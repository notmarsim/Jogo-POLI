package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Semente extends SuperObject{
    private int aumentoForca;

    public Semente() {

        nome = "Semente do Caos";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/semente.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        aumentoForca = 2;
    }
    @Override
    public void usouItem(Player player) {
        player.aumentarDano(aumentoForca);
        player.vidaMaxima += 10;
        player.manaMax += 3;
    }

}
