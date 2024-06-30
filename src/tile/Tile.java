package tile;

import main.GamePanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    // MATERIAIS ESTATICOS
    private static GamePanel gp;
    public static Tile[] tiles = new Tile[120];
    public static Tile pisoTijoloPedra = new PisoTijoloPedra(1);
    public static Tile pisoMadeira = new PisoMadeira(2);
    public static Tile pisoElder = new PisoElder(3);
    public static Tile pisoLava = new PisoLava(4);
    public static Tile bolha2= new Tile5(5);
    public static Tile bolhaLava = new BolhaLava(6);
    public static Tile GoldChest = new GoldChest(14);
    public static Tile lava = new Lava(17);
    public static Tile tile25 = new Tile25(25);
    public static Tile tile28 = new Tile28(28);
    public static Tile tile29 = new Tile29(29);
    public static Tile tile30 = new Tile30(30);
    public static Tile tile36 = new Tile36(36);
    public static Tile tile37 = new Tile37(37);
    public static Tile tile38 = new Tile38(38);
    public static Tile tile41 = new Tile41(41);
    public static Tile tile44 = new Tile44(44);
    public static Tile tile46 = new Tile46(46);
    public static Tile tile45 = new Tile46(45);
    public static Tile tile49 = new Tile49(49);
    public static Tile tile52 = new Tile52(52);
    public static Tile tile53 = new Tile53(53);
    public static Tile tile54 = new Tile54(54);
    public static Tile tile55 = new Tile55(55);
    public static Tile tile57 = new Tile57(57);
    public static Tile tile60 = new Tile60(60);
    public static Tile tile63 = new Tile63(63);
    public static Tile tile65 = new Tile65(65);
    public static Tile tile70 = new Tile70(70);
    public static Tile tile71 = new Tile71(71);
    public static Tile tile72 = new Tile72(72);
    public static Tile tile73 = new Tile73(73);
    public static Tile tile77 = new Tile77(77);
    public static Tile tile81 = new Tile81(81);
    public static Tile tile89 = new Tile89(89);
    public static Tile tile97 = new Tile97(97);
    public static Tile tileAfundada = new TileAfundada(12);
    public static Tile rochaAfundada = new RochaAfundada(9);




    // CLASSE
    public BufferedImage image;
    protected final int id;
    public boolean colission = false;
    public static final int tileWidth = gp.tamanhoJanela, tileHeight = gp.tamanhoJanela;


    public Tile(BufferedImage image, int id) {
        this.id = id;
        this.image = image;
        this.gp = new GamePanel();
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
