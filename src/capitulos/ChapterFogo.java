package capitulos;

import UI.UI;
import entity.CasaVermelha;
import entity.Pyroth;
import entity.Tocha;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;
import entity.DeathTree;
import tile.Tile;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChapterFogo {
    private GamePanel gp;
    private Maps mapaFogo;
    private Pyroth pyroth;
    private UI ui;
    private List<Tocha> tochas; // Lista para armazenar as tochas
    private CasaVermelha casaVermelha;

    public ChapterFogo(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.ui = gp.getUi();
        this.mapaFogo = new Maps(gp, "res/maps/mapaFogo.txt");
        this.tochas = new ArrayList<>(); // Inicialize a lista de tochas
        initializeTreeMarkers();
        inicializarTochas();
        pyroth = new Pyroth(gp, keyHandler);
        pyroth.x = gp.tamanhoJanela*2;
        pyroth.y = gp.tamanhoJanela*18;
    }


    private void inicializarTochas() {
        boolean[][] tochasPosicao = new boolean[mapaFogo.getWidth()][mapaFogo.getHeight()];
        tochasPosicao[22][22] = true;
        tochasPosicao[22][24] = true;
        tochasPosicao[22][26] = true;
        tochasPosicao[37][1] = true;
        tochasPosicao[31][1] = true;
        mapaFogo.setTochasPosicao(tochasPosicao);

        // Criar instâncias de tochas e adicionar à lista
        for (int y = 0; y < mapaFogo.getHeight(); y++) {
            for (int x = 0; x < mapaFogo.getWidth(); x++) {
                if (tochasPosicao[x][y]) {
                    Tocha tocha = new Tocha(gp, x * Tile.tileWidth, y * Tile.tileHeight);
                    tochas.add(tocha);
                }
            }
        }
    }


    private void initializeTreeMarkers() {
        boolean[][] markers = new boolean[mapaFogo.getWidth()][mapaFogo.getHeight()];
        markers[1][3] = true;
        markers[1][13] = true;
        markers[3][10] = true;
        markers[7][7] = true;
        markers[33][35] = true;
        markers[30][29] = true;
        markers[3][12] = true;
        mapaFogo.setTreeMarkers(markers);
    }

    public Maps getMap() {
        return mapaFogo;
    }

    public void up() {
        ui.update();
        mapaFogo.update();
        pyroth.update();

        // Atualize cada tocha
        for (Tocha tocha : tochas) {
            tocha.update();
        }
    }

    public void draw(Graphics2D g2) {
         ui.draw(g2);
        if (ui.isFogoDesaparecido()) {
            mapaFogo.draw(g2);
            drawTrees(g2);
            desenharCasas(g2);
            desenharTochas(g2);
            pyroth.draw(g2);
        }
    }

    public void desenharCasas(Graphics2D g2) {
        for(int x = 9; x<18; x = x + 8) {
            CasaVermelha casaVermelha = new CasaVermelha(gp, gp.tamanhoJanela*x, gp.tamanhoJanela*15);
            casaVermelha.draw(g2);
        }
    }

    private void desenharTochas(Graphics2D g2) {
        for (Tocha tocha : tochas) {
            tocha.draw(g2);
        }
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
