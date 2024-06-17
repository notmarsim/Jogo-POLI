package UI;

import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Dialogues {

    private GamePanel gamePanel;
    private int fontSize;
    private Graphics2D g2;

    public Dialogues(GamePanel gamePanel, int fontSize) {
        this.gamePanel = gamePanel;
        this.fontSize = fontSize;
    }

    public void drawDialogueScreen(Graphics2D g2) {
        this.g2 = g2;
        int x = gamePanel.tamanhoJanela * 2;
        int y = gamePanel.tamanhoJanela / 2;
        int width = gamePanel.larguraTela - gamePanel.tamanhoJanela * 4;
        int height = gamePanel.tamanhoJanela * 4;

        drawSubWindow(x, y, width, height);

        String textoDialogo = "teste dialogo teste dialogo teste dialogo teste dialogo teste dialogo teste dialogo teste dialogo teste dialogo teste dialogo teste dialogo " +
                "teste dialogo teste dialogo teste dialogo teste dialogo teste dialogo teste dialogo teste dialogo teste dialogo teste dialogo";
        drawTextoDialogo(textoDialogo, x + 20, y + 40, width - 40);
    }

    public void drawSubWindow(int x, int y, int width, int height) {
        Color color = new Color(0, 0, 0, 200);
        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        color = new Color(255, 255, 255); // Cor da borda
        g2.setColor(color);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x + 5, y + 5, width - 10, height - 10, 25, 25);
    }

    private void drawTextoDialogo(String texto, int x, int y, int maxWidth) {
        g2.setColor(Color.WHITE);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20));
        FontMetrics metrics = g2.getFontMetrics();

        List<String> linhas = new ArrayList<>();
        String[] palavras = texto.split(" ");
        StringBuilder linhaAtual = new StringBuilder();

        for (String palavra : palavras) {
            if (metrics.stringWidth(linhaAtual + palavra) < maxWidth) {
                linhaAtual.append(palavra).append(" ");
            } else {
                linhas.add(linhaAtual.toString());
                linhaAtual = new StringBuilder(palavra).append(" ");
            }
        }
        linhas.add(linhaAtual.toString());

        for (String linha : linhas) {
            g2.drawString(linha, x, y);
            y += metrics.getHeight();
        }
    }
}
