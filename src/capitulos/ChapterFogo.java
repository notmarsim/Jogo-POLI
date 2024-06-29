package capitulos;

import UI.UI;
import entity.Pyroth;
import main.GamePanel;
import main.KeyHandler;
import mapas.Maps;

import java.awt.*;

public class ChapterFogo {
    private GamePanel gp;
    private Pyroth pyroth;
    private UI ui;
    private Maps mapaFogo;
    private Maps maps;

    public ChapterFogo(GamePanel gp, KeyHandler keyHandler) {
        this.gp = gp;
        pyroth = new Pyroth(gp,keyHandler);
        this.ui = gp.getUi();
        this.mapaFogo = new Maps(gp,"res/maps/mapaFogo.txt");
    }

    public Maps getMap(){
        return mapaFogo;
    }

    public void up() {
        mapaFogo.update();
        pyroth.update();

    }

    public void draw(Graphics2D g2){
        mapaFogo.draw(g2);
        pyroth.draw(g2);
    }
}
