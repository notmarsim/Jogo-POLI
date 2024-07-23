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

        entityManager = new EntityManager(gp ,gp.getPlayer());
        inicializarMonstros();
        inicializarNPCs();
        inicializarConstruções();
    }


    public void inicializarMonstros(){
        entityManager.addEntity(new Esqueleto(gp, gp.tamanhoJanela*32, gp.tamanhoJanela*5));
        entityManager.addEntity(new Esqueleto(gp, gp.tamanhoJanela*30, gp.tamanhoJanela*8));
        entityManager.addEntity(new Esqueleto(gp, gp.tamanhoJanela*27, gp.tamanhoJanela*10));
        entityManager.addEntity(new Esqueleto(gp, gp.tamanhoJanela*35, gp.tamanhoJanela*35));
        entityManager.addEntity(new Esqueleto(gp, gp.tamanhoJanela*30, gp.tamanhoJanela*18));
        entityManager.addEntity(new Esqueleto(gp, gp.tamanhoJanela*27, gp.tamanhoJanela*20));
        entityManager.addEntity(new Guerreiro(gp, gp.tamanhoJanela*16, gp.tamanhoJanela*26));
    }
    public void inicializarConstruções(){
        entityManager.addEntity(new CasaDeserto(gp, gp.tamanhoJanela*8, gp.tamanhoJanela*5));
        entityManager.addEntity(new CasaDeserto(gp, gp.tamanhoJanela*5, gp.tamanhoJanela*5));
        entityManager.addEntity(new CasaDeserto(gp, gp.tamanhoJanela*2, gp.tamanhoJanela*5));
        entityManager.addEntity(new CasaDeserto2(gp, gp.tamanhoJanela*25, gp.tamanhoJanela*20));
        entityManager.addEntity(new CasaDeserto(gp, gp.tamanhoJanela*35, gp.tamanhoJanela*30));
        entityManager.addEntity(new CasaDeserto2(gp, gp.tamanhoJanela*27, gp.tamanhoJanela*35));
        entityManager.addEntity(new CasaDeserto2(gp, gp.tamanhoJanela*5, gp.tamanhoJanela*17));
        entityManager.addEntity(new CasaDeserto2(gp, gp.tamanhoJanela*35, gp.tamanhoJanela*20));
    }
    public void inicializarNPCs(){
        entityManager.addEntity(new TerranisNPC(gp, gp.tamanhoJanela*16, gp.tamanhoJanela*5));
        entityManager.addEntity(new PyrothNPC(gp, gp.tamanhoJanela*18, gp.tamanhoJanela*5));
        entityManager.addEntity(new AquaraNPC(gp, gp.tamanhoJanela*14, gp.tamanhoJanela*5));
        entityManager.addEntity(new Mercante(gp,gp.tamanhoJanela*21,gp.tamanhoJanela*5));
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