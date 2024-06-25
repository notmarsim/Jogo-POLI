package Objetos;

import javax.imageio.ImageIO;
import java.io.IOException;

public class PocaoForca extends SuperObject{
    public PocaoForca(){
        nome = "Poção de Aumento de Força";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objetos/pocaoForca.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
