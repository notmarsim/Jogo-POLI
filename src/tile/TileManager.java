package tile;

import main.GamePanel;
import java.util.HashMap;
import java.util.Map;

public class TileManager {
    private static Map<Integer, Tile> tiles = new HashMap<>();
    private GamePanel gp;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        loadTiles();
    }

    private void loadTiles() {
        addTile(1, "/tiles/pisoTijoloPedra.png", true);
        addTile(2, "/tiles/pisoMadeira.png", false);
        addTile(3, "/tiles/water.png", true);
        addTile(4, "/tiles/pisoLava.png", true);
        addTile(5, "/tiles/FogoTiles/tile5.png", false);
        addTile(6, "/tiles/FogoTiles/bolha.png", false);
        addTile(9, "/tiles/FogoTiles/rochaafundada.png", false);
        addTile(12, "/tiles/FogoTiles/pedraafundada.png", true);
        addTile(13, "/tiles/FogoTiles/tocha.png", true);
        addTile(14, "/tiles/FogoTiles/goldchest1.png", true);
        addTile(17, "/tiles/FogoTiles/lava.png", true);
        addTile(25,"/tiles/FogoTiles/tile25.png",false);
        addTile(28,"/tiles/FogoTiles/tile28.png",false);
        addTile(29,"/tiles/FogoTiles/tile38.png",false);
        addTile(30,"/tiles/FogoTiles/tile30.png",false);
        addTile(36,"/tiles/FogoTiles/tile36.png",false);
        addTile(37,"/tiles/FogoTiles/tile37.png",false);
        addTile(38,"/tiles/FogoTiles/tile38.png",false);
        addTile(41,"/tiles/FogoTiles/tile41.png",false);
        addTile(44,"/tiles/FogoTiles/tile44.png",false);
        addTile(45,"/tiles/FogoTiles/tile46.png",false);
        addTile(46,"/tiles/FogoTiles/tile46.png",false);
        addTile(49,"/tiles/FogoTiles/tile49.png",false);
        addTile(52,"/tiles/FogoTiles/tile52.png",false);
        addTile(53,"/tiles/FogoTiles/tile53.png",false);
        addTile(54,"/tiles/FogoTiles/tile54.png",false);
        addTile(55,"/tiles/FogoTiles/tile55.png",false);
        addTile(57,"/tiles/FogoTiles/tile57.png",false);
        addTile(60,"/tiles/FogoTiles/tile60.png",true);
        addTile(63,"/tiles/FogoTiles/tile63.png",false);
        addTile(65,"/tiles/FogoTiles/tile65.png",false);
        addTile(70,"/tiles/FogoTiles/tile70.png",false);
        addTile(71,"/tiles/FogoTiles/tile71.png",false);
        addTile(72,"/tiles/FogoTiles/tile72.png",true);
        addTile(73, "/tiles/FogoTiles/tile73.png",false);
        addTile(77,"/tiles/FogoTiles/tile77.png",false);
        addTile(79,"/tiles/FogoTiles/tile79.png",true);
        addTile(80,"/tiles/FogoTiles/tile80.png",true);
        addTile(81,"/tiles/FogoTiles/tile81.png",false);
        addTile(85,"/tiles/FogoTiles/tile85.png",false);
        addTile(86,"/tiles/FogoTiles/tile86.png",false);
        addTile(89,"/tiles/FogoTiles/tile89.png",false);
        addTile(97,"/tiles/FogoTiles/tile97.png",false);

    }

    private void addTile(int id, String imagePath, boolean isSolid) {
        Tile tile = new Tile(imagePath, id, isSolid);
        if (tile != null) {
            tiles.put(id, tile);
        } else {
            System.err.println("Falha ao carregar tile com ID " + id);
        }
    }


    public static Tile getTile(int id) {
        Tile tile = tiles.get(id);
        if (tile == null) {
            System.err.println("Tile com ID " + id + " não encontrado. Usando tile padrão.");
            return tiles.get(1); // Supondo que 1 é o ID para o pisoTijoloPedra
        }
        return tile;
    }
}
