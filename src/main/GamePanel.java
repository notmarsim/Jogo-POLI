package main;

import Objetos.PocaoForca;
import Objetos.SuperObject;
import capitulos.Prologo;
import entity.Player;
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
        Jogando
    }

    public enum CharacterState {
        Dialogo,
        Inventario,
        Combate,
        Ocioso
    }

    private CharacterState characterState = CharacterState.Ocioso;

    public void setCharacterState(CharacterState newState) {
        this.characterState = newState;
        repaint();
    }

    public CharacterState getCharacterState() {
        return characterState;
    }

    public GameState gameState = GameState.Menu;

    public void setGameState(GameState newState) {
        this.gameState = newState;
        repaint();
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
    KeyHandler keyH = new KeyHandler(this);
    private static Player player;
    private SuperObject superObject;

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
        player = new Player(this,keyH);
        this.ui = new UI(this, 80);
        this.prologo = new Prologo(this, keyH);
        setChapter(Capitulos.Prologo);
    }

    public Player getPlayer() {
        return player;
    }

    public UI getUi() {
        return ui;
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
            prologo.draw(g2);
        }

        if (gameState == GameState.Jogando) {
            ui.drawHealthBar(g2);
            if (characterState == CharacterState.Inventario) {
                ui.draw(g2);
            } else if (characterState == CharacterState.Dialogo) {
                ui.draw(g2);
            }
        }
        g2.dispose();
    }
}
