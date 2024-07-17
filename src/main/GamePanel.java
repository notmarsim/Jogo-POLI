package main;

import Objetos.SuperObject;
import capitulos.ChapterFogo;
import capitulos.Prologo;
import entity.Combate;
import UI.Dialogues;
import entity.EntityManager;
import entity.Player;
import gfx.Camera;
import mapas.Maps;

import javax.swing.*;
import java.awt.*;
import UI.UI;

public class GamePanel extends JPanel implements Runnable {
    private Maps currentMap;
    private Prologo prologo;
    private ChapterFogo chapterFogo;
    private UI ui;
    KeyHandler keyH = new KeyHandler(this);
    Player player = new Player(this,keyH);
    EntityManager entityManager = new EntityManager(this,player);
    private Combate combate;
    public Dialogues dialogues;
    private Sound sound = new Sound();

    // combate
    public boolean lutando;
    public boolean defendendo;


    public enum Capitulos {
        Prologo,
        chapterFogo,
        chapterAqua,
        chapterAir,
        chapterEarth
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
    private SuperObject superObject;

    // camera
    Camera camera = new Camera(this, 0, 0);

    public Camera getCamera() {
        return camera;
    }

    // COMBATE

    public GamePanel() {
        this.setPreferredSize(new Dimension(larguraTela, alturaTela));
        this.setBackground(Color.BLACK);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        dialogues = new Dialogues(this,25);
        this.ui = new UI(this, 80);
        this.prologo = new Prologo(this, keyH);
        this.chapterFogo = new ChapterFogo(this,keyH);
        setChapter(Capitulos.Prologo);
        this.combate = new Combate(this,player.atualEntity);

    }
    public Combate getCombate(){
        return combate;
    }

    public Dialogues getDialogues(){
        return dialogues;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Player getPlayer() {
        return player;
    }

    public UI getUi() {
        return ui;
    }


    public void setChapter(Capitulos chapter) {
        this.currentCapitulo = chapter;
        ui.iniciarCapitulo();
        switch (chapter) {
            case Prologo:
                this.currentMap = prologo.getMap();
                break;
            case chapterFogo:
                //playMusic(1);
                this.currentMap = chapterFogo.getMap();
                break;
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
        getPlayer().subirDeLevel();
        System.out.println("xp :" + getPlayer().getXp() +" level :" + getPlayer().getLevel() + " xp max: " + getPlayer().xpMax);
        if (currentCapitulo == Capitulos.Prologo) {

            prologo.up();


        }
        if (currentCapitulo == Capitulos.chapterFogo) {
            chapterFogo.up();

        }

    }


    // pintar
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (currentCapitulo == Capitulos.Prologo) {
            prologo.draw(g2);
        }

        if (currentCapitulo == Capitulos.chapterFogo) {
            chapterFogo.draw(g2);
        }

        if (gameState == GameState.Jogando) {
            //ui.drawHealthBar(g2);
            ui.drawHealthAndManaBars(g2);
            ui.desenharMissao();
            if (characterState == CharacterState.Inventario) {
                ui.draw(g2);
            } else if (characterState == CharacterState.Dialogo) {
                ui.draw(g2);
                dialogues.drawDialogueScreen(g2);
            } else if (characterState == CharacterState.Combate) {
                ui.draw(g2);
            }
        }
        g2.dispose();
    }

    public void setAcao(int acao){
        if(acao == 0){
            getCombate().golpeSimples = true;
        } else if (acao == 1) {
            getCombate().golpeEspecial = true;
        } else if (acao == 2) {
           defendendo = true;
        }
    }

    public void playMusic(int i) {
        synchronized (sound) {
            sound.setFile(i);
            sound.play();
            sound.loop();
        }
    }

    public void stopMusic() {
        synchronized (sound) {
            sound.stop();
        }
    }

    public void playMusicSemLoop(int i) {
        synchronized (sound) {
            sound.setFile(i);
            sound.play();
        }
    }
}