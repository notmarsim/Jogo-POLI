package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Guerreiro extends SuperObject{
    private int aumentoForca;

    public Guerreiro() {

        nome = "Estátua do Guerreiro";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/guerreiro.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        aumentoForca = 8;
    }
    @Override
    public void usouItem(Player player) {
        player.aumentarDano(aumentoForca);

    }

}
