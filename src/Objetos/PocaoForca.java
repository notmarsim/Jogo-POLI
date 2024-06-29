package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PocaoForca extends SuperObject{
    private int aumentoForca;

    public PocaoForca() {

        nome = "Poção de Aumento de Força";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/pocaoForca.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        aumentoForca = 2;
    }
    @Override
    public void usouItem(Player player) {
        player.aumentarDano(aumentoForca);
    }

}
