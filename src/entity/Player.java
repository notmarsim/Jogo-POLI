package entity;
import main.GamePanel;
import main.KeyHandler;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
     private KeyHandler keyH;
     private GamePanel gp;
     public int screenX;
     public int screenY;

     public Player(GamePanel gp, KeyHandler keyH) {
          this.gp = gp;
          this.keyH = keyH;
          setDefaultValues();

     }

     protected void setDefaultValues() {
          worldX = gp.tamanhoJanela*10;
          worldY = gp.tamanhoJanela*10;
          direcao = "frente";
          screenX = gp.larguraTela / 2 - (gp.tamanhoJanela/2);
          screenY = gp.alturaTela / 2 - (gp.tamanhoJanela/2);

     }

     public void update() {
          if (keyH.upPressed) {

               if (direcao.equals("frente")) {
                    direcao = "frente";
               } else if(direcao.equals("costas")) {
                    direcao = "costas";
               }

               movimentacao = "movendo";
               worldY = worldY - speed;
          } else if (keyH.downPressed) {
               if (direcao.equals("frente")) {
                    direcao = "frente";
               } else if(direcao.equals("costas")) {
                    direcao = "costas";
               }
               movimentacao = "movendo";
               worldY = worldY + speed;
          } else if (keyH.leftPressed) {
               direcao = "costas";
               movimentacao = "movendo";
               worldX = worldX - speed;
          } else if (keyH.rightPressed) {
               direcao = "frente";
               worldX = worldX + speed;
               movimentacao = "movendo";
          } else {
               movimentacao = "parado";

          }

          spriteCounter++;
          if (spriteCounter >= 6) {
               spriteCounter = 0; // Reiniciar contador
               spriteNum++; // Avançar para o próximo sprite
               if (spriteNum > 7) {
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
                         image = idle5;
                    } else if (direcao.equals("costas")) {
                         image = idle5back;
                    }
               } else if(spriteNum==6) {
                    if (direcao.equals("frente")) {
                         image = idle6;

                    } else if (direcao.equals("costas")) {
                         image = idle6back;
                    }

               } else if (spriteNum ==7) {
                    if(direcao.equals("frente")) {
                         image = idle7;
                    } else if (direcao.equals("costas")) {
                         image = idle6back;
                    }
               } else if (spriteNum ==8) {
                    if(direcao.equals("frente")) {
                         image = idle8;
                    } else if (direcao.equals("costas")) {
                         image = idle6back;
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
                    } else if (spriteNum == 6) {
                         image = run6;
                    } else if (spriteNum ==7) {
                         image = run7;
                    }
               } else if (direcao.equals("costas")) {
                    if (spriteNum == 1) {
                         image = runcostas;
                    } else if (spriteNum == 2) {
                         image = runcostas2;
                    } else if (spriteNum == 3) {
                         image = runcostas3;
                    } else if (spriteNum == 4) {
                         image = runcostas4;
                    } else if (spriteNum == 5) {
                         image = runcostas5;
                    } else if (spriteNum == 6 ) {
                         image  = runcostas6;
                    } else if (spriteNum == 7) {
                         image =runcostas7;
                    }
               }
          }

          g2.drawImage(image, screenX, screenY, (gp.tamanhoJanela), (gp.tamanhoJanela), null);

     }
}
