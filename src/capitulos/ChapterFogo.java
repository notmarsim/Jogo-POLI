package capitulos;

import entity.Pyroth;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;
import entity.DeathTree;
import tile.Tile;

import java.awt.*;

public class ChapterFogo {
    private GamePanel gp;
    private Maps mapaFogo;
    private Pyroth pyroth;

    public ChapterFogo(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.mapaFogo = new Maps(gp, "res/maps/mapaFogo.txt");
        initializeTreeMarkers();
        pyroth = new Pyroth(gp,keyHandler);
    }

    private void initializeTreeMarkers() {
        boolean[][] markers = new boolean[mapaFogo.getWidth()][mapaFogo.getHeight()];
        markers[3][4] = true;
        markers[5][8] = true;
        markers[4][12] = true;
        markers[7][10] = true;
        markers[35][35] = true;
        markers[36][30] = true;
        markers[5][10] = true;
        mapaFogo.setTreeMarkers(markers);
    }

    public Maps getMap() {
        return mapaFogo;
    }

    public void up() {
        mapaFogo.update();
        pyroth.update();
    }

    public void draw(Graphics2D g2) {
        mapaFogo.draw(g2);
        drawTrees(g2);
        pyroth.draw(g2);
    }

    private void drawTrees(Graphics2D g2) {
        for (int y = 0; y < mapaFogo.getHeight(); y++) {
            for (int x = 0; x < mapaFogo.getWidth(); x++) {
                if (mapaFogo.treeMarkers[x][y]) {
                    int treeX = x * Tile.tileWidth;
                    int treeY = y * Tile.tileHeight;
                    DeathTree deathTree = new DeathTree(gp, treeX, treeY);
                    deathTree.draw(g2);
                }
            }
        }
    }
}
