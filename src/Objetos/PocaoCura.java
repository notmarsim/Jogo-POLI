package Objetos;

import entity.Player;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PocaoCura extends SuperObject{


    public PocaoCura() {

        nome = "Poção de Cura";
        descricao = "Cura parte de sua vida";
        peso = 60.0;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/pocaoCura.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void usouItem(Player player) {
        player.curarVida();
        System.out.println(player.getVida());
    }

}
