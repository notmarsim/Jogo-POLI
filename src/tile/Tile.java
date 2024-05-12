package tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    // MATERIAIS ESTATICOS

    public static Tile[] tiles = new Tile[100];
    public static Tile pisoTijoloPedra = new PisoTijoloPedra(1);
    public static Tile pisoMadeira = new PisoMadeira(2);
    public static Tile pisoElder = new PisoElder(3);



    // CLASSE
    public BufferedImage image;
    protected final int id;
    public boolean colission = false;
    public static final int tileWidth = 64, tileHeight = 64;


    public Tile(BufferedImage image,int id) {
        this.id = id;
        this.image = image;

        tiles[id] = this;
    }

    public void update() {

    }

    public void draw(Graphics2D g2, int x, int y){
        g2.drawImage(image,x,y,tileWidth,tileHeight,null);
    }

    public int getId() {
        return id;
    }

    public boolean isSolid() {
        return false;
    }
}
