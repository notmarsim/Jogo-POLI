package Objetos;

import entity.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PocaoMana extends SuperObject{


    public PocaoMana() {

        nome = "Poção de Aumento de Força";
        descricao = "Recupera parte da sua mana";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/pocaoMana.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    @Override
    public void usouItem(Player player) {
        player.recuperarMana();
    }

}
