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
    private int prologoOpacity; // Opacidade específica para o prólogo
    private boolean fadingOut;
    long startTime;
    long duration;

    public UI(GamePanel gamePanel, int fontSize) {
        this.gamePanel = gamePanel;
        this.fontSize = fontSize;
        this.prologoOpacity = 0; // Inicialize a opacidade do prólogo
        this.fadingOut = false;
        this.startTime = System.currentTimeMillis();
        this.duration = 3000;

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

        // Renderizar outros elementos da UI aqui, se necessário

        // Verificar o estado do jogo e desenhar o diálogo se necessário
        if (gamePanel.getGameState() == GamePanel.GameState.Dialogo) {
            drawDialogueScreen();
        } else if (gamePanel.currentCapitulo.equals(GamePanel.Capitulos.Prologo)) {
            g2.setColor(new Color(255, 255, 255, prologoOpacity)); // Use a opacidade específica do prólogo
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

    public void drawDialogueScreen() {
        int x = gamePanel.tamanhoJanela * 2;
        int y = gamePanel.tamanhoJanela / 2;
        int width = gamePanel.larguraTela - gamePanel.tamanhoJanela * 4;
        int height = gamePanel.tamanhoJanela * 5;

        drawSubWindow(x, y, width, height);
        String textoDialogo = "marcio viadinho";
        drawTextoDialogo(textoDialogo, x + 20, y + 40);
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color color = new Color(0, 0, 0, 200); // Cor de fundo com transparência
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        color = new Color(255, 255, 255); // Cor da borda
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    private void drawTextoDialogo(String texto, int x, int y) {
        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20)); // Tamanho do texto do diálogo
        for (String linha : texto.split("\n")) {
            g2.drawString(linha, x, y);
            y += g2.getFontMetrics().getHeight(); // Avança para a próxima linha
        }
    }
}
