package capitulos;

import UI.UI;
import entity.*;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;

import java.awt.*;

public class ChapterAr {
    private GamePanel gp;
    private Maps mapaAr;
    private Aeris aeris;
    private UI ui;
    private EntityManager entityManager;

    public ChapterAr(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.ui = gp.getUi();
        this.mapaAr = new Maps(gp, "res/maps/mapaAr.txt", GamePanel.Capitulos.chapterAr);
        this.aeris = new Aeris(gp, keyHandler);
        entityManager = new EntityManager(gp ,gp.getPlayer());
        entityManager.addEntity(aeris);
        entityManager.addEntity(new Guerreiro(gp, gp.tamanhoJanela*16, gp.tamanhoJanela*26));
    }


    public Maps getMap() {
        return mapaAr;
    }

    public void up() {
        ui.update();
        mapaAr.update();
        entityManager.update();
        gp.getEntityManager().setEntities(entityManager.getEntities());
    }

    public void draw(Graphics2D g2) {
        ui.draw(g2);
       if (ui.isArDesaparecido()) {
           mapaAr.draw(g2);
           entityManager.desenhar(g2);
        }
    }

}