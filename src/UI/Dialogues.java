package UI;

import main.GamePanel;

import java.awt.*;

public class Dialogues extends UI {

    public Dialogues(GamePanel gamePanel, int fontSize) {
        super(gamePanel, fontSize);
    }


    public void drawDialogueScreen(){
        int x = gamePanel.tamanhoJanela*2;
        int y = gamePanel.tamanhoJanela/2;
        int width = gamePanel.larguraTela - gamePanel.tamanhoJanela*4;
        int height = gamePanel.tamanhoJanela*5;

        drawSubWindow(x,y,width,height);
    }
    public void drawSubWindow(int x, int y, int width, int height) {
        Color color = new Color(0,0,0);
        g2.setColor(color);
        g2.fillRoundRect(x,y,width,height,35,35);
        color = new Color(255,255,255);
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }
}
