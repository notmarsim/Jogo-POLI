package capitulos;

import entity.Pyroth;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Prologo {
    private Pyroth pyroth;

    public Prologo(GamePanel gamePanel, KeyHandler keyHandler) {
        this.pyroth = new Pyroth(gamePanel, keyHandler);
    }

    public void up() {
        pyroth.update();
        System.out.println("PEGOU");
    }
    public void draw(Graphics2D g2){
        pyroth.draw(g2);
    }
}
