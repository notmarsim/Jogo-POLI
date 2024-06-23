package entity;
import main.GamePanel;
import main.KeyHandler;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Player extends Entity {
     private KeyHandler keyH;
     private int xp;
     private Combate combate;
     public ArrayList<String> inventario = new ArrayList<String>();
     public final int inventarioSize = 20;

     public Player(GamePanel gp, KeyHandler keyH) {
          super(gp);
          this.keyH = keyH;
          setDefaultValues();
          bounds = new Rectangle();
          direcao = "frente";
          this.combate = new Combate(vida,dano);

     }

     public boolean iniciarCombate(int x, int y) {
          Point posicaoCombate = gp.getCurrentMap().findTileCoordinates(4);
          if (posicaoCombate != null && posicaoCombate.equals(new Point(x, y))) {
               combate.iniciarTurnoCombate(vida,dano);
               return true;
          }
          return false;
     }

     public boolean iniciarDialogo(int x, int y) {
          Point posicaoDialogo = gp.getCurrentMap().findTileCoordinates(3);
          if (posicaoDialogo != null && posicaoDialogo.equals(new Point(x, y))) {
               gp.setCharacterState(GamePanel.CharacterState.Dialogo);
               return true;
          }
          return false;
     }

     public void setItems() {
          inventario.add(currentWeapon);
          inventario.add(currentShield);
     }





     protected boolean collisionWithTile(int x, int y) {
          return gp.getCurrentMap().getTile(x,y).isSolid();
     }

     protected void setDefaultValues() {
          x = gp.tamanhoJanela*15;
          y = gp.tamanhoJanela*18;
          vida = 20;
          dano = 5;

     }

     public void update() {
          if (keyH.upPressed) {
               if(direcao=="frente"){
                    direcao = "frente";
               } else {
                    direcao = "costas";
               }
               movimentacao = "movendo";

               int ty = (int) ((y - speed + bounds.y) / Tile.tileHeight);
               if (!collisionWithTile((int) ((x + bounds.x) / Tile.tileWidth), ty) &&
                       !collisionWithTile((int) ((x + bounds.x + bounds.width) / Tile.tileWidth), ty)) {
                    y = y - speed;
               }
          } else if (keyH.downPressed) {
               if(direcao=="frente") {
                    direcao = "frente";
               } else {
                    direcao = "costas";
               }
               movimentacao = "movendo";

               int by = (int) ((y + speed + bounds.y + bounds.height) / Tile.tileHeight);
               if (!collisionWithTile((int) ((x + bounds.x) / Tile.tileWidth), by) &&
                       !collisionWithTile((int) ((x + bounds.x + bounds.width) / Tile.tileWidth), by)) {
                    y = y + speed;
               }
          } else if (keyH.leftPressed) {
               direcao = "costas";
               movimentacao = "movendo";

               int tx = (int) ((x - speed + bounds.x) / Tile.tileWidth);
               if (!collisionWithTile(tx, (int) ((y + bounds.y) / Tile.tileHeight)) &&
                       !collisionWithTile(tx, (int) ((y + bounds.y + bounds.height) / Tile.tileHeight))) {
                    x = x - speed;
               }
          } else if (keyH.rightPressed) {
               direcao = "frente";
               movimentacao = "movendo";

               int bx = (int) ((x + speed + bounds.x + bounds.width) / Tile.tileWidth);
               if (!collisionWithTile(bx, (int) ((y + bounds.y) / Tile.tileHeight)) &&
                       !collisionWithTile(bx, (int) ((y + bounds.y + bounds.height) / Tile.tileHeight))) {
                    x = x + speed;
               }
          } else {
               movimentacao = "parado";
          }

          iniciarCombate((int) x / Tile.tileWidth, (int) y / Tile.tileHeight);
          iniciarDialogo(x/Tile.tileWidth,y/Tile.tileHeight);
          spriteCounter++;
          if (spriteCounter >= 5) {
               spriteCounter = 0; // Reiniciar contador
               spriteNum++; // Avançar para o próximo sprite
               if (spriteNum > 7) {
                    spriteNum = 1; // Reiniciar a sequência de sprites
               }
          }
          gp.getCamera().centerOnEntity(this);
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

          g2.drawImage(image,
                  (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela * 9) / 4),
                  (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela * 10) / 3),
                  gp.tamanhoJanela * 4,
                  gp.tamanhoJanela * 4,
                  null);


     }
}