package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Campeao extends SuperObject{
    private int aumentoForca;

    public Campeao() {

        nome = "Estátua do Campeão";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/campeão.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        aumentoForca = 5;
    }
    @Override
    public void usouItem(Player player) {
        player.aumentarDano(aumentoForca);
        player.vidaMaxima += 5;
        player.manaMax += 5;
    }

}
