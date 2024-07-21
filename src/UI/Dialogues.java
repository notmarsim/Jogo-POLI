package UI;

import entity.Elder;
import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Dialogues {

    private GamePanel gamePanel;
    private int fontSize;
    private Graphics2D g2;
    private String currentDialogueText = ""; // Inicializa com string vazia

    public Dialogues(GamePanel gamePanel, int fontSize) {
        this.gamePanel = gamePanel;
        this.fontSize = fontSize;
    }

    // Método para configurar o texto atual do diálogo
    public void setDialogueText(String text) {
        this.currentDialogueText = text;
    }

    public String getDialogueText() {
        return currentDialogueText;
    }

    public void drawDialogueScreen(Graphics2D g2) {
        this.g2 = g2;
        int x = gamePanel.tamanhoJanela * 2;
        int y = gamePanel.tamanhoJanela / 2;
        int width = gamePanel.larguraTela - gamePanel.tamanhoJanela * 4;
        int height = gamePanel.tamanhoJanela * 3;

        drawSubWindow(x, y, width, height);
        System.out.println("no dialogues: " + currentDialogueText);

        // Usar o texto atual do diálogo
        if (currentDialogueText != null && !currentDialogueText.isEmpty()) {
            drawTextoDialogo(currentDialogueText, x + 20, y + 40, width - 40);
        }
    }

    private void drawSubWindow(int x, int y, int width, int height) {
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
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 23));

        FontMetrics metrics = g2.getFontMetrics();

        // Divide o texto nas quebras de linha
        String[] linhas = texto.split("\n");

        for (String linha : linhas) {
            List<String> linhasQuebradas = new ArrayList<>();
            String[] palavras = linha.split(" ");
            StringBuilder linhaAtual = new StringBuilder();

            for (String palavra : palavras) {
                if (metrics.stringWidth(linhaAtual + palavra) < maxWidth) {
                    linhaAtual.append(palavra).append(" ");
                } else {
                    linhasQuebradas.add(linhaAtual.toString());
                    linhaAtual = new StringBuilder(palavra).append(" ");
                }
            }
            linhasQuebradas.add(linhaAtual.toString());

            for (String linhaQuebrada : linhasQuebradas) {
                g2.drawString(linhaQuebrada, x, y);
                y += metrics.getHeight();
            }
        }
    }

}
