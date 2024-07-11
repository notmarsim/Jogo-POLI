package tile;

import main.GamePanel;
import java.util.HashMap;
import java.util.Map;

public class TileManager {
    private static Map<Integer, Tile> tiles = new HashMap<>();
    private GamePanel gp;

    public TileManager(GamePanel gp) {
        this.gp = gp;
    }

    public void carregarTile(GamePanel.Capitulos capitulo) {
        if (capitulo.equals(GamePanel.Capitulos.Prologo)) {
            carregarTilePrologo();
        } else if (capitulo.equals(GamePanel.Capitulos.chapterFogo)) {
            carregarTilesChapterFogo();
        }
    }

    private void carregarTilePrologo() {
        addTile(1, "/tiles/PrologoTiles/pisoTijoloPedra.png", true);
        addTile(2, "/tiles/PrologoTiles/pisoMadeira.png", false);
        addTile(3, "/tiles/PrologoTiles/water.png", false);
        addTile(4, "/tiles/PrologoTiles/pisoLava.png", true);
    }

    private void carregarTilesChapterFogo() {
        addTile(5, "/tiles/FogoTiles/tile5.png", false);
        addTile(6, "/tiles/FogoTiles/bolha.png", false);
        addTile(7,"/tiles/FogoTiles/genericoColisao.png",true);
        addTile(9, "/tiles/FogoTiles/rochaafundada.png", false);
        addTile(12, "/tiles/FogoTiles/pedraafundada.png", true);
        addTile(13, "/tiles/FogoTiles/tocha.png", true);
        addTile(14, "/tiles/FogoTiles/goldchest1.png", true);
        addTile(17, "/tiles/FogoTiles/lava.png", true);
        addTile(25,"/tiles/FogoTiles/tile25.png",false);
        addTile(26,"/tiles/FogoTiles/tile26.png",true);
        addTile(28,"/tiles/FogoTiles/tile28.png",false);
        addTile(29,"/tiles/FogoTiles/tile38.png",false);
        addTile(30,"/tiles/FogoTiles/tile30.png",false);
        addTile(33,"/tiles/FogoTiles/tile33.png",false);
        addTile(36,"/tiles/FogoTiles/tile36.png",false);
        addTile(37,"/tiles/FogoTiles/tile37.png",false);
        addTile(38,"/tiles/FogoTiles/tile38.png",false);
        addTile(41,"/tiles/FogoTiles/tile41.png",false);
        addTile(42,"/tiles/FogoTiles/tile42.png",true);
        addTile(43,"/tiles/FogoTiles/tile43.png",false);
        addTile(44,"/tiles/FogoTiles/tile44.png",false);
        addTile(45,"/tiles/FogoTiles/tile46.png",false);
        addTile(46,"/tiles/FogoTiles/tile46.png",false);
        addTile(47,"/tiles/FogoTiles/tile54.png",false);
        addTile(49,"/tiles/FogoTiles/tile49.png",false);
        addTile(51,"/tiles/FogoTiles/tile51.png",true);
        addTile(52,"/tiles/FogoTiles/tile52.png",false);
        addTile(53,"/tiles/FogoTiles/tile53.png",false);
        addTile(54,"/tiles/FogoTiles/tile54.png",false);
        addTile(55,"/tiles/FogoTiles/tile55.png",true);
        addTile(57,"/tiles/FogoTiles/tile57.png",false);
        addTile(59,"/tiles/FogoTiles/tile59.png",true);
        addTile(60,"/tiles/FogoTiles/tile60.png",true);
        addTile(63,"/tiles/FogoTiles/tile63.png",true);
        addTile(65,"/tiles/FogoTiles/tile65.png",false);
        addTile(66,"/tiles/FogoTiles/tile66.png",true);
        addTile(67,"/tiles/FogoTiles/tile67.png",true);
        addTile(70,"/tiles/FogoTiles/tile70.png",true);
        addTile(71,"/tiles/FogoTiles/tile71.png",true);
        addTile(72,"/tiles/FogoTiles/tile72.png",true);
        addTile(73, "/tiles/FogoTiles/tile73.png",false);
        addTile(74, "/tiles/FogoTiles/tile74.png",true);
        addTile(75, "/tiles/FogoTiles/tile75.png",false);
        addTile(77,"/tiles/FogoTiles/tile77.png",false);
        addTile(79,"/tiles/FogoTiles/tile79.png",true);
        addTile(80,"/tiles/FogoTiles/tile80.png",true);
        addTile(81,"/tiles/FogoTiles/tile81.png",false);
        addTile(83,"/tiles/FogoTiles/tile83.png",true);
        addTile(84,"/tiles/FogoTiles/tile85.png",true);
        addTile(85,"/tiles/FogoTiles/tile85.png",true);
        addTile(86,"/tiles/FogoTiles/tile86.png",true);
        addTile(87,"/tiles/FogoTiles/tile87.png",true);
        addTile(88,"/tiles/FogoTiles/tile88.png",true);
        addTile(89,"/tiles/FogoTiles/tile89.png",false);
        addTile(90,"/tiles/FogoTiles/tile90.png",false);
        addTile(97,"/tiles/FogoTiles/tile97.png",false);
        addTile(108,"/tiles/FogoTiles/tile108.png",true);
    }

    private void addTile(int id, String imagePath, boolean isSolid) {
        if (!tiles.containsKey(id)) {
            Tile tile = new Tile(imagePath, id, isSolid);
            tiles.put(id, tile);
        }
    }

    public static Tile getTile(int id) {
        Tile tile = tiles.get(id);
        if (tile == null) {
            System.err.println("tile nao carregado: " + id);
            return tiles.get(1);
        }
        return tile;
    }
}
