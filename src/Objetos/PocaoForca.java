package Objetos;

import entity.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PocaoForca extends SuperObject{


    public PocaoForca() {

        nome = "Poção de Aumento de Força";
        descricao = "Aumenta a força";
        peso = 3.2;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/pocaoForca.png"));
        } catch (IOException e) {
            e.printStackTrace();
            
        }

    }
    @Override
    public void usouItem(Player player) {
        player.dano += 2;
    }

}
