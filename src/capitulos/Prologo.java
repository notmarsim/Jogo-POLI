package capitulos;

import UI.UI;
import entity.Pyroth;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;

import java.awt.*;

public class Prologo {

    private GamePanel gamePanel;
    private Pyroth pyroth;
    private UI ui;
    private Maps mapaPrologo; // Move a declaração aqui

    public Prologo(GamePanel gamePanel, KeyHandler keyHandler) {
        this.pyroth = new Pyroth(gamePanel, keyHandler);
        this.ui = new UI(gamePanel,80);
        this.gamePanel = gamePanel;
        this.mapaPrologo = new Maps(gamePanel, "res/maps/mapaPrologo.txt");
    }

    public void up() {
        //  ui.update();
        mapaPrologo.update();
        pyroth.update();
        System.out.println("PEGOU");
    }

    public void draw(Graphics2D g2){
        // ui.draw(g2);
        if(ui.isPrologoDesaparecido()) {
            mapaPrologo.draw(g2);
            pyroth.draw(g2);
        }
    }
}

