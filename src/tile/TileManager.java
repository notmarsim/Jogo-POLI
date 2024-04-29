package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.tamanhomaxY][gp.tamanhomaxY];
        getTileImage();
        loadMap();
    }
    public void getTileImage() {
        try  {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("res/maps/mapa1.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int col = 0;
            int row = 0;
            while(col < gp.tamanhomaxX && row < gp.tamanhomaxY) {
                String line = bufferedReader.readLine();
                while (col<gp.tamanhomaxX){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                    col++;
                } if(col == gp.tamanhomaxX) {
                    col = 0;
                    row++;
                }

            } bufferedReader.close();
        } catch (Exception e) {

        }
    }
    public void draw(Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while(col < gp.tamanhomaxX && row < gp.tamanhomaxY) {
            int tileNum = mapTileNum[col][row];
            g2.drawImage(tile[tileNum].image,x,y,gp.tamanhoJanela, gp.tamanhoJanela, null);
            col++;
            x = x + gp.tamanhoJanela;
            if(col == gp.tamanhomaxX) {
                col = 0 ;
                x= 0;
                row ++;
                y+=gp.tamanhoJanela;
            }
        }
    }
}