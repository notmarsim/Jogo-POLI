package capitulos;

import UI.UI;
import entity.Pyroth;
import main.GamePanel;
import main.KeyHandler;
import tile.TileManager;

import java.awt.*;

public class Prologo {
    private Pyroth pyroth;

    private UI ui;
    private TileManager tileManager;

    public Prologo(GamePanel gamePanel, KeyHandler keyHandler) {
        this.pyroth = new Pyroth(gamePanel, keyHandler);
        this.tileManager = new TileManager(gamePanel);
        this.ui = new UI(gamePanel,80);
    }

    public void up() {
       // ui.update();
        pyroth.update();
        System.out.println("PEGOU");
    }


    public void draw(Graphics2D g2){

      //  ui.draw(g2);
        if(ui.isPrologoDesaparecido()) {
            tileManager.draw(g2);
            pyroth.draw(g2);

        }
    }
}
