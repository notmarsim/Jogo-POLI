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
    public int slotRow = 0;
    public int slotCol = 0;

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


        if (gamePanel.getCharacterState()==GamePanel.CharacterState.Dialogo) {
            dialogues.drawDialogueScreen(g2);
            System.out.println("dialogo");
        } else if (gamePanel.getCharacterState() == GamePanel.CharacterState.Inventario) {
            drawInventory();
            System.out.println("Estado Inventário Ativo");
        }

        // Desenha o prólogo apenas se o capítulo for Prologo
        if (gamePanel.currentCapitulo.equals(GamePanel.Capitulos.Prologo)) {
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
                gamePanel.setGameState(GamePanel.GameState.Jogando); // Muda o estado para Jogando

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

    public void drawInventory() {
        int frameX = gamePanel.tamanhoJanela * 9;
        int frameY = gamePanel.tamanhoJanela;
        int frameWidth = gamePanel.tamanhoJanela * 6;
        int frameHeight = gamePanel.tamanhoJanela * 5;

        // Desenhe o quadro do inventário
        g2.setColor(new Color(50, 50, 50, 200)); // Um fundo semitransparente
        g2.fillRoundRect(frameX, frameY, frameWidth, frameHeight, 10, 10);

        g2.setColor(Color.white);
        g2.drawRoundRect(frameX, frameY, frameWidth, frameHeight, 10, 10); // Desenha a borda

        // Slots
        final int slotSize = gamePanel.tamanhoJanela;
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 20;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                int slotX = slotXstart + (col * (slotSize + 10));
                int slotY = slotYstart + (row * (slotSize + 10));
                g2.drawRect(slotX, slotY, slotSize, slotSize);
            }
        }

        // Cursor
        int cursorX = slotXstart + (slotSize + 10) * slotCol;
        int cursorY = slotYstart + (slotSize + 10) * slotRow;
        g2.setColor(Color.yellow);
        g2.drawRoundRect(cursorX, cursorY, slotSize, slotSize, 10, 10);
    }
}
