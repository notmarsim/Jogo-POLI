package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Rum extends SuperObject{


    public Rum() {

        nome = "Rum lendário do mendigo";
        descricao = "O que será que isso faz?";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/Rum.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
    @Override
    public void usouItem(Player player) {
        player.dano += 10;
        player.vidaMaxima += 30;
    }

}
