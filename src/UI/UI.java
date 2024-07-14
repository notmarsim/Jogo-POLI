package UI;

import Objetos.SuperObject;

import entity.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
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
    private int prologoOpacity, fogoOpacity, aguaOpacity, terraOpacity, arOpacity;
    private boolean fadingOutPrologo, fadingOutFogo, fadingOutAgua, fadingOutTerra, fadingOutAr;
    long startTime;
    long duration;
    private Dialogues dialogues;
    public int slotRow = 0;
    public int slotCol = 0;
    public int selectedOption = 0;
    private String currentDialogueText;
    private Player player;
    private BufferedImage enterImage;



    // Construtor
    public UI(GamePanel gamePanel, int fontSize) {
        this.gamePanel = gamePanel;
        player = gamePanel.getPlayer();
        this.fontSize = fontSize;
        this.prologoOpacity = 0;
        this.fadingOutPrologo = false;
        this.fogoOpacity = 0;
        this.fadingOutFogo = false;
        this.aguaOpacity = 0;
        this.fadingOutAgua = false;
        this.terraOpacity = 0;
        this.fadingOutTerra = false;
        this.arOpacity = 0;
        this.fadingOutAr = false;
        this.startTime = System.currentTimeMillis();
        this.duration = 3000;
        this.dialogues = new Dialogues(gamePanel, fontSize);
        loadInputsImage();

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


        if (gamePanel.getCharacterState() == GamePanel.CharacterState.Dialogo) {
            dialogues.drawDialogueScreen(g2);
            drawPrompt();
        } else if (gamePanel.getCharacterState() == GamePanel.CharacterState.Inventario) {
            drawInventory();


        } else if (gamePanel.getCharacterState() == GamePanel.CharacterState.Combate){
            drawCombate();
        }

        switch (gamePanel.currentCapitulo) {
            case Prologo:
                drawPrologo();
                break;
            case chapterFogo:
                drawFogo();
                break;
            case chapterAqua:
                drawAgua();
                break;
            case chapterEarth:
                drawTerra();
                break;
            case chapterAir:
                drawAr();
                break;
        }
        if(gamePanel.getGameState() != GamePanel.GameState.Menu){
            desenharMissao();
        }

    }

    public void update() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        // System.out.println(gamePanel.getPlayer().atualEntidade);
        //System.out.println(gamePanel.getCharacterState());
        //System.out.println("Estado do jogo: " + gamePanel.getGameState());

        if (gamePanel.getGameState() == GamePanel.GameState.Menu) {
            switch (gamePanel.currentCapitulo) {
                case Prologo:
                    updatePrologo(elapsedTime);
                    break;
                case chapterFogo:
                    //System.out.println("Atualizando Fogo");
                    updateFogo(elapsedTime);
                    break;
                case chapterAqua:
                    System.out.println("Atualizando Água");
                    updateAgua(elapsedTime);
                    break;
                case chapterEarth:
                    System.out.println("Atualizando Terra");
                    updateTerra(elapsedTime);
                    break;
                case chapterAir:
                    System.out.println("Atualizando Ar");
                    updateAr(elapsedTime);
                    break;
            }
        }
    }


    private void drawPrologo() {
        g2.setColor(new Color(255, 255, 255, prologoOpacity));
        printarTexto("PROLOGO");
    }

    private void updatePrologo(long elapsedTime) {
        if (elapsedTime >= duration && !fadingOutPrologo) {
            iniciarDesaparecimentoPrologo();
        }
        if (fadingOutPrologo) {
            prologoOpacity -= 5;
            if (prologoOpacity <= 0) {
                prologoOpacity = 0;
                System.out.println("prologo desaparece");
                gamePanel.setGameState(GamePanel.GameState.Jogando);
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

    private void iniciarDesaparecimentoPrologo() {
        fadingOutPrologo = true;
    }

    public boolean isPrologoDesaparecido() {
        return prologoOpacity == 0;
    }

    private void drawFogo() {
        g2.setColor(new Color(255, 100, 100, fogoOpacity));
        printarTexto("FOGO");
    }

    private void updateFogo(long elapsedTime) {

        if (elapsedTime >= duration && !fadingOutFogo) {
            iniciarDesaparecimentoFogo();

        }
        if (fadingOutFogo) {
            fogoOpacity -= 5;
            if (fogoOpacity <= 0) {
                fogoOpacity = 0;
                System.out.println("desapareceu fogo");
                gamePanel.setGameState(GamePanel.GameState.Jogando);
            }
        } else {
            if (fogoOpacity < 255) {
                fogoOpacity += 5;
                if (fogoOpacity >= 255) {
                    fogoOpacity = 255;
                }
            }
        }
    }

    private void iniciarDesaparecimentoFogo() {
        System.out.println("desaparecendo foogo");
        fadingOutFogo = true;
    }

    public boolean isFogoDesaparecido() {
        return fogoOpacity == 0;
    }

    private void drawAgua() {
        g2.setColor(new Color(100, 100, 255, aguaOpacity));
        printarTexto("AGUA");
    }

    private void updateAgua(long elapsedTime) {
        if (elapsedTime >= duration && !fadingOutAgua) {
            iniciarDesaparecimentoAgua();
        }
        if (fadingOutAgua) {
            aguaOpacity -= 5;
            if (aguaOpacity <= 0) {
                aguaOpacity = 0;
                gamePanel.setGameState(GamePanel.GameState.Jogando);
            }
        } else {
            if (aguaOpacity < 255) {
                aguaOpacity += 5;
                if (aguaOpacity >= 255) {
                    aguaOpacity = 255;
                }
            }
        }
    }

    private void iniciarDesaparecimentoAgua() {
        fadingOutAgua = true;
    }

    public boolean isAguaDesaparecido() {
        return aguaOpacity == 0;
    }

    private void drawTerra() {
        g2.setColor(new Color(150, 75, 0, terraOpacity));
        printarTexto("TERRA");
    }

    private void updateTerra(long elapsedTime) {
        if (elapsedTime >= duration && !fadingOutTerra) {
            iniciarDesaparecimentoTerra();
        }
        if (fadingOutTerra) {
            terraOpacity -= 5;
            if (terraOpacity <= 0) {
                terraOpacity = 0;
                gamePanel.setGameState(GamePanel.GameState.Jogando);
            }
        } else {
            if (terraOpacity < 255) {
                terraOpacity += 5;
                if (terraOpacity >= 255) {
                    terraOpacity = 255;
                }
            }
        }
    }



    private void iniciarDesaparecimentoTerra() {
        fadingOutTerra = true;
    }

    private void drawAr() {
        g2.setColor(new Color(200, 200, 255, arOpacity));
        printarTexto("AR");
    }

    private void updateAr(long elapsedTime) {
        if (elapsedTime >= duration && !fadingOutAr) {
            iniciarDesaparecimentoAr();
        }
        if (fadingOutAr) {
            arOpacity -= 5;
            if (arOpacity <= 0) {
                arOpacity = 0;
                gamePanel.setGameState(GamePanel.GameState.Jogando);
            }
        } else {
            if (arOpacity < 255) {
                arOpacity += 5;
                if (arOpacity >= 255) {
                    arOpacity = 255;
                }
            }
        }
    }

    private void resetTimer() {
        startTime = System.currentTimeMillis();
    }

    public void iniciarCapitulo() {
        switch (gamePanel.currentCapitulo) {
            case Prologo:
                prologoOpacity = 0;
                fadingOutPrologo = false;
                break;
            case chapterFogo:
                fogoOpacity = 0;
                fadingOutFogo = false;
                break;
            case chapterAqua:
                aguaOpacity = 0;
                fadingOutAgua = false;
                break;
            case chapterEarth:
                terraOpacity = 0;
                fadingOutTerra = false;
                break;
            case chapterAir:
                arOpacity = 0;
                fadingOutAr = false;
                break;
        }
        resetTimer();
    }

    private void iniciarDesaparecimentoAr() {
        fadingOutAr = true;
    }

    private void printarTexto(String text) {
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



    public void drawHealthAndManaBars(Graphics2D g2) {
        // Dimensões e posição das barras
        int barX = 50;
        int barY = 50;
        int barWidth = 200; // Largura total das barras
        int barHeight = 20; // Altura das barras
        int spacing = 10; // Espaçamento entre as barras

        // Calcula a largura proporcional da barra de vida baseada na vida atual
        int currentHealthBarWidth = (int) ((double) gamePanel.getPlayer().getVida() / gamePanel.getPlayer().vidaMaxima * barWidth);

        // Calcula a largura proporcional da barra de mana baseada na mana atual
        int currentManaBarWidth = (int) ((double) gamePanel.getPlayer().mana / gamePanel.getPlayer().manaMax * barWidth);

        // Desenha o contorno da barra de vida
        g2.setColor(Color.gray); // Cor do fundo da barra
        g2.fillRect(barX, barY, barWidth, barHeight);

        // Desenha a barra de vida atual
        g2.setColor(Color.red); // Cor da vida
        g2.fillRect(barX, barY, currentHealthBarWidth, barHeight);

        // Desenha o contorno da barra de vida
        g2.setColor(Color.black);
        g2.drawRect(barX, barY, barWidth, barHeight);

        // Texto da vida
        g2.setColor(Color.white);
        g2.setFont(maruMonica.deriveFont(Font.BOLD, 14)); // Fonte do texto
        String vidaTexto = gamePanel.getPlayer().getVida() + "/" + gamePanel.getPlayer().vidaMaxima;
        int vidaTextoX = barX + (barWidth - g2.getFontMetrics().stringWidth(vidaTexto)) / 2;
        int vidaTextoY = barY + barHeight - 5;
        g2.drawString(vidaTexto, vidaTextoX, vidaTextoY);

        // Posição da barra de mana (abaixo da barra de vida)
        int manaBarY = barY + barHeight + spacing;

        // Desenha o contorno da barra de mana
        g2.setColor(Color.gray); // Cor do fundo da barra
        g2.fillRect(barX, manaBarY, barWidth, barHeight);

        // Desenha a barra de mana atual
        g2.setColor(Color.blue); // Cor da mana
        g2.fillRect(barX, manaBarY, currentManaBarWidth, barHeight);

        // Desenha o contorno da barra de mana
        g2.setColor(Color.black);
        g2.drawRect(barX, manaBarY, barWidth, barHeight);

        // Texto da mana
        g2.setColor(Color.white);
        g2.setFont(maruMonica.deriveFont(Font.BOLD, 14)); // Fonte do texto
        String manaTexto = gamePanel.getPlayer().mana + "/" + gamePanel.getPlayer().manaMax;
        int manaTextoX = barX + (barWidth - g2.getFontMetrics().stringWidth(manaTexto)) / 2;
        int manaTextoY = manaBarY + barHeight - 5;
        g2.drawString(manaTexto, manaTextoX, manaTextoY);
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
    public void usarAtaqueSelecionado() {
        if (selectedOption == 0){  // 0 = golpe simples
            gamePanel.setAcao(0);
            System.out.println("golpe fraco");
        }
        else if (selectedOption == 1){
            System.out.println("golpe forte"); // 1 == golpe forte
            gamePanel.setAcao(1);
        } else if (selectedOption == 2) {
            gamePanel.setAcao(2);
            System.out.println("defendeu");
        }
    }


    public void drawCombate() {
        int screenWidth = gamePanel.getWidth();
        int screenHeight = gamePanel.getHeight();

        int frameWidth = gamePanel.tamanhoJanela * 5;
        int frameHeight = gamePanel.tamanhoJanela * 3;

        int frameX = (screenWidth - frameWidth) / 2;
        int frameY = screenHeight - frameHeight - 50;

        // Desenhe o quadro do combate
        g2.setColor(new Color(50, 50, 50, 200));
        g2.fillRoundRect(frameX, frameY, frameWidth, frameHeight, 10, 10);

        g2.setColor(Color.white);
        g2.drawRoundRect(frameX, frameY, frameWidth, frameHeight, 10, 10);

        // Título do combate
        g2.setColor(Color.white);
        g2.setFont(maruMonica.deriveFont(Font.BOLD, 25));
        String titulo = "Combate";
        int tituloWidth = g2.getFontMetrics().stringWidth(titulo);
        int tituloX = frameX + (frameWidth - tituloWidth) / 2;
        int tituloY = frameY + 30;
        g2.drawString(titulo, tituloX, tituloY);

        // Opções de combate
        g2.setFont(maruMonica.deriveFont(Font.PLAIN, 20)); // Fonte para as opções
        String[] opcoes = {"Golpe Fraco | Custo : 3 de mana", "Golpe Especial | Custo : 7 de mana", "Defender | + 5 de mana"};
        int opcaoYstart = frameY + 80; // Ponto de início vertical para as opções

        for (int i = 0; i < opcoes.length; i++) {
            String opcao = opcoes[i];
            int opcaoWidth = g2.getFontMetrics().stringWidth(opcao);
            int opcaoX = frameX + (frameWidth - opcaoWidth) / 2;
            int opcaoY = opcaoYstart + (i * 55); // Ajuste vertical entre opções
            g2.drawString(opcao, opcaoX, opcaoY);

            // Desenha a borda ao redor da opção selecionada
            if (i == selectedOption) { // 'selectedOption' deve ser uma variável que guarda a opção selecionada
                g2.setColor(Color.yellow);
                g2.drawRoundRect(opcaoX - 10, opcaoY - 20, opcaoWidth + 20, 30, 10, 10);
                g2.setColor(Color.white); // Restaura a cor branca para o texto
            }

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

    public void desenharMissao() {
        String missao = "";
        if (gamePanel.currentCapitulo == GamePanel.Capitulos.Prologo) {
            missao = "Missão: Fale com o Elder.";
        } else if (gamePanel.currentCapitulo == GamePanel.Capitulos.chapterFogo) {
            missao = "Missão: Encontre os monstros infiltrados na vila.";
        } else if (gamePanel.currentCapitulo == GamePanel.Capitulos.chapterAqua) {
            missao = "Missão: Limpe a fonte da vila.";
        } else if (gamePanel.currentCapitulo == GamePanel.Capitulos.chapterEarth) {
            missao = "Missão: Construa a defesa da vila.";
        } else if (gamePanel.currentCapitulo == GamePanel.Capitulos.chapterAir) {
            missao = "Missão: Investigue o templo do vento.";
        }

        g2.setFont(maruMonica.deriveFont(Font.PLAIN, 19));
        g2.setColor(Color.WHITE);
        int x = 50; // Posição x do texto
        int y = gamePanel.alturaTela - 50;
        g2.drawString(missao, x, y);
    }

    private void loadInputsImage(){
        try{
            enterImage = ImageIO.read(getClass().getResourceAsStream("/prompts/enter.png"));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private void drawPrompt() {
        BufferedImage promptImage = enterImage;
        if (promptImage != null) {
            int promptX = gamePanel.larguraTela - promptImage.getWidth() - gamePanel.tamanhoJanela;
            int promptY = gamePanel.alturaTela - promptImage.getHeight() - gamePanel.tamanhoJanela;
            g2.drawImage(promptImage, promptX, promptY, gamePanel.tamanhoJanela, gamePanel.tamanhoJanela/2,null);
        }
    }

}