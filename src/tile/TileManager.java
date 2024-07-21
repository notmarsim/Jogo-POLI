package tile;

import main.GamePanel;

public class TileManager {
    private static final int MAX_CAPITULOS = 3; // Número máximo de capítulos, ajuste conforme necessário
    private static final int MAX_TILES = 256;  // Número máximo de tiles por capítulo
    private static Tile[][] tiles = new Tile[MAX_CAPITULOS][MAX_TILES];
    private GamePanel gp;

    public TileManager(GamePanel gp) {
        this.gp = gp;
    }

    public void carregarTile(GamePanel.Capitulos capitulo) {
        if (capitulo.equals(GamePanel.Capitulos.Prologo)) {
            carregarTilePrologo();
        } else if (capitulo.equals(GamePanel.Capitulos.chapterFogo)) {
            carregarTilesChapterFogo();
        } else if(capitulo.equals(GamePanel.Capitulos.chapterAqua)){
            carregarTilesAqua();
        }
    }

    private void carregarTilePrologo() {
        addTile(GamePanel.Capitulos.Prologo, 1, "/tiles/PrologoTiles/pisoTijoloPedra.png", true);
        addTile(GamePanel.Capitulos.Prologo, 2, "/tiles/PrologoTiles/pisoMadeira.png", false);
        addTile(GamePanel.Capitulos.Prologo, 3, "/tiles/PrologoTiles/water.png", false);
        addTile(GamePanel.Capitulos.Prologo, 4, "/tiles/PrologoTiles/pisoLava.png", true);
    }

    private void carregarTilesChapterFogo() {
        addTile(GamePanel.Capitulos.chapterFogo, 5, "/tiles/FogoTiles/tile5.png", false);
        addTile(GamePanel.Capitulos.chapterFogo, 6, "/tiles/FogoTiles/bolha.png", false);
        addTile(GamePanel.Capitulos.chapterFogo, 7,"/tiles/FogoTiles/genericoColisao.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,9, "/tiles/FogoTiles/rochaafundada.png", false);
        addTile(GamePanel.Capitulos.chapterFogo,12, "/tiles/FogoTiles/pedraafundada.png", true);
        addTile(GamePanel.Capitulos.chapterFogo,13, "/tiles/FogoTiles/tocha.png", true);
        addTile(GamePanel.Capitulos.chapterFogo,14, "/tiles/FogoTiles/goldchest1.png", true);
        addTile(GamePanel.Capitulos.chapterFogo,17, "/tiles/FogoTiles/lava.png", true);
        addTile(GamePanel.Capitulos.chapterFogo,25,"/tiles/FogoTiles/tile25.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,26,"/tiles/FogoTiles/tile26.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,28,"/tiles/FogoTiles/tile28.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,29,"/tiles/FogoTiles/tile38.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,30,"/tiles/FogoTiles/tile30.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,33,"/tiles/FogoTiles/tile33.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,36,"/tiles/FogoTiles/tile36.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,37,"/tiles/FogoTiles/tile37.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,38,"/tiles/FogoTiles/tile38.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,41,"/tiles/FogoTiles/tile41.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,42,"/tiles/FogoTiles/tile42.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,43,"/tiles/FogoTiles/tile43.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,44,"/tiles/FogoTiles/tile44.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,45,"/tiles/FogoTiles/tile46.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,46,"/tiles/FogoTiles/tile46.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,47,"/tiles/FogoTiles/tile54.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,49,"/tiles/FogoTiles/tile49.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,51,"/tiles/FogoTiles/tile51.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,52,"/tiles/FogoTiles/tile52.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,53,"/tiles/FogoTiles/tile53.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,54,"/tiles/FogoTiles/tile54.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,55,"/tiles/FogoTiles/tile55.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,57,"/tiles/FogoTiles/tile57.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,59,"/tiles/FogoTiles/tile59.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,60,"/tiles/FogoTiles/tile60.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,63,"/tiles/FogoTiles/tile63.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,65,"/tiles/FogoTiles/tile65.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,66,"/tiles/FogoTiles/tile66.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,67,"/tiles/FogoTiles/tile67.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,70,"/tiles/FogoTiles/tile70.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,71,"/tiles/FogoTiles/tile71.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,72,"/tiles/FogoTiles/tile72.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,73, "/tiles/FogoTiles/tile73.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,74, "/tiles/FogoTiles/tile74.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,75, "/tiles/FogoTiles/tile75.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,77,"/tiles/FogoTiles/tile77.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,79,"/tiles/FogoTiles/tile79.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,80,"/tiles/FogoTiles/tile80.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,81,"/tiles/FogoTiles/tile81.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,83,"/tiles/FogoTiles/tile83.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,84,"/tiles/FogoTiles/tile85.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,85,"/tiles/FogoTiles/tile85.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,86,"/tiles/FogoTiles/tile86.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,87,"/tiles/FogoTiles/tile87.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,88,"/tiles/FogoTiles/tile88.png",true);
        addTile(GamePanel.Capitulos.chapterFogo,89,"/tiles/FogoTiles/tile89.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,90,"/tiles/FogoTiles/tile90.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,97,"/tiles/FogoTiles/tile97.png",false);
        addTile(GamePanel.Capitulos.chapterFogo,108,"/tiles/FogoTiles/tile108.png",true);
    }

    private void carregarTilesAqua(){
        addTile(GamePanel.Capitulos.chapterAqua, 1, "/tiles/GeloTiles/caminho.png", false);
        //addTile(GamePanel.Capitulos.chapterAqua, 4, "/tiles/GeloTiles/snow.png", false);
        addTile(GamePanel.Capitulos.chapterAqua, 2, "/tiles/GeloTiles/agua.png", true);
        addTile(GamePanel.Capitulos.chapterAqua, 3, "/tiles/GeloTiles/snow.png", false);
    }

    private void addTile(GamePanel.Capitulos chapter, int id, String imagePath, boolean isSolid) {
        int chapterIndex = chapter.ordinal();
        if (tiles[chapterIndex][id] == null) {
            Tile tile = new Tile(imagePath, id, isSolid);
            tiles[chapterIndex][id] = tile;
        }
    }

    public static Tile getTile(GamePanel.Capitulos chapter, int id) {
        int chapterIndex = chapter.ordinal();
        Tile tile = tiles[chapterIndex][id];
        if (tile == null) {
            System.err.println("Tile não carregado: " + id + " no capítulo " + chapter);
            return tiles[chapterIndex][1]; // Supondo que o tile 1 seja o padrão
        }
        return tile;
    }
}
