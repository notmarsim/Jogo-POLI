package mapas;

import main.GamePanel;
import tile.Tile;
import gfx.Utils;

import java.awt.*;

public class Maps {
    private int width, height;
    private int[][] tiles;
   // private int targetX;
   // private int targetY;
    public GamePanel gp;


    public Maps(GamePanel gp, String path) {
        this.gp = gp;
        loadMap(path);
    }

    public void update() {

    }
    public void draw(Graphics2D g2) {
        for (int y = 0; y <height; y++) {
            for (int x = 0; x<width;x++){

                getTile(x,y).draw(g2,(int)( x * Tile.tileWidth - gp.getCamera().getxOffSet()),(int) (y * Tile.tileHeight - gp.getCamera().getyOffSet()));
            }
        }
    }
    // achar x y da tile de acordo com o ID !IMPORTANTE!
    public Point findTileCoordinates(int targetID) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (tiles[x][y] == targetID) {
                    return new Point(x, y);
                }
            }
        }
        return null;
    }
    public Tile getTile(int x, int y) {
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null) {
            System.out.println("nao carregou");
            return Tile.pisoMadeira;

        }
        return t;
    }

    private void loadMap(String path) {
        String map = Utils.carregarFileString(path);
        String[] lines = map.split("\\n");
        height = lines.length;
        width = lines[0].split(" ").length;
        tiles = new int[width][height];

        for (int y = 0; y < height; y++) {
            String[] tokens = lines[y].split(" ");
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[x]);

            }
        }
    }

}
