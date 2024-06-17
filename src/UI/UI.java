package UI;

import main.GamePanel;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class UI {
    Graphics2D g2;
    Font maruMonica;
    GamePanel gamePanel;
    int fontSize;
    private int prologoOpacity;
    private boolean fadingOut;
    long startTime;
    long duration;
    private Dialogues dialogues;

    public UI(GamePanel gamePanel, int fontSize) {
        this.gamePanel = gamePanel;
        this.fontSize = fontSize;
        this.prologoOpacity = 0;
        this.fadingOut = false;
        this.startTime = System.currentTimeMillis();
        this.duration = 3000;

        this.dialogues = new Dialogues(gamePanel, fontSize);

        InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
        try {
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.PLAIN, fontSize);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(maruMonica);




        if (gamePanel.getGameState() == GamePanel.GameState.Dialogo) {
            dialogues.drawDialogueScreen(g2); // Use o método da classe Dialogues
        } else if (gamePanel.currentCapitulo.equals(GamePanel.Capitulos.Prologo)) {
            g2.setColor(new Color(255, 255, 255, prologoOpacity));
            printarPrologo();
        }
    }

    public void update() {
        long elapsedTime = System.currentTimeMillis() - startTime;

        if (elapsedTime >= duration && !fadingOut) {
            iniciarDesaparecimento();
        }

        if (fadingOut) {
            prologoOpacity -= 5;
            if (prologoOpacity <= 0) {
                prologoOpacity = 0;
            }
        } else {
            if (prologoOpacity < 255) {
                prologoOpacity += 5;
                if (prologoOpacity >= 255) {
                    prologoOpacity = 255;
                }
            }
        }
    }

    public void printarPrologo() {
        String text = "PROLOGO";
        int x = textoCentralizadoX(text);
        int y = gamePanel.alturaTela / 2;
        g2.drawString(text, x, y);
    }

    public int textoCentralizadoX(String text) {
        int x;
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gamePanel.larguraTela / 2 - length / 2;
        return x;
    }

    public void iniciarDesaparecimento() {
        fadingOut = true;
    }

    public boolean isPrologoDesaparecido() {
        return prologoOpacity == 0;
    }
}
