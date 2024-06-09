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
        int xStart = (int) Math.max(0,gp.getCamera().getxOffSet()/ Tile.tileWidth);
        int yStart = (int) Math.max(0,gp.getCamera().getyOffSet()/ Tile.tileHeight);
        int xEnd = (int) Math.min(width,(gp.getCamera().getxOffSet() + gp.larguraTela) / Tile.tileWidth +1);
        int yEnd = (int) Math.min(height,(gp.getCamera().getyOffSet() + gp.alturaTela) / Tile.tileHeight + 1);
        for (int y = yStart; y <yEnd; y++) {
            for (int x = xStart; x<xEnd;x++){
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
        if (x<0 || y<0 || x>=width || y>=height) {
            return Tile.pisoTijoloPedra;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null) {
            System.out.println("nao carregou");
            return Tile.pisoTijoloPedra;

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