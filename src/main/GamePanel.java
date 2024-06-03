package main;


import capitulos.Prologo;
import entity.Aquara;
import entity.Pyroth;
import entity.Aeris;

import entity.Terranis;
import gfx.Camera;
import mapas.Maps;
import tile.Tile;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{ // subclasse jframe , config de tela, tempo tambem

    public enum Capitulos {
        Prologo,
        chapter1,
        chapter2
    }

    public Capitulos currentCapitulo = Capitulos.Prologo;


    final int tamanhooriginalJanelax = 16;
    final int escala = 5;
    public final int tamanhoJanela = tamanhooriginalJanelax *escala; //
    public final int tamanhomaxX = 16;
    public final int tamanhomaxY = 12;
    public final int larguraTela = tamanhomaxX*tamanhoJanela;
    public final int alturaTela = tamanhomaxY*tamanhoJanela;



    int fps = 60;

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();

    // camera
    Camera camera = new Camera(this,0,0);
    public Camera getCamera() {
        return camera;
    }

    // Personagens
    Aeris aeris = new Aeris(this,keyH);
    Pyroth pyroth = new Pyroth(this,keyH);
    Aquara aquara = new Aquara(this,keyH);
    Terranis terranis = new Terranis(this,keyH);



    public GamePanel() {
        this.setPreferredSize(new Dimension(larguraTela,alturaTela));
        this.setBackground(Color.BLACK);
        this.addKeyListener(keyH);
        this.setFocusable(true);

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

            double drawInterval = 1000000000 / fps ;
            double delta = 0 ;
            long lastTime = System.nanoTime();
            long currentTime;
            while (gameThread!=null) {
                currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval ;
                lastTime = currentTime;

                if (delta>=1) {
                    update();
                    repaint();
                    delta--;
                }
            }

        }

    }

    Prologo prologo = new Prologo(this,keyH);


    public void update() {
        if(currentCapitulo == Capitulos.Prologo) {
            System.out.println("PROLOGO");
            prologo.up();

        }
    }

    // pintar
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        if(currentCapitulo == Capitulos.Prologo) {

            prologo.draw(g2);

        }

        g2.dispose();
    }
}
