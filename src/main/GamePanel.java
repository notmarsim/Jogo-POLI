package main;

import capitulos.Prologo;
import entity.Pyroth;
import gfx.Camera;
import mapas.Maps;

import javax.swing.*;
import java.awt.*;
import UI.UI;

public class GamePanel extends JPanel implements Runnable {
    private Maps currentMap;
    private Prologo prologo;
    private UI ui;

    public enum Capitulos {
        Prologo,
        chapter1,
        chapter2
    }

    public Capitulos currentCapitulo = Capitulos.Prologo;

    public enum GameState {
        Menu,
        Pausado,
        Dialogo,
        Combate
    }

    public GameState gameState = GameState.Menu;

    public void setGameState(GameState newState) {
        this.gameState = newState;
    }

    public GameState getGameState() {
        return gameState;
    }

    final int tamanhooriginalJanelax = 16;
    final int escala = 5;
    public final int tamanhoJanela = tamanhooriginalJanelax * escala;
    public final int tamanhomaxX = 16;
    public final int tamanhomaxY = 12;
    public final int larguraTela = tamanhomaxX * tamanhoJanela;
    public final int alturaTela = tamanhomaxY * tamanhoJanela;

    int fps = 60;

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();

    // camera
    Camera camera = new Camera(this, 0, 0);

    public Camera getCamera() {
        return camera;
    }

    public GamePanel() {
        this.setPreferredSize(new Dimension(larguraTela, alturaTela));
        this.setBackground(Color.BLACK);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.prologo = new Prologo(this, keyH);
        this.ui = new UI(this, 80);
        setChapter(Capitulos.Prologo);
    }

    public void setChapter(Capitulos chapter) {
        this.currentCapitulo = chapter;
        switch (chapter) {
            case Prologo:
                this.currentMap = prologo.getMap();
                break;
            // Outros casos para outros capítulos
        }
    }

    public Maps getCurrentMap() {
        return currentMap;
    }

    public void iniciarGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    // loop principal do game
    public void run() {
        long horaAtual = System.nanoTime();

        while (gameThread != null) {  //update para atualizar info e paint para desenhar

            double drawInterval = 1000000000 / fps;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;
            while (gameThread != null) {
                currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval;
                lastTime = currentTime;

                if (delta >= 1) {
                    update();
                    repaint();
                    delta--;
                }
            }
        }
    }

    public void update() {
        if (currentCapitulo == Capitulos.Prologo) {
            prologo.up();
        }
    }

    // pintar
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (currentCapitulo == Capitulos.Prologo) {
            if (gameState == GameState.Dialogo) {
                prologo.draw(g2);
                ui.draw(g2); // Desenha o diálogo em cima do prólogo
            } else {
                prologo.draw(g2);
            }
        }

        g2.dispose();
    }
}