package main;


import entity.Pyroth;
import entity.Aeris;
import entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{ // subclasse jframe , config de tela, tempo tambem





    final int tamanhooriginalJanelax = 16;
    final int escala = 5;
    public final int tamanhoJanela = tamanhooriginalJanelax *escala; //
    public final int tamanhomaxX = 16;
    public final int tamanhomaxY = 12;
    public final int larguraTela = tamanhomaxX*tamanhoJanela;
    final int alturaTela = tamanhomaxY*tamanhoJanela;

    TileManager tileManager = new TileManager(this);
    int fps = 60;

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();

    // Personagens
    Aeris aeris = new Aeris(this,keyH);
    Pyroth pyroth = new Pyroth(this,keyH);



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

    public void update() {
        Player jogadorEscolhido;
        boolean jogadorEscolheuMago = false;
        if (jogadorEscolheuMago) {
            jogadorEscolhido = aeris;
        } else {
            jogadorEscolhido = pyroth;
        }

        jogadorEscolhido.update();
    }

  // pintar
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        tileManager.draw(g2);
        pyroth.draw(g2);
        g2.dispose();
    }
}

