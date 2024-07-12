package entity;
import Objetos.PocaoCura;
import Objetos.PocaoForca;
import Objetos.SuperObject;
import main.GamePanel;
import main.KeyHandler;
import tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity {
     private KeyHandler keyH;
     public int xp;
     private Combate combate;
     public ArrayList<SuperObject> inventario = new ArrayList<SuperObject>();
     public final int maxInventarioSize = 20;
     public int attackSpriteCounter = 0;
     public int attackSpriteNum = 1;
     public Entity atualEntity;
     public int mana,manaMax;
     public int xpMax;


     public Player(GamePanel gp, KeyHandler keyH) {
          super(gp);
          this.keyH = keyH;
          setDefaultValues();
          bounds = new Rectangle();
          direcao = "frente";
          setItems();

     }

     public void alinharPersonagensCombate(Entity entity){
          y = entity.y + gp.tamanhoJanela * 33 / 10;
          x = entity.x + gp.tamanhoJanela * 12 / 10;
     }

     public void iniciarCombate(Entity entity) {
          //System.out.println(entity.x);
          //System.out.println(entity);
          gp.getPlayer().atualEntity = entity;
          combate = new Combate(gp, entity);
          entity.x += (gp.tamanhoJanela);
     }

     public void iniciarDialogo() {
          gp.setCharacterState(GamePanel.CharacterState.Dialogo);
     }

     private void handleCollision(Entity entity) {
          int entityType = entity.tipo();
          boolean jaDialogou = false;
          switch (entityType) {
               case 1:
                    break;
               case 2:
                    if (!jaDialogou) {
                         iniciarDialogo();
                         String fala = entity.getFala();
                         gp.getDialogues().setDialogueText(fala);
                         jaDialogou = true;
                    }
                    break;
               case 3:
                    atualEntity = entity;
                    keyH.upPressed = false;
                    keyH.downPressed = false;
                    keyH.leftPressed = false;
                    keyH.rightPressed = false;
                    gp.playMusic(0);
                    gp.setCharacterState(GamePanel.CharacterState.Combate);
                    iniciarCombate(entity);
                    break;
          }
     }


     public void setItems() {
          pegarPocao();
          pegarPocao();
          pegarCura();
     }


     public void pegarPocao() {
          PocaoForca pocao = new PocaoForca();
          inventario.add(pocao);
     }

     public void pegarCura(){
          PocaoCura pocaoCura = new PocaoCura();
          inventario.add(pocaoCura);
     }


     protected boolean collisionWithTile(int x, int y) {
          return gp.getCurrentMap().getTile(x,y).isSolid();
     }

     protected void setDefaultValues() {

          x = gp.tamanhoJanela*15;
          y = gp.tamanhoJanela*18;
          vida = 100;
          vidaMaxima = 100;
          dano = 7;
          mana = 10;
          manaMax = 10;
          xp = 0;
          xpMax = 10;
          level = 1;
     }
     public void ganharXp(int xpGanho){
          xp += xpGanho;
     }
     public int getVida(){
          return vida;
     }
     public void setVidaMax(){
          if (level > 1){
               vidaMaxima += level*2;
          }
     }
     public void subirDeLevel(){
          if (xp == xpMax) {
               level += 1;
               xp -= xpMax;
          }
     }
     public int getXp(){
          return xp;
     }
     public int getLevel(){
          return level;
     }
     public void setXpMax(){
          if (level > 1){
               xpMax += level*15/10;
          }
     }
     public int getXpMax(){
          return xpMax;
     }
     public void receberDamage(int dano){
          int vidaTeste = vida - dano;
          if(vidaTeste < 0 ) {
               this.vida = 0;
          } else {
               this.vida = vida - dano;
          }
     }

     public void curarVida(){
          vida = vidaMaxima;
     }

     public int getDano(){
          return dano;
     }

     public void aumentarDano(int aumento){
          dano = dano + aumento;
     }

     @Override
     public void update() {
          Entity collidedEntity = null;
          System.out.println("mana: " + gp.getMana());

          if (gp.getCharacterState() == GamePanel.CharacterState.Combate  && combate != null) {
               direcao = "frente";
               combate.update();
               alinharPersonagensCombate(atualEntity);
          }

          if (gp.lutando) {
               // pra nao ter mais de uma instancia atualizando / gambiarra
               if (this == gp.getPlayer()) {
                    attackSpriteCounter++;
                    if (attackSpriteCounter >= 5) {
                         attackSpriteCounter = 0;
                         attackSpriteNum++;
                         if (attackSpriteNum > 10) {
                              attackSpriteNum = 1;
                              gp.lutando = false;
                         }
                    }
               }
          } else {
               if (keyH.upPressed) {
                    if (direcao.equals("frente")) {
                         direcao = "frente";
                    } else {
                         direcao = "costas";
                    }
                    movimentacao = "movendo";

                    collidedEntity = checkEntityColissions(0, -speed);
                    if (collidedEntity == null) {
                         int ty = (int) ((y - speed + bounds.y) / Tile.tileHeight);
                         if (!collisionWithTile((int) ((x + bounds.x) / Tile.tileWidth), ty) &&
                                 !collisionWithTile((int) ((x + bounds.x + bounds.width) / Tile.tileWidth), ty)) {
                              y -= speed;
                         }
                    }
               } else if (keyH.downPressed) {
                    if (direcao.equals("frente")) {
                         direcao = "frente";
                    } else {
                         direcao = "costas";
                    }
                    movimentacao = "movendo";

                    collidedEntity = checkEntityColissions(0, speed);
                    if (collidedEntity == null) {
                         int by = (int) ((y + speed + bounds.y + bounds.height) / Tile.tileHeight);
                         if (!collisionWithTile((int) ((x + bounds.x) / Tile.tileWidth), by) &&
                                 !collisionWithTile((int) ((x + bounds.x + bounds.width) / Tile.tileWidth), by)) {
                              y += speed;
                         }
                    }
               } else if (keyH.leftPressed) {
                    direcao = "costas";
                    movimentacao = "movendo";

                    collidedEntity = checkEntityColissions(-speed, 0);
                    if (collidedEntity == null) {
                         int tx = (int) ((x - speed + bounds.x) / Tile.tileWidth);
                         if (!collisionWithTile(tx, (int) ((y + bounds.y) / Tile.tileHeight)) &&
                                 !collisionWithTile(tx, (int) ((y + bounds.y + bounds.height) / Tile.tileHeight))) {
                              x -= speed;
                         }
                    }
               } else if (keyH.rightPressed) {
                    direcao = "frente";
                    movimentacao = "movendo";

                    collidedEntity = checkEntityColissions(speed, 0);
                    if (collidedEntity == null) {
                         int bx = (int) ((x + speed + bounds.x + bounds.width) / Tile.tileWidth);
                         if (!collisionWithTile(bx, (int) ((y + bounds.y) / Tile.tileHeight)) &&
                                 !collisionWithTile(bx, (int) ((y + bounds.y + bounds.height) / Tile.tileHeight))) {
                              x += speed;
                         }
                    }
               } else {
                    movimentacao = "parado";
               }

               if (collidedEntity != null) {
                    handleCollision(collidedEntity);
               }

               spriteCounter++;
               if (spriteCounter >= 5) {
                    spriteCounter = 0; // Reiniciar contador
                    spriteNum++; // Avançar para o próximo sprite
                    if (spriteNum > 7) {
                         spriteNum = 1; // Reiniciar a sequência de sprites
                    }
               }
          }

          // Centralizar câmera na entidade
          gp.getCamera().centerOnEntity(this);
     }



     @Override
     public void draw(Graphics2D g2) {
          BufferedImage image = null;

          if (gp.lutando) {
               attackSpriteNum = gp.getPlayer().attackSpriteNum;
                         switch (attackSpriteNum) {
                              case 1:
                                   image = attack1;
                                   break;
                              case 2:
                                   image = attack2;
                                   break;
                              case 3:
                                   image = attack3;
                                   break;
                              case 4:
                                   image = attack4;
                                   break;
                              case 5:
                                   image = attack5;
                                   break;
                              case 6:
                                   image = attack6;
                                   break;
                              case 7:
                                   image = attack7;
                                   break;
                              case 8:
                                   image = attack8;
                                   break;
                              case 9:
                                   image = attack9;
                                   break;
                              case 10:
                                   image = attack10;
                                   break;

                    }
          } else {
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
          }



          g2.drawImage(image,
                  (int) (x - gp.getCamera().getxOffSet() - (gp.tamanhoJanela*9/2)),
                  (int) (y - gp.getCamera().getyOffSet() - (gp.tamanhoJanela * 10) / 3),
                  gp.tamanhoJanela*9,
                  gp.tamanhoJanela*4 ,
                  null);



/*
          DEBUG
         g2.setColor(Color.RED);
          g2.drawRect((int) (x + bounds.x - gp.getCamera().getxOffSet()),
                  (int) (y + bounds.y - gp.getCamera().getyOffSet()),
                  bounds.width, bounds.height);
 */

     }
     public int tipo() {
          return 1;
     }
}