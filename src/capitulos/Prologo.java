package capitulos;

import UI.UI;
import entity.Elder;
import entity.Pyroth;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;
import tile.Tile;

import java.awt.*;

public class Prologo {

    private GamePanel gamePanel;
    private Pyroth pyroth;
    private UI ui;
    private Maps mapaPrologo; // Move a declaração aqui
    private Elder elder;
    private Maps maps;

    public Prologo(GamePanel gamePanel, KeyHandler keyHandler) {
        this.pyroth = new Pyroth(gamePanel, keyHandler);
        this.gamePanel = gamePanel;
        this.ui = gamePanel.getUi();
        this.mapaPrologo = new Maps(gamePanel, "res/maps/mapaPrologo.txt");
    }

    public Maps getMap() {
        return mapaPrologo;
    }


    public void up() {
        ui.update();
        mapaPrologo.update();
        pyroth.update();

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
                this.elder = new Elder(gamePanel, x, y);
                elder.draw(g2);
            } else {
                this.elder = new Elder(gamePanel, 100, gamePanel.tamanhoJanela*20);
            }
            pyroth.draw(g2);
        }
    }
}
