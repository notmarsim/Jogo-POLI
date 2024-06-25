package UI;

import Objetos.SuperObject;
import entity.Player;
import main.GamePanel;
import main.KeyHandler;

import java.awt.Image;
import java.awt.image.BufferedImage;
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

        } else if (gamePanel.getCharacterState() == GamePanel.CharacterState.Inventario) {
            drawInventory();

        }


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

    public void drawHealthBar(Graphics2D g2) {
        // Dimensões e posição da barra de vida
        int barX = 50;
        int barY = 50;
        int barWidth = 200; // Largura total da barra
        int barHeight = 20; // Altura da barra

        // Calcula a largura proporcional da barra de vida baseada na vida atual
        int currentBarWidth = (int) ((double) gamePanel.getPlayer().getVida() / gamePanel.getPlayer().vidaMaxima * barWidth);

        // Desenha o contorno da barra de vida
        g2.setColor(Color.gray); // Cor do fundo da barra
        g2.fillRect(barX, barY, barWidth, barHeight);

        // Desenha a barra de vida atual
        g2.setColor(Color.red); // Cor da vida
        g2.fillRect(barX, barY, currentBarWidth, barHeight);

        // Desenha o contorno da barra
        g2.setColor(Color.black);
        g2.drawRect(barX, barY, barWidth, barHeight);

        // Texto da vida
        g2.setColor(Color.white);
        g2.setFont(maruMonica.deriveFont(Font.BOLD, 14)); // Fonte do texto
        String vidaTexto = gamePanel.getPlayer().getVida() + "/" + gamePanel.getPlayer().vidaMaxima;
        int vidaTextoX = barX + (barWidth - g2.getFontMetrics().stringWidth(vidaTexto)) / 2;
        int vidaTextoY = barY + barHeight - 5;
        g2.drawString(vidaTexto, vidaTextoX, vidaTextoY);
    }

    public void usarItemSelecionado() {
        int selectedIndex = slotRow * 5 + slotCol; // Índice do item selecionado
        if (selectedIndex >= 0 && selectedIndex < gamePanel.getPlayer().inventario.size()) {
            SuperObject selectedItem = gamePanel.getPlayer().inventario.get(selectedIndex);
            selectedItem.usouItem(gamePanel.getPlayer());
            System.out.println("Dano:"+gamePanel.getPlayer().getDano());
            gamePanel.getPlayer().inventario.remove(selectedIndex);
            gamePanel.repaint();
        }
    }

    public void drawInventory() {
        int frameX = gamePanel.tamanhoJanela * 9;
        int frameY = gamePanel.tamanhoJanela;
        int frameWidth = gamePanel.tamanhoJanela * 6;
        int frameHeight = gamePanel.tamanhoJanela * 11 / 2;

        // Desenhe o quadro do inventário
        g2.setColor(new Color(50, 50, 50, 200)); // Um fundo semitransparente
        g2.fillRoundRect(frameX, frameY, frameWidth, frameHeight, 10, 10);

        g2.setColor(Color.white);
        g2.drawRoundRect(frameX, frameY, frameWidth, frameHeight, 10, 10); // Desenha a borda

        // Título do inventário
        g2.setColor(Color.white);
        g2.setFont(maruMonica.deriveFont(Font.BOLD, 25)); // Fonte em negrito com tamanho reduzido
        String titulo = "Inventário";
        int tituloWidth = g2.getFontMetrics().stringWidth(titulo);
        int tituloX = frameX + (frameWidth - tituloWidth) / 2;
        int tituloY = frameY + 30; // Ajuste vertical para colocar acima dos slots
        g2.drawString(titulo, tituloX, tituloY);

        // Descrição do item selecionado
        g2.setFont(maruMonica.deriveFont(Font.PLAIN, 14)); // Fonte menor para a descrição
        int selectedIndex = slotRow * 5 + slotCol; // Índice do item selecionado
        if (selectedIndex >= 0 && selectedIndex < gamePanel.getPlayer().inventario.size()) {
            SuperObject selectedItem = gamePanel.getPlayer().inventario.get(selectedIndex);
            String descricao = selectedItem.nome;
            int descricaoWidth = g2.getFontMetrics().stringWidth(descricao);
            int descricaoX = frameX + (frameWidth - descricaoWidth) / 2;
            int descricaoY = frameY + 50;
            g2.drawString(descricao, descricaoX, descricaoY);
        }

        // Slots
        final int slotSize = gamePanel.tamanhoJanela;
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY + 80;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                int slotX = slotXstart + (col * (slotSize + 10));
                int slotY = slotYstart + (row * (slotSize + 10));
                g2.drawRect(slotX, slotY, slotSize, slotSize);

                // Índice do item no inventário
                int index = row * 5 + col;
                if (index < gamePanel.getPlayer().inventario.size()) {
                    // Obtém o SuperObject do inventário
                    SuperObject item = gamePanel.getPlayer().inventario.get(index);

                    if (item.image != null) {
                        // Converte BufferedImage para Image
                        Image img = (Image) item.image;

                        // Desenha a imagem do inventário na posição atual
                        g2.drawImage(img, slotX, slotY, null);
                    }
                }
            }
        }

        // Cursor
        int cursorX = slotXstart + (slotSize + 10) * slotCol;
        int cursorY = slotYstart + (slotSize + 10) * slotRow;
        g2.setColor(Color.yellow);
        g2.drawRoundRect(cursorX, cursorY, slotSize, slotSize, 10, 10);
    }




}