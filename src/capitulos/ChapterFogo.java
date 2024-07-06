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
        this.mapaFogo = new Maps(gp, "res/maps/mapaFogo.txt");
        this.pyroth = new Pyroth(gp, keyHandler);
        entityManager = new EntityManager(gp,new Player(gp,keyHandler));
        entityManager.addEntity(pyroth);
        entityManager.addEntity(new NPC_Fogo(gp, gp.tamanhoJanela*13, gp.tamanhoJanela*16));
        inicializarTochas();
        initializeTreeMarkers();
        entityManager.addEntity(new Demonio(gp, gp.tamanhoJanela*6, gp.tamanhoJanela*16 ));
        pyroth.x = gp.tamanhoJanela*2;
        pyroth.y = gp.tamanhoJanela*18;
    }


    private void inicializarTochas() {
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*22,gp.tamanhoJanela*22));
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*22,gp.tamanhoJanela*24));
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*22,gp.tamanhoJanela*26));
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*37,gp.tamanhoJanela));
        entityManager.addEntity(new Tocha(gp,gp.tamanhoJanela*31,gp.tamanhoJanela));
    }


    private void initializeTreeMarkers() {
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela, gp.tamanhoJanela*3));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela, gp.tamanhoJanela*13));
        entityManager.addEntity(new DeathTree(gp, gp.tamanhoJanela*3, gp.tamanhoJanela*10));
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
            desenharCasas(g2);

        }
    }

    public void desenharCasas(Graphics2D g2) {
        for(int x = 9; x<18; x = x + 8) {
            CasaVermelha casaVermelha = new CasaVermelha(gp, gp.tamanhoJanela*x, gp.tamanhoJanela*15);
            casaVermelha.draw(g2);
        }
    }
}
