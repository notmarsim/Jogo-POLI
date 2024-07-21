package tile;

import main.GamePanel;

public class TileManager {
    private static final int MAX_CAPITULOS = 6; // Número máximo de capítulos, ajuste conforme necessário
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
        }else if(capitulo.equals(GamePanel.Capitulos.chapterAr)){
            carregarTilesAr();
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

    private void carregarTilesAr(){
        addTile(GamePanel.Capitulos.chapterAr, 3, "/tiles/ArTiles/tile002.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 17, "/tiles/ArTiles/tile016.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 22, "/tiles/ArTiles/tile021.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 29, "/tiles/ArTiles/tile028.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 30, "/tiles/ArTiles/tile029.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 44, "/tiles/ArTiles/tile043.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 46, "/tiles/ArTiles/tile045.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 48, "/tiles/ArTiles/tile047.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 50, "/tiles/ArTiles/tile049.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 51, "/tiles/ArTiles/tile050.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 54, "/tiles/ArTiles/tile053.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 60, "/tiles/ArTiles/tile059.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 62, "/tiles/ArTiles/tile061.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 71, "/tiles/ArTiles/tile070.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 72, "/tiles/ArTiles/tile071.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 73, "/tiles/ArTiles/tile072.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 85, "/tiles/ArTiles/tile084.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 86, "/tiles/ArTiles/tile085.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 87, "/tiles/ArTiles/tile086.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 99, "/tiles/ArTiles/tile098.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 101, "/tiles/ArTiles/tile100.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 103, "/tiles/ArTiles/tile102.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 110, "/tiles/ArTiles/tile109.png", false);
        addTile(GamePanel.Capitulos.chapterAr, 113, "/tiles/ArTiles/tile112.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 115, "/tiles/ArTiles/tile114.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 117, "/tiles/ArTiles/tile116.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 138, "/tiles/ArTiles/tile137.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 139, "/tiles/ArTiles/tile138.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 140, "/tiles/ArTiles/tile139.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 152, "/tiles/ArTiles/tile151.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 153, "/tiles/ArTiles/tile152.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 154, "/tiles/ArTiles/tile153.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 166, "/tiles/ArTiles/tile165.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 167, "/tiles/ArTiles/tile166.png", true);
        addTile(GamePanel.Capitulos.chapterAr, 168, "/tiles/ArTiles/tile167.png", true);
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
