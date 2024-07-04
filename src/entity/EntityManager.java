package entity;

import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private GamePanel gp;
    private ArrayList<Entity> npcs;
    private Player player;

    public EntityManager(GamePanel gp, Player player) {
        this.gp  = gp;
        this.player = player;
        npcs = new ArrayList<Entity>();
        addEntity(player);
    }

    public void update() {
        for(int i = 0; i< npcs.size(); i++) {
            Entity e = npcs.get(i);
            e.update();
        }

    }

    public void desenhar(Graphics2D g2) {
        for(Entity e : npcs) {
            e.draw(g2);
        }

    }

    public void addEntity(Entity e) {
        npcs.add(e);
    }

    public ArrayList<Entity> getEntities() {
        return npcs;
    }

}
