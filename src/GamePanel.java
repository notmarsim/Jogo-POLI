import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{ // subclasse jframe , config de tela, tempo tambem

    final int tamanhooriginalJanela = 16; // bloco / janela = 16x16
    final int escala = 3;
    final int tamanhoJanela = tamanhooriginalJanela*escala; // 48x48 cada janela
    final int tamanhomaxX = 16;
    final int tamanhomaxY = 12;
    final int larguraTela = tamanhomaxX*tamanhoJanela; // 768px
    final int alturaTela = tamanhomaxY*tamanhoJanela;

    int fps = 60;

    Thread gameThread;
    KeyHandler keyH = new KeyHandler();

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(larguraTela,alturaTela));
        this.setBackground(Color.BLACK);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void iniciargameThread() {
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

        System.out.println("funcionando");
        if(keyH.upPressed == true) {
            playerY = playerY - playerSpeed;
            
        } else if(keyH.downPressed == true) {
            playerY = playerY + playerSpeed;
        } else if (keyH.leftPressed) {
            playerX = playerX - playerSpeed;
        } else if (keyH.rightPressed == true) {
            playerX = playerX + playerSpeed;
        }

    }
// pintar
    public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.white);
            g2.fillRect( playerX,playerY,tamanhoJanela,tamanhoJanela);
            g2.dispose();
    }
}

