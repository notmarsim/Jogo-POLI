package entity;

import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {
    private GamePanel gp;
    private ArrayList<Entity> entities;
    private Player player;
    private boolean shouldBeRemoved;

    // Comparator para ordenar entidades pela coordenada Y
    private Comparator<Entity> ordemRender = new Comparator<Entity>() {
        @Override
        public int compare(Entity o1, Entity o2) {
            int y1 = o1.getY() + o1.getHeightBounds();
            int y2 = o2.getY() + o2.getHeightBounds();
            return Integer.compare(y1, y2);
        }
    };

    public EntityManager(GamePanel gp, Player player) {
        this.gp = gp;
        this.player = player;
        entities = new ArrayList<>();
    }

    public void update() {
        player.update();

        // Use um Iterator para atualizar e remover entidades com segurança
        Iterator<Entity> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            entity.update();
            if (entity.shouldBeRemoved()) {
                iterator.remove();
            }
        }
    }



    public void desenhar(Graphics2D g2) {

        player.draw(g2);


        entities.sort(ordemRender);
        for (Entity e : entities) {
            e.draw(g2);
        }
    }


    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }

    public void addEntity(Entity e) {
        entities.add(e);
        entities.sort(ordemRender);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
