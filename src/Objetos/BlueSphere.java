package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class BlueSphere extends SuperObject{


    public BlueSphere() {

        nome = "Esfera Elementar da Pedra";
        descricao = "Concede energia ao reino da Terra";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/esfera.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void usouItem(Player player) {
        player.revitalizouEsfera = true;
    }

}
