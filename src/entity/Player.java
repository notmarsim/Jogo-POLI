package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
     private KeyHandler keyH;
     private GamePanel gp;
     private String movimentacao;
     private int spriteCounter;
     private int spriteNum;

     private BufferedImage idle, idle2, idle3, idle4, run, run2, run3, run4, run5, costas, costas2, costas3, costas4, costas5, idleback, idle2back, idle3back, idle4back;

     public Player(GamePanel gp, KeyHandler keyH) {
          this.gp = gp;
          this.keyH = keyH;
          setDefaultValues();
          getPlayerImage();
     }

     private void setDefaultValues() {
          x = 100;
          y = 100;
          speed = 4;
          direcao = "frente";
          movimentacao = "parado";
          spriteCounter = 0;
          spriteNum = 1;
     }

     private void getPlayerImage() {
          try {
               idle = ImageIO.read(getClass().getResourceAsStream("/player/idle1.png"));
               idle2 = ImageIO.read(getClass().getResourceAsStream("/player/idle2.png"));
               idle3 = ImageIO.read(getClass().getResourceAsStream("/player/idle3.png"));
               idle4 = ImageIO.read(getClass().getResourceAsStream("/player/idle4.png"));
               run = ImageIO.read(getClass().getResourceAsStream("/player/run.png"));
               run2 = ImageIO.read(getClass().getResourceAsStream("/player/run2.png"));
               run3 = ImageIO.read(getClass().getResourceAsStream("/player/run3.png"));
               run4 = ImageIO.read(getClass().getResourceAsStream("/player/run4.png"));
               run5 = ImageIO.read(getClass().getResourceAsStream("/player/run5.png"));
               costas = ImageIO.read(getClass().getResourceAsStream("/player/back.png"));
               costas2 = ImageIO.read(getClass().getResourceAsStream("/player/back2.png"));
               costas3 = ImageIO.read(getClass().getResourceAsStream("/player/back3.png"));
               costas4 = ImageIO.read(getClass().getResourceAsStream("/player/back4.png"));
               costas5 = ImageIO.read(getClass().getResourceAsStream("/player/back5.png"));
               idleback = ImageIO.read(getClass().getResourceAsStream("/player/idleback.png"));
               idle2back = ImageIO.read(getClass().getResourceAsStream("/player/idle2back.png"));
               idle3back = ImageIO.read(getClass().getResourceAsStream("/player/idle3back.png"));
               idle4back = ImageIO.read(getClass().getResourceAsStream("/player/idle4back.png"));

          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     public void update() {
          if (keyH.upPressed) {
               direcao = "frente";
               movimentacao = "movendo";
               y = y - speed;
          } else if (keyH.downPressed) {
               direcao = "frente";
               movimentacao = "movendo";
               y = y + speed;
          } else if (keyH.leftPressed) {
               direcao = "costas";
               movimentacao = "movendo";
               x = x - speed;
          } else if (keyH.rightPressed) {
               direcao = "frente";
               x = x + speed;
               movimentacao = "movendo";
          } else {
               movimentacao = "parado";
          }
          spriteCounter++;
          if (spriteCounter >= 5) {
               spriteCounter = 0; // Reiniciar contador
               spriteNum++; // Avançar para o próximo sprite
               if (spriteNum > 5) {
                    spriteNum = 1; // Reiniciar a sequência de sprites
               }
          }
     }

     public void draw(Graphics2D g2) {
          BufferedImage image = null;

          if (movimentacao.equals("parado")) {
               if (spriteNum == 1) {
                    if (direcao.equals("frente")) {
                         image = idle;
                    } else if (direcao.equals("costas")) {
                         image = idleback;
                    }
               } else if (spriteNum == 2) {
                    if (direcao.equals("frente")) {
                         image = idle2;
                    } else if (direcao.equals("costas")) {
                         image = idle2back;
                    }
               } else if (spriteNum == 3) {
                    if (direcao.equals("frente")) {
                         image = idle3;
                    } else if (direcao.equals("costas")) {
                         image = idle3back;
                    }
               } else if (spriteNum == 4) {
                    if (direcao.equals("frente")) {
                         image = idle4;
                    } else if (direcao.equals("costas")) {
                         image = idle4back;
                    }
               } else if (spriteNum == 5) {
                    if (direcao.equals("frente")) {
                         image = idle;
                    } else if (direcao.equals("costas")) {
                         image = idleback;
                    }
               }
          } else {
               if (direcao.equals("frente")) {
                    if (spriteNum == 1) {
                         image = run;
                    } else if (spriteNum == 2) {
                         image = run2;
                    } else if (spriteNum == 3) {
                         image = run3;
                    } else if (spriteNum == 4) {
                         image = run4;
                    } else if (spriteNum == 5) {
                         image = run5;
                    }
               } else if (direcao.equals("costas")) {
                    if (spriteNum == 1) {
                         image = costas;
                    } else if (spriteNum == 2) {
                         image = costas2;
                    } else if (spriteNum == 3) {
                         image = costas3;
                    } else if (spriteNum == 4) {
                         image = costas4;
                    } else if (spriteNum == 5) {
                         image = costas5;
                    }
               }
          }

          g2.drawImage(image, x, y, gp.tamanhoJanela, gp.tamanhoJanela, null);
     }
}
