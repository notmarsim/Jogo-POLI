package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PedraSolar extends SuperObject{


    public PedraSolar() {

        nome = "Pedra Solar";
        descricao = "Aumenta consideravelmente a redução de dano, mas diminui o seu dano";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/pedraSolar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void usouItem(Player player) {
        player.reducaoDeDano += 10;
        player.dano -= 4;
    }

}
