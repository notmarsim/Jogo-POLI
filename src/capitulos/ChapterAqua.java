package capitulos;

import UI.UI;
import entity.*;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;

import java.awt.*;

public class ChapterAqua {
    private GamePanel gp;
    private Maps mapaAqua;
    private Aquara aquara;
    private UI ui;
    private EntityManager entityManager;

    public ChapterAqua(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        this.ui = gp.getUi();
        this.mapaAqua = new Maps(gp, "res/maps/mapaAqua.txt", GamePanel.Capitulos.chapterAqua);
        entityManager = new EntityManager(gp ,gp.getPlayer());
        inicializarConstrucoes();
        inicializarNPCs();
    }

    private void inicializarNPCs(){
        entityManager.addEntity(new Princesa(gp, gp.tamanhoJanela*6,gp.tamanhoJanela*5));
        entityManager.addEntity(new Bau(gp,gp.tamanhoJanela*20,gp.tamanhoJanela*12));
        entityManager.addEntity(new Bau(gp,gp.tamanhoJanela*5,gp.tamanhoJanela*4));
        entityManager.addEntity(new Sereia(gp,gp.tamanhoJanela*16,gp.tamanhoJanela*28));
        entityManager.addEntity(new Sereia(gp,gp.tamanhoJanela*28,gp.tamanhoJanela*28));
        entityManager.addEntity(new Mercante(gp,gp.tamanhoJanela*5,gp.tamanhoJanela*15));
        entityManager.addEntity(new GolemGelo(gp, gp.tamanhoJanela*16, gp.tamanhoJanela*35));
        entityManager.addEntity(new PyrothNPC(gp, gp.tamanhoJanela*15, gp.tamanhoJanela*16));
        entityManager.addEntity(new AerisNPC(gp, gp.tamanhoJanela*13, gp.tamanhoJanela*16));
        entityManager.addEntity(new GolemPequeno(gp, gp.tamanhoJanela*35, gp.tamanhoJanela*15));
        entityManager.addEntity(new GolemPequeno(gp, gp.tamanhoJanela*32, gp.tamanhoJanela*15));
        entityManager.addEntity(new GolemPequeno(gp, gp.tamanhoJanela*32, gp.tamanhoJanela*8));
        entityManager.addEntity(new GolemPequeno(gp, gp.tamanhoJanela*35, gp.tamanhoJanela*10));
    }

    private void inicializarConstrucoes(){
        entityManager.addEntity(new Iglu(gp,gp.tamanhoJanela*23,gp.tamanhoJanela*16));
        entityManager.addEntity(new Iglu(gp,gp.tamanhoJanela*2,gp.tamanhoJanela*3));
        entityManager.addEntity(new Iglu(gp,gp.tamanhoJanela*8,gp.tamanhoJanela*3));
        entityManager.addEntity(new Bonfire(gp, gp.tamanhoJanela*5, gp.tamanhoJanela*5 ));
        entityManager.addEntity(new ArvoresSnow(gp,gp.tamanhoJanela*3, gp.tamanhoJanela*8));
        entityManager.addEntity(new ArvoresSnow(gp,gp.tamanhoJanela*6, gp.tamanhoJanela*11));
        entityManager.addEntity(new ArvoresSnow(gp,gp.tamanhoJanela*16, gp.tamanhoJanela));
        entityManager.addEntity(new ArvoresSnow(gp,gp.tamanhoJanela*24, gp.tamanhoJanela));
        entityManager.addEntity(new ArvoresSnow(gp,gp.tamanhoJanela*20, gp.tamanhoJanela*2));
        entityManager.addEntity(new ArvoresSnow(gp,gp.tamanhoJanela*21, gp.tamanhoJanela*5));
    }


    public Maps getMap() {
        return mapaAqua;
    }

    public void up() {
        ui.update();
        mapaAqua.update();
        entityManager.update();
        gp.getEntityManager().setEntities(entityManager.getEntities());
    }

    public void draw(Graphics2D g2) {
        ui.draw(g2);
        if (ui.isAguaDesaparecido()) {
            mapaAqua.draw(g2);
            entityManager.desenhar(g2);

        }
    }

}