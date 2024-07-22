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
    private UI ui;
    private EntityManager entityManager;

    public ChapterVoid(GamePanel gp, KeyHandler keyHandler){
        this.gp = gp;
        this.ui = gp.getUi();
        this.mapaVoid = new Maps(gp, "res/maps/mapaVoid.txt", GamePanel.Capitulos.chapterVoid);
        entityManager = new EntityManager(gp ,gp.getPlayer());
        inicializarNPCs();
        inicializarConstruções();
        inicializarMonstros();
    }
    public void inicializarMonstros(){
        entityManager.addEntity(new Bringer(gp, gp.tamanhoJanela*22, gp.tamanhoJanela*20));
        entityManager.addEntity(new Bringer(gp, gp.tamanhoJanela*16, gp.tamanhoJanela*26));
        entityManager.addEntity(new FinalBoss(gp, gp.tamanhoJanela*12, gp.tamanhoJanela*14));
        entityManager.addEntity(new Nightborne(gp, gp.tamanhoJanela*10, gp.tamanhoJanela*18));
    }
    public void inicializarConstruções(){

    }
    public void inicializarNPCs(){

        entityManager.addEntity(new Esqueleto(gp, gp.tamanhoJanela*32, gp.tamanhoJanela*5));
        entityManager.addEntity(new Esqueleto(gp, gp.tamanhoJanela*30, gp.tamanhoJanela*8));
        entityManager.addEntity(new Esqueleto(gp, gp.tamanhoJanela*27, gp.tamanhoJanela*10));
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