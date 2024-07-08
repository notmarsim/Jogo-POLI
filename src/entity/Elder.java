package entity;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Elder extends Entity {

    public Elder(GamePanel gp, int startX, int startY) {
        super(gp);
        this.x = startX;
        this.y = startY;
        loadSprites();
        bounds = new Rectangle();
        bounds.x = -50;
        bounds.y = -70;
        bounds.width = 200;
        bounds.height = 250;
    }


    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/npcs/elder.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void draw(Graphics2D g2) {
        // Desenhe o sprite do Elder
        BufferedImage image = idle;
        g2.drawImage(image, (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela)), (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela)), gp.tamanhoJanela*3, gp.tamanhoJanela*3, null);

        //debug
        /*
        g2.setColor(Color.RED);
        g2.drawRect((int) (x - gp.getCamera().getxOffSet() + bounds.x),
                (int) (y - gp.getCamera().getyOffSet() + bounds.y),
                bounds.width, bounds.height);
                */

    }

    public String getFala(){
        return "Pyroth, Guardião do Fogo, ouça as antigas palavras esquecidas há milênios e agora trazidas à luz. A escuridão que uma vez ameaçou Elemenvera ressurgiu. Nas profundezas das sombras, um ser corrompido, outrora apenas uma lenda, conhecido como Necromancer, desperta com a intenção de devorar a essência dos nossos elementos e mergulhar o mundo em trevas eternas.\n" +
                "\n" +
                "Sua missão é restaurar a paz em cada reino de Elemenvera, agora sob ataque pelos monstros criados por Necromancer. Comece pelo seu domínio, o Reino do Fogo, e alerte os outros guardiões para que protejam e salvem seus próprios reinos também. Boa sorte, Guardião.";

    }

    public int tipo(){
        return 2;
    }

}
