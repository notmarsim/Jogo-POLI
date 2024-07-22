package capitulos;

import UI.UI;
import entity.*;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;

import java.awt.*;

public class ChapterTerra {
    private GamePanel gp;
    private Maps mapaTerra;
    private Terranis terranis;
    private UI ui;
    private EntityManager entityManager;

    public ChapterTerra(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.ui = gp.getUi();
        this.mapaTerra = new Maps(gp, "res/maps/mapaTerra.txt", GamePanel.Capitulos.chapterEarth);
        this.terranis = new Terranis(gp, keyHandler);
        entityManager = new EntityManager(gp ,gp.getPlayer());
        entityManager.addEntity(terranis);
        inicializarArvores();
        terranis.x = gp.tamanhoJanela*25;
        terranis.y = gp.tamanhoJanela*2;
        entityManager.addEntity(new Buda(gp, gp.tamanhoJanela*25, gp.tamanhoJanela*20));
        entityManager.addEntity(new Demonio(gp, gp.tamanhoJanela*16, gp.tamanhoJanela*26));
        entityManager.addEntity(new AerisNPC(gp, gp.tamanhoJanela*16, gp.tamanhoJanela*5));
        entityManager.addEntity(new PyrothNPC(gp, gp.tamanhoJanela*18, gp.tamanhoJanela*5));
        entityManager.addEntity(new AquaraNPC(gp, gp.tamanhoJanela*14, gp.tamanhoJanela*5));
        addEstatua();
    }

    public void inicializarArvores(){
        entityManager.addEntity(new Arvore(gp, gp.tamanhoJanela*19, gp.tamanhoJanela*2));
        entityManager.addEntity(new Arvore(gp, gp.tamanhoJanela*30, gp.tamanhoJanela*2));
        entityManager.addEntity(new Arvore(gp, gp.tamanhoJanela*30, gp.tamanhoJanela*11));
        entityManager.addEntity(new Arvore(gp, gp.tamanhoJanela*37, gp.tamanhoJanela*10));
        entityManager.addEntity(new Arvore(gp, gp.tamanhoJanela*19, gp.tamanhoJanela*11));
        entityManager.addEntity(new Arvore(gp, gp.tamanhoJanela*14, gp.tamanhoJanela*12));

    }

    public void addEstatua(){
        entityManager.addEntity(new Estatua(gp,gp.tamanhoJanela*21,gp.tamanhoJanela*15));
        entityManager.addEntity(new Estatua(gp,gp.tamanhoJanela*21,gp.tamanhoJanela*25));
        entityManager.addEntity(new Estatua(gp,gp.tamanhoJanela*29,gp.tamanhoJanela*15));
        entityManager.addEntity(new Estatua(gp,gp.tamanhoJanela*29,gp.tamanhoJanela*25));

    }


    public Maps getMap() {
        return mapaTerra;
    }

    public void up() {
        ui.update();
        mapaTerra.update();
        entityManager.update();
        gp.getEntityManager().setEntities(entityManager.getEntities());
    }

    public void draw(Graphics2D g2) {
        ui.draw(g2);
        if (ui.isTerraDesaparecido()) {
            mapaTerra.draw(g2);
            entityManager.desenhar(g2);
        }
    }
}