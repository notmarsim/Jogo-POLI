package main;

import Objetos.SuperObject;
import capitulos.*;
import entity.*;
import UI.Dialogues;
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
    private Pyroth pyroth;
    private Aquara aquara;
    private Aeris aeris;
    private Terranis terranis;
    private UI ui;
    KeyHandler keyH = new KeyHandler(this);
    Player player = new Player(this, keyH);
    EntityManager entityManager = new EntityManager(this, player);
    private Combate combate;
    public Dialogues dialogues;
    private Sound sound = new Sound();

    // combate
    public boolean atacando;
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
        Morto,
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
        dialogues = new Dialogues(this, 25);
        this.ui = new UI(this, 80);
        setChapter(Capitulos.Prologo);
        this.combate = new Combate(this, player.atualEntity);
    }

    public Combate getCombate() {
        return combate;
    }

    public Dialogues getDialogues() {
        return dialogues;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Player getPlayer() {
        System.out.println(player);
        return player;
    }


    public UI getUi() {
        return ui;
    }

    public void setPlayer(Player player){
        this.player = player;
    }


    public void setChapter(Capitulos chapter) {
        this.currentCapitulo = chapter;
        ui.iniciarCapitulo();
        switch (chapter) {
            case Prologo:
                if (prologo == null) {
                    setPlayer(new Pyroth(this,keyH));
                    prologo = new Prologo(this, keyH);
                }
                this.currentMap = prologo.getMap();
                break;
            case chapterFogo:
                if (chapterFogo == null) {
                    if(pyroth == null){
                        pyroth = new Pyroth(this,keyH);
                    }
                    setPlayer(pyroth);
                    pyroth.x = tamanhoJanela * 2;
                    pyroth.y = tamanhoJanela * 18;
                    chapterFogo = new ChapterFogo(this, keyH);
                } else {
                    setPlayer(pyroth);
                }
                this.currentMap = chapterFogo.getMap();
                break;
            case chapterAqua:
                if (chapterAqua == null) {
                    if(aquara == null){
                        aquara = new Aquara(this,keyH);
                    }
                    setPlayer(aquara);
                    chapterAqua = new ChapterAqua(this, keyH);
                } else {
                    setPlayer(aquara);
                }
                this.currentMap = chapterAqua.getMap();
                break;
            case chapterAr:
                if (chapterAr == null) {
                    if(aeris == null){
                        aeris = new Aeris(this,keyH);
                    }
                    setPlayer(aeris);
                    chapterAr = new ChapterAr(this, keyH);
                } else {
                    setPlayer(aeris);
                }
                this.currentMap = chapterAr.getMap();
                break;
            case chapterEarth:
                if (chapterTerra == null) {
                    if(terranis == null){
                        terranis = new Terranis(this,keyH);
                    }
                    setPlayer(terranis);
                    terranis.x = tamanhoJanela * 25;
                    terranis.y = tamanhoJanela * 2;
                    chapterTerra = new ChapterTerra(this, keyH);
                } else {
                    setPlayer(terranis);
                }
                this.currentMap = chapterTerra.getMap();
                break;
            case chapterVoid:
                if (chapterVoid == null) {
                    if(aeris == null){
                        aeris = new Aeris(this,keyH);
                    }
                    setPlayer(aeris);
                    aeris.x = 200;
                    aeris.y=900;
                    chapterVoid = new ChapterVoid(this, keyH);
                } else{
                    setPlayer(aeris);
                }
                this.currentMap = chapterVoid.getMap();
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
        // System.out.println("xp :" + getPlayer().getXp() +" level :" + getPlayer().getLevel() + " xp max: " + getPlayer().xpMax);

        switch (currentCapitulo) {
            case Prologo:
                if (prologo != null) {
                    prologo.up();
                }
                break;
            case chapterFogo:
                if (chapterFogo != null) {
                    chapterFogo.up();
                }
                break;
            case chapterAqua:
                if (chapterAqua != null) {
                    chapterAqua.up();
                }
                break;
            case chapterAr:
                if (chapterAr != null) {
                    chapterAr.up();
                }
                break;
            case chapterEarth:
                if (chapterTerra != null) {
                    chapterTerra.up();
                }
                break;
            case chapterVoid:
                if (chapterVoid != null) {
                    chapterVoid.up();
                }
                break;
        }
    }

    // pintar
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        switch (currentCapitulo) {
            case Prologo:
                if (prologo != null) {
                    prologo.draw(g2);
                }
                break;
            case chapterFogo:
                if (chapterFogo != null) {
                    chapterFogo.draw(g2);
                }
                break;
            case chapterAqua:
                if (chapterAqua != null) {
                    chapterAqua.draw(g2);
                }
                break;
            case chapterAr:
                if (chapterAr != null) {
                    chapterAr.draw(g2);
                }
                break;
            case chapterEarth:
                if (chapterTerra != null) {
                    chapterTerra.draw(g2);
                }
                break;
            case chapterVoid:
                if (chapterVoid != null) {
                    chapterVoid.draw(g2);
                }
                break;
        }

        if (gameState == GameState.Jogando) {
            ui.desenharMensagem();
            ui.drawHealthAndManaBars(g2);
            ui.desenharMissao();
            if (characterState == CharacterState.Inventario) {
                ui.draw(g2);
            } else if (characterState == CharacterState.Dialogo) {
                ui.draw(g2);
                dialogues.drawDialogueScreen(g2);
            } else if (characterState == CharacterState.Combate) {
                ui.draw(g2);
            } else if (characterState == CharacterState.Profile) {
                ui.draw(g2);
            } else if (characterState==CharacterState.Morto) {
                ui.draw(g2);
            }
        }
        g2.dispose();
    }

    public void setAcao(int acao) {
        if (acao == 0) {
            getCombate().golpeSimples = true;
        } else if (acao == 1) {
            getCombate().golpeEspecial = true;
        } else if (acao == 2) {
            getCombate().defendendo = true;
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
