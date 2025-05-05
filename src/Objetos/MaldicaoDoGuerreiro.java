package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class MaldicaoDoGuerreiro extends SuperObject{


    public MaldicaoDoGuerreiro() {

        nome = "Maldicao do Guerreiro";
        descricao = "Duplica o dano, mas reduz a vida máxima pela metade";
        peso = 5.5;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/maldicao1.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }


    }
    @Override
    public void usouItem(Player player) {
        player.dano *= 2;
        player.vidaMaxima /= 2;
    }

}
