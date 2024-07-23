package capitulos;

import UI.UI;
import entity.*;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;
import tile.Tile;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChapterFogo {
    private GamePanel gp;
    private Maps mapaFogo;
    private Pyroth pyroth;
    private UI ui;
    private CasaVermelha casaVermelha;
    private EntityManager entityManager;
    private NPC_Fogo blacksmith;

    public ChapterFogo(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.ui = gp.getUi();
        this.mapaFogo = new Maps(gp, "res/maps/mapaFogo.txt", GamePanel.Capitulos.chapterFogo);
        entityManager = new EntityManager(gp ,gp.getPlayer());
        inicializarTochas();
        initializeTreeMarkers();
        NPCs();
        inicializarInimigos();
        entityManager.addEntity(new CasaVermelha(gp,gp.tamanhoJanela*9,gp.tamanhoJanela*15));
        entityManager.addEntity(new CasaVermelha(gp,gp.tamanhoJanela*18,gp.tamanhoJanela*15));
        //entityManager.addEntity(new DemonPequeno(gp, gp.tamanhoJanela*20, gp.tamanhoJanela*10));
//        pyroth.x = gp.tamanhoJanela*2;
//        pyroth.y = gp.tamanhoJanela*18;
    }



    private void NPCs(){
        entityManager.addEntity(new Mercante(gp,gp.tamanhoJanela*5,gp.tamanhoJanela*15));
        entityManager.addEntity(new NPC_Fogo(gp, gp.tamanhoJanela*13, gp.tamanhoJanela*16));
        entityManager.addEntity(new AquaraNPC(gp, gp.tamanhoJanela*15, gp.tamanhoJanela*16));
        entityManager.addEntity(new Mendigo(gp, gp.tamanhoJanela*2, gp.tamanhoJanela*9));
        entityManager.addEntity(new Aldeao(gp, gp.tamanhoJanela*22, gp.tamanhoJanela*15));
    }


    private void inicializarInimigos(){
        entityManager.addEntity(new Demonio(gp, gp.tamanhoJanela*16, gp.tamanhoJanela*26));
        entityManager.addEntity(new DemonPequeno(gp, gp.tamanhoJanela*33, gp.tamanhoJanela*4));
        entityManager.addEntity(new DemonPequeno(gp, gp.tamanhoJanela*36, gp.tamanhoJanela*5));
        entityManager.addEntity(new DemonPequeno(gp, gp.tamanhoJanela*34, gp.tamanhoJanela*8));
        entityManager.addEntity(new DemonPequeno(gp, gp.tamanhoJanela*36, gp.tamanhoJanela*10));
    }

    private void inicializarTochas() {
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*22,gp.tamanhoJanela*22));
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*22,gp.tamanhoJanela*24));
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*22,gp.tamanhoJanela*26));
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*37,gp.tamanhoJanela));
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*31,gp.tamanhoJanela));
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*28,gp.tamanhoJanela*4));
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*40,gp.tamanhoJanela*3));
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*38,gp.tamanhoJanela*7));
        entityManager.addEntity(new Bau(gp,gp.tamanhoJanela*3,gp.tamanhoJanela*15));
    }


    private void initializeTreeMarkers() {
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela, gp.tamanhoJanela*3));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela, gp.tamanhoJanela*13));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*3, gp.tamanhoJanela*10));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*6, gp.tamanhoJanela*10));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*15, gp.tamanhoJanela*6));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*12, gp.tamanhoJanela*6));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*15, gp.tamanhoJanela*4));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*10, gp.tamanhoJanela*2));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*18, gp.tamanhoJanela*12));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*17, gp.tamanhoJanela*13));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*7, gp.tamanhoJanela*7));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*33, gp.tamanhoJanela*35));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*3, gp.tamanhoJanela*12));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*30, gp.tamanhoJanela*29));
    }

    public Maps getMap() {
        return mapaFogo;
    }

    public void up() {
        ui.update();
        mapaFogo.update();
        entityManager.update();
        gp.getEntityManager().setEntities(entityManager.getEntities());
    }

    public void draw(Graphics2D g2) {
        ui.draw(g2);
        if (ui.isFogoDesaparecido()) {
            mapaFogo.draw(g2);
            entityManager.desenhar(g2);
//            desenharCasas(g2);

        }
    }

//    public void desenharCasas(Graphics2D g2) {
//        for(int x = 9; x<18; x = x + 8) {
//            CasaVermelha casaVermelha = new CasaVermelha(gp, gp.tamanhoJanela*x, gp.tamanhoJanela*15);
//            casaVermelha.draw(g2);
//        }
//    }
}