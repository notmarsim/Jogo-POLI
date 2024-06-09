package capitulos;

import UI.UI;
import entity.Elder;
import entity.Pyroth;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;
import tile.Tile;
import main.Fight;
import java.awt.*;

public class Prologo {

    private GamePanel gamePanel;
    private Pyroth pyroth;
    private UI ui;
    private Maps mapaPrologo; // Move a declaração aqui
    private Elder elder;
    private Maps maps;
    private Fight fight;

    public Prologo(GamePanel gamePanel, KeyHandler keyHandler) {
        this.pyroth = new Pyroth(gamePanel, keyHandler, fight);
        this.ui = new UI(gamePanel,80);
        this.gamePanel = gamePanel;
        this.mapaPrologo = new Maps(gamePanel, "res/maps/mapaPrologo.txt");


    }

    public void up() {
          ui.update();
        mapaPrologo.update();
        pyroth.update();

        //System.out.println("PEGOU");
    }

    public void draw(Graphics2D g2){
         ui.draw(g2);
        if(ui.isPrologoDesaparecido()) {
            mapaPrologo.draw(g2);

            // Encontrar as coordenadas do tile com o ID 3
            Point tileCoordinates = mapaPrologo.findTileCoordinates(3);
            if (tileCoordinates != null) {
                int x = tileCoordinates.x * Tile.tileWidth;
                int y = tileCoordinates.y * Tile.tileHeight;
                this.elder = new Elder(gamePanel, x, y,true,3);
                elder.draw(g2);
            } else {
                this.elder = new Elder(gamePanel, 100, 100, true,3);
            }
            pyroth.draw(g2);
        }
    }
}

