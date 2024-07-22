package main;

import Objetos.SuperObject;
import capitulos.*;
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
    private ChapterTerra chapterTerra;
    private ChapterAqua chapterAqua;
    private ChapterAr chapterAr;
    private ChapterVoid chapterVoid;
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
        chapterAr,
        chapterEarth,
        chapterVoid
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
        Ocioso,
        Profile,
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
        this.chapterAqua = new ChapterAqua(this,keyH);
        this.chapterAr = new ChapterAr(this,keyH);
        this.chapterVoid = new ChapterVoid(this,keyH);
        this.chapterTerra = new ChapterTerra(this,keyH);
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
            case chapterAqua:
                this.currentMap = chapterAqua.getMap();
                break;
            case chapterAr:
                this.currentMap = chapterAr.getMap();
                break;
            case chapterEarth:
                this.currentMap = chapterTerra.getMap();
                break;
            case chapterVoid:
                this.currentMap = chapterVoid.getMap();
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
        //System.out.println("xp :" + getPlayer().getXp() +" level :" + getPlayer().getLevel() + " xp max: " + getPlayer().xpMax);
        if (currentCapitulo == Capitulos.Prologo) {
            prologo.up();
        } else if (currentCapitulo == Capitulos.chapterFogo) {
            chapterFogo.up();
        } else if (currentCapitulo == Capitulos.chapterAqua) {
            chapterAqua.up();
        } else if (currentCapitulo == Capitulos.chapterAr){
            chapterAr.up();
        } else if(currentCapitulo == Capitulos.chapterEarth){
            chapterTerra.up();
        } else if (currentCapitulo == Capitulos.chapterVoid){
            chapterVoid.up();
        }

    }


    // pintar
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (currentCapitulo == Capitulos.Prologo) {
            prologo.draw(g2);
        }else if (currentCapitulo == Capitulos.chapterFogo) {
            chapterFogo.draw(g2);
        } else if (currentCapitulo == Capitulos.chapterAqua) {
            chapterAqua.draw(g2);
        } else if(currentCapitulo == Capitulos.chapterAr){
            chapterAr.draw(g2);
        }  else if(currentCapitulo == Capitulos.chapterEarth){
            chapterTerra.draw(g2);
        } else if (currentCapitulo == Capitulos.chapterVoid){
            chapterVoid.draw(g2);
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
            }else if (characterState == characterState.Profile){
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