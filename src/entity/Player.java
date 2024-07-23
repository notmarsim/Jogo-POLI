package entity;
import Objetos.*;
import main.GamePanel;
import main.KeyHandler;
import tile.Tile;
import java.util.Random;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity {
     private KeyHandler keyH;
     public int xp;
     private Combate combate;
     public ArrayList<SuperObject> inventario = new ArrayList<SuperObject>();
     public final int maxInventarioSize = 20;
     public Entity atualEntity;
     public int mana,manaMax, reducaoDeDano;
     public int xpMax;
     protected boolean isSpecialAttack = false;
     public int specialAttackSpriteCounter = 0;
     public int specialAttackSpriteNum = 1;
     public int moeda,dano;
     private Random rand = new Random();
     protected BufferedImage defesa,defesa2,defesa3,defesa4,defesa5,defesa6,defesa7,defesa8,defesa9,defesa10;
     public int defesaSpriteCounter = 0;
     public int defesaSpriteNum = 1;
     public boolean jaColidiu = false;



     public Player(GamePanel gp, KeyHandler keyH) {
          super(gp);
          this.keyH = keyH;
          setDefaultValues();
          bounds = new Rectangle();
          direcao = "frente";

     }

     public int getReducaoDeDano(){return reducaoDeDano;}
     public int getMana(){
          return mana;
     }

     public void setSpecialAttack(boolean valor){
          this.isSpecialAttack = valor;
     }

     public boolean getSpecialAttack(){
          return isSpecialAttack;
     }

     public void alinharPersonagensCombate(Entity entity){
          if (entity instanceof Demonio){
               y = entity.y + gp.tamanhoJanela * 33 / 10;
               x = entity.x + gp.tamanhoJanela * 12 / 10;
          }else if (entity instanceof GolemGelo){
               y = entity.y + gp.tamanhoJanela * 24 / 10;
               x = entity.x + gp.tamanhoJanela * 12 / 10;
          }else if (entity instanceof FinalBoss){
               y = entity.y + gp.tamanhoJanela * 5;
               x = entity.x + gp.tamanhoJanela * 3;
          } else if (entity instanceof Esqueleto) {
               y = entity.y ;
               x = entity.x - gp.tamanhoJanela;
          } else if (entity instanceof DemonPequeno) {
               y = entity.y ;
               x = entity.x - gp.tamanhoJanela*2;
          }
     }

     public void setMana(int mana) {
          this.mana = mana;
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

     protected void handleCollision(Entity entity) {
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
               case 4:
                    if (!entity.encostouBau) {
                         ganharMoeda(entity.moedaDrop);
                         ganharXp(entity.xpDrop);
                         gp.getUi().addMensagem("Você abriu um baú! Você ganhou: " + entity.xpDrop + " de XP e " + entity.moedaDrop + " moedas");
                         entity.encostouBau = true;
                    }
                    break;
          }
     }


     public void setItems() {

     }


     public void comprarPocaoForca() {
          if(moeda>=40){
               PocaoForca pocao = new PocaoForca();
               inventario.add(pocao);
               gp.getUi().addMensagem("Você recebeu uma poção! Pressione i para abrir inventário");
               moeda -= 40;
          }

     }
     public void ganharLoot() {
               int chanceDeGanharLoot = 1 + rand.nextInt(100);
               System.out.println("chance1: "+ chanceDeGanharLoot);
               if(chanceDeGanharLoot <= 30) {
                    int chanceDeGanharLoot2 = 1 + rand.nextInt(100);
                    System.out.println("chance2: "+ chanceDeGanharLoot2);
                    if (chanceDeGanharLoot2 <= 5) {
                         Campeao campeao = new Campeao();
                         inventario.add(campeao);
                    } else if (chanceDeGanharLoot2 > 5 && chanceDeGanharLoot <= 10) {
                         Devocao devocao = new Devocao();
                         inventario.add(devocao);
                    } else if (chanceDeGanharLoot2 > 10 && chanceDeGanharLoot <= 15) {
                         GuerreiroStatue guerreiro = new GuerreiroStatue();
                         inventario.add(guerreiro);
                    } else if (chanceDeGanharLoot2 > 15 && chanceDeGanharLoot <= 20) {
                         Sabedoria sabedoria = new Sabedoria();
                         inventario.add(sabedoria);
                    } else if (chanceDeGanharLoot2 > 20 && chanceDeGanharLoot <= 25) {
                         Semente semente = new Semente();
                         inventario.add(semente);
                    } else if (chanceDeGanharLoot2 > 25 && chanceDeGanharLoot <= 28) {
                         PedraSolar pedraSolar = new PedraSolar();
                         inventario.add(pedraSolar);
                    } else if (chanceDeGanharLoot2 == 29) {
                         MaldicaoDoGuerreiro maldicaoDoGuerreiro = new MaldicaoDoGuerreiro();
                         inventario.add(maldicaoDoGuerreiro);
                    } else if (chanceDeGanharLoot2 == 30) {
                         MaldicaoDoMago maldicaoDoMago = new MaldicaoDoMago();
                         inventario.add(maldicaoDoMago);
                    }
               }

     }

     public void ganharRumLendario(){
          if(moeda >= 99){
               Rum rum = new Rum();
               inventario.add(rum);
               moeda -= 99;
          }
     }
     public void irParaReinoAqua(){
          if(gp.getCombate().bossMorto){
               gp.setCharacterState(GamePanel.CharacterState.Ocioso);
               gp.setGameState(GamePanel.GameState.Menu);
               gp.setChapter(GamePanel.Capitulos.chapterAqua);
               System.out.println("boss morto: "+ gp.getCombate().bossMorto);
          }
     }
     public void irParaReinoTerra(){
          if(gp.getCombate().bossMorto){
               gp.setCharacterState(GamePanel.CharacterState.Ocioso);
               gp.setGameState(GamePanel.GameState.Menu);
               gp.setChapter(GamePanel.Capitulos.chapterEarth);
               System.out.println("boss morto: "+ gp.getCombate().bossMorto);
          }
     }

     public void irParaReinoAr(){
          if(gp.getCombate().bossMorto){
               gp.setCharacterState(GamePanel.CharacterState.Ocioso);
               gp.setGameState(GamePanel.GameState.Menu);
               gp.setChapter(GamePanel.Capitulos.chapterAr);
               System.out.println("boss morto: "+ gp.getCombate().bossMorto);
          }
     }

     public void irParaReinoFogo(){
          if(gp.getCombate().bossMorto){
               gp.setCharacterState(GamePanel.CharacterState.Ocioso);
               gp.setGameState(GamePanel.GameState.Menu);
               gp.setChapter(GamePanel.Capitulos.chapterFogo);
          }
     }

     public void comprarCura(){
          if(moeda>=60){
               PocaoCura pocaoCura = new PocaoCura();
               inventario.add(pocaoCura);
               gp.getUi().addMensagem("Você recebeu uma poção! i para abrir inventário");
               moeda -= 60;
          }

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
          reducaoDeDano = 3;
          moeda = 100;

     }
     public void ganharXp(int xpGanho){
          gp.getPlayer().xp += xpGanho;
          subirDeLevel();

     }
     public void ganharMoeda(int moedaGanha){
          gp.getPlayer().moeda += moedaGanha;

     }
     public int getVida(){
          return vida;
     }

     public void subirDeLevel(){
          if (gp.getPlayer().xp >= gp.getPlayer().xpMax) {
               gp.getUi().addMensagem("Você aumentou o nível! Pressione P para abrir o perfil");
               gp.getPlayer().level += 1;
               gp.getPlayer().xp -= gp.getPlayer().xpMax;
               vidaMaxima += level*2;
               vida = vidaMaxima;
               gp.getPlayer().manaMax += level*2;
               mana = manaMax;
               reducaoDeDano += 1;
               dano += 1;
               // defesa += 1;
               setXpMax();
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
          vida += vidaMaxima*75/100;
     }

     public int getDano(){
          return dano;
     }






     @Override
     public void update() {
          Entity collidedEntity = null;


          if (gp.getCharacterState() == GamePanel.CharacterState.Combate  && combate != null) {
               direcao = "frente";
               combate.update();
               alinharPersonagensCombate(atualEntity);
               System.out.println(isSpecialAttack + "player");
               System.out.println(gp.getPlayer().isSpecialAttack + "gp");
          }

          if (gp.atacando) {
               // pra nao ter mais de uma instancia atualizando
               if (this == gp.getPlayer()) {
                    if (gp.getPlayer().isSpecialAttack) {
                         specialAttackSpriteCounter++;
                         if (specialAttackSpriteCounter >= 5) {
                              specialAttackSpriteCounter = 0;
                              specialAttackSpriteNum++;
                              if (specialAttackSpriteNum > 18) {
                                   specialAttackSpriteNum = 1;
                                   gp.atacando = false;
                                   isSpecialAttack = false;
                              }
                         }
                    } else {
                         attackSpriteCounter++;
                         if (attackSpriteCounter >= 5) {
                              attackSpriteCounter = 0;
                              attackSpriteNum++;
                              if (attackSpriteNum > 10) {
                                   attackSpriteNum = 1;
                                   gp.atacando = false;
                              }
                         }
                    }
               }
          } else if (gp.defendendo) {
               if(this==gp.getPlayer()){
                    defesaSpriteCounter++;
                    if(defesaSpriteCounter>5){
                         defesaSpriteCounter = 0;
                         defesaSpriteNum ++;
                         if(defesaSpriteNum>10){
                              defesaSpriteNum = 1;
                              gp.defendendo = false;
                         }
                    }
               }

          } else if (gp.getCharacterState().equals(GamePanel.CharacterState.Morto)) {
               if(this==gp.getPlayer()){
                    deathSpriteCounter++;
                    if(deathSpriteCounter>5){
                         deathSpriteCounter =0;
                         deathSpriteNum++;
                         if(deathSpriteNum>14){
                              deathSpriteNum = 14;
                              try {
                                   Thread.sleep(2000);
                              } catch (InterruptedException e) {
                                   e.printStackTrace();
                              }
                              System.exit(0);
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

          if (gp.atacando) {
               if (gp.getPlayer().isSpecialAttack) {

                    switch (specialAttackSpriteNum) {
                         case 1:
                              image = specialAttack1;
                              break;
                         case 2:
                              image = specialAttack2;
                              break;
                         case 3:
                              image = specialAttack3;
                              break;
                         case 4:
                              image = specialAttack4;
                              break;
                         case 5:
                              image = specialAttack5;
                              break;
                         case 6:
                              image = specialAttack6;
                              break;
                         case 7:
                              image = specialAttack7;
                              break;
                         case 8:
                              image = specialAttack8;
                              break;
                         case 9:
                              image = specialAttack9;
                              break;
                         case 10:
                              image = specialAttack10;
                              break;
                         case 11:
                              image = specialAttack11;
                              break;
                         case 12:
                              image = specialAttack12;
                              break;
                         case 13:
                              image = specialAttack13;
                              break;
                         case 14:
                              image = specialAttack14;
                              break;
                         case 15:
                              image = specialAttack15;
                              break;
                         case 16:
                              image = specialAttack16;
                              break;
                         case 17:
                              image = specialAttack17;
                              break;
                         case 18:
                              image = specialAttack18;
                              break;

                    }
               } else {

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

               }
          } else if (gp.defendendo) {
               switch (defesaSpriteNum){
                    case 1:
                         image = defesa;
                         break;
                    case 2:
                         image = defesa2;
                         break;
                    case 3 :
                         image = defesa3;
                         break;
                    case 4:
                         image = defesa4;
                         break;
                    case 5:
                         image = defesa5;
                         break;
                    case 6:
                         image = defesa6;
                         break;
                    case 7:
                         image = defesa7;
                         break;
                    case 8:
                         image = defesa8;
                         break;
                    case 9:
                         image = defesa9;
                         break;
                    case 10:
                         image = defesa10;
                         break;
               }

          } else if (gp.getCharacterState().equals(GamePanel.CharacterState.Morto)) {
               switch (deathSpriteNum){
                    case 1:
                         image = death1;
                         break;
                    case 2:
                         image = death2;
                         break;
                    case 3:
                         image = death3;
                         break;
                    case 4:
                         image = death4;
                         break;
                    case 5:
                         image = death5;
                         break;
                    case 6:
                         image = death6;
                         break;
                    case 7:
                         image = death7;
                         break;
                    case 8:
                         image = death8;
                         break;
                    case 9:
                         image = death9;
                         break;
                    case 10:
                         image = death10;
                         break;
                    case 11:
                         image = death11;
                         break;
                    case 12:
                         image = death12;
                         break;
                    case 13:
                         image = death13;
                         break;
                    case 14:
                         image = death14;
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