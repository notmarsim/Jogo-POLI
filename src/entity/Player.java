package entity;
import main.GamePanel;
import main.KeyHandler;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Player extends Entity {
     private KeyHandler keyH;
     private GamePanel gp;

     public Player(GamePanel gp, KeyHandler keyH) {
          this.gp = gp;
          this.keyH = keyH;
          setDefaultValues();
     }

     protected void setDefaultValues() {
          x = 100;
          y = 100;
          speed = 4;
          direcao = "frente";
     }

     public void update() {
          if (keyH.upPressed) {

               if (direcao.equals("frente")) {
                    direcao = "frente";
               } else if(direcao.equals("costas")) {
                    direcao = "costas";
               }

               movimentacao = "movendo";
               y = y - speed;
          } else if (keyH.downPressed) {
               if (direcao.equals("frente")) {
                    direcao = "frente";
               } else if(direcao.equals("costas")) {
                    direcao = "costas";
               }
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

          if (movimentacao != null && movimentacao.equals("parado")) {
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
