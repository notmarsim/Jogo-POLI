package capitulos;

import UI.UI;
import entity.*;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class ChapterVoid  {
    private Maps mapaVoid;
    private GamePanel gp;
    private Aeris aeris;
    private UI ui;
    private EntityManager entityManager;

    public ChapterVoid(GamePanel gp, KeyHandler keyHandler){
        this.gp = gp;
        this.ui = gp.getUi();

        this.mapaVoid = new Maps(gp, "res/maps/mapaVoid.txt", GamePanel.Capitulos.chapterVoid);
        this.aeris = new Aeris(gp, keyHandler);
        this.aeris.x = 200;
        this.aeris.y=900;
        entityManager = new EntityManager(gp ,gp.getPlayer());
        entityManager.addEntity(aeris);
        entityManager.addEntity(new Demonio(gp, gp.tamanhoJanela*16, gp.tamanhoJanela*26));
    }
    public Maps getMap() {
        return mapaVoid;
    }

    public void up() {
        ui.update();
        mapaVoid.update();
        entityManager.update();
        gp.getEntityManager().setEntities(entityManager.getEntities());



    }

    public void draw(Graphics2D g2) {
        ui.draw(g2);
        mapaVoid.draw(g2);
        entityManager.desenhar(g2);
    }



}