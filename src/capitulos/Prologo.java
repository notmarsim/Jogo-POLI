package capitulos;

import UI.UI;
import entity.*;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;
import tile.Tile;

import java.awt.*;

public class Prologo {

    private GamePanel gamePanel;
    private Pyroth pyroth;
    private UI ui;
    private Maps mapaPrologo; // Move a declaração aqui
    private Elder elder;
    private Maps maps;
    private EntityManager entityManager;

    public Prologo(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        entityManager = new EntityManager(gamePanel, new Player(gamePanel,keyHandler));
        this.pyroth = new Pyroth(gamePanel, keyHandler);
        entityManager.addEntity(pyroth);
        entityManager.addEntity(new Elder(gamePanel, gamePanel.tamanhoJanela*15, gamePanel.tamanhoJanela*11));
        this.ui = gamePanel.getUi();
        this.mapaPrologo = new Maps(gamePanel, "res/maps/mapaPrologo.txt");
    }

    public Maps getMap() {
        return mapaPrologo;
    }


    public void up() {
        ui.update();
        mapaPrologo.update();
        entityManager.update();
        System.out.println("No prologo: " + entityManager.getEntities());
        gamePanel.getEntityManager().setEntities(entityManager.getEntities());

    }

    public void draw(Graphics2D g2){
        ui.draw(g2);
        if(ui.isPrologoDesaparecido()) {
            mapaPrologo.draw(g2);
            entityManager.desenhar(g2);
        }
    }
}