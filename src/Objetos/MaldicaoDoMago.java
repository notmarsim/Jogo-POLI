package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class MaldicaoDoMago extends SuperObject{


    public MaldicaoDoMago() {

        nome = "Maldicao do Mago das Sombras";
        descricao = "Triplica a mana máxima, mas reduz o dano pela metade";
        peso = 22.7;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/maldicao2.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
    @Override
    public void usouItem(Player player) {
        player.dano /= 2;
        player.manaMax *= 3;
    }

}