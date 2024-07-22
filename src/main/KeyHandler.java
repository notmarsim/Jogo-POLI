package main;

import entity.Entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyHandler implements KeyListener {

    public boolean upPressed , downPressed , leftPressed , rightPressed;

    private GamePanel gp;
    public boolean enter = false;


    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();

            // MOVIMENTACAO

            if(code==KeyEvent.VK_W && gp.getCharacterState() == GamePanel.CharacterState.Ocioso && gp.getGameState() == GamePanel.GameState.Jogando || code==KeyEvent.VK_UP && gp.getCharacterState() == GamePanel.CharacterState.Ocioso  && gp.getGameState() == GamePanel.GameState.Jogando) {
            upPressed = true;

            }
            if(code==KeyEvent.VK_A && gp.getCharacterState() == GamePanel.CharacterState.Ocioso  && gp.getGameState() == GamePanel.GameState.Jogando || code==KeyEvent.VK_LEFT && gp.getCharacterState() == GamePanel.CharacterState.Ocioso  && gp.getGameState() == GamePanel.GameState.Jogando) {
            leftPressed = true;
            }
           if(code==KeyEvent.VK_S && gp.getCharacterState() == GamePanel.CharacterState.Ocioso   && gp.getGameState() == GamePanel.GameState.Jogando || code==KeyEvent.VK_DOWN && gp.getCharacterState() == GamePanel.CharacterState.Ocioso  && gp.getGameState() == GamePanel.GameState.Jogando) {
            downPressed = true;
             }
           if(code==KeyEvent.VK_D && gp.getCharacterState() == GamePanel.CharacterState.Ocioso  && gp.getGameState() == GamePanel.GameState.Jogando || code==KeyEvent.VK_RIGHT && gp.getCharacterState() == GamePanel.CharacterState.Ocioso  && gp.getGameState() == GamePanel.GameState.Jogando) {
            rightPressed = true;
             }
           // INVENTARIO
        if (code == KeyEvent.VK_I && gp.getGameState() == GamePanel.GameState.Jogando && gp.getCharacterState() != GamePanel.CharacterState.Combate) {
            // Verifica se o jogo está no estado Jogando e o inventário está fechado
            if (gp.getCharacterState() != GamePanel.CharacterState.Inventario) {
                gp.setCharacterState(GamePanel.CharacterState.Inventario);
            } else {

                gp.setGameState(GamePanel.GameState.Jogando);
                gp.setCharacterState(GamePanel.CharacterState.Ocioso);
            }
        }
        // SKIPAR DIALOGO

        if(code == KeyEvent.VK_ENTER && gp.getCharacterState() == GamePanel.CharacterState.Dialogo) {
            gp.setGameState(GamePanel.GameState.Menu);
            gp.setCharacterState(GamePanel.CharacterState.Ocioso);
            gp.getPlayer().x = gp.getPlayer().x - gp.tamanhoJanela;
            if (gp.getDialogues().getDialogueText().contains("Pyroth, Guardião do Fogo, ouça as antigas palavras esquecidas há milênios e agora trazidas à luz. A escuridão que uma vez ameaçou Elemenvera ressurgiu. Nas profundezas das sombras, um ser corrompido, outrora apenas uma lenda, conhecido como Necromancer, desperta com a intenção de devorar a essência dos nossos elementos e mergulhar o mundo em trevas eternas. Sua missão é restaurar a paz em cada reino de Elemenvera, agora sob ataque dos monstros criados por Necromancer. Comece pelo seu domínio, o Reino do Fogo, e reúna os outros guardiões para que juntos protejam e salvem o nosso mundo")){
                gp.setChapter(GamePanel.Capitulos.chapterFogo);
            }

        }
        if(gp.getCharacterState() == GamePanel.CharacterState.Dialogo && gp.getDialogues().getDialogueText().contains("Deseja comprar algo? \n" +
                "1 - Poção de Força  (G 40)\n" +
                "2 - Poção de Cura (G 60)\n")){
            if(code == KeyEvent.VK_1){
                gp.getPlayer().comprarPocaoForca();
            } else if (code == KeyEvent.VK_2) {
                gp.getPlayer().comprarCura();
            }
        }
        // ar npc
        if(gp.getCharacterState() == GamePanel.CharacterState.Dialogo && gp.getDialogues().getDialogueText().contains("Vamos para o reino da ar? \n" + "1 - Sim  (Mate o boss dessa região)\n" + "2 - Não\n")){
            if(code == KeyEvent.VK_1){
                gp.getPlayer().irParaReinoAr();
            } else if (code == KeyEvent.VK_2) {
                gp.getDialogues().setDialogueText("Ok");
            }
        }

        // aquara npc
        if(gp.getCharacterState() == GamePanel.CharacterState.Dialogo && gp.getDialogues().getDialogueText().contains("Vamos para o reino da água? \n" + "1 - Sim  (Mate o boss dessa região)\n" + "2 - Não\n")){
            if(code == KeyEvent.VK_1){
                gp.getPlayer().irParaReinoAqua();
            } else if (code == KeyEvent.VK_2) {
                gp.getDialogues().setDialogueText("Ok");
            }
        }
        // pyroth npc
        if(gp.getCharacterState() == GamePanel.CharacterState.Dialogo && gp.getDialogues().getDialogueText().contains("Deseja voltar para o reino do fogo? \n" + "1 - Sim\n" + "2 - Não\n")){
            if(code == KeyEvent.VK_1){

                gp.getPlayer().irParaReinoFogo();
            } else if (code == KeyEvent.VK_2) {
                gp.getDialogues().setDialogueText("Ok");
            }
        }
        //terranis npc
        if(gp.getCharacterState() == GamePanel.CharacterState.Dialogo && gp.getDialogues().getDialogueText().contains("Vamos para o reino da terra? \n" + "1 - Sim  (Mate o boss dessa região)\n" + "2 - Não\n")){
            if(code == KeyEvent.VK_1){
                gp.getPlayer().irParaReinoTerra();
            } else if (code == KeyEvent.VK_2) {
                gp.getDialogues().setDialogueText("Ok");
            }
        }
        // mendigo npc
        if(gp.getCharacterState() == GamePanel.CharacterState.Dialogo && gp.getDialogues().getDialogueText().contains("M...Me...D-dá dinheiro por favor...")){
            if(code == KeyEvent.VK_5){
                gp.getPlayer().ganharRumLendario();
            }
        }




        // Profile
        if (code == KeyEvent.VK_C && gp.getGameState() == GamePanel.GameState.Jogando && gp.getCharacterState() != GamePanel.CharacterState.Combate) {

            if (gp.getCharacterState() != GamePanel.CharacterState.Profile) {
                gp.setCharacterState(GamePanel.CharacterState.Profile);
            } else {
                gp.setGameState(GamePanel.GameState.Jogando);
                gp.setCharacterState(GamePanel.CharacterState.Ocioso);
            }
        }
//        if(gp.getCharacterState() == GamePanel.CharacterState.Profile) {
//
//        }
        // INVENTARIO
        if(gp.getCharacterState() == GamePanel.CharacterState.Inventario) {

            if(code==KeyEvent.VK_W || code==KeyEvent.VK_UP) {
                if (gp.getUi().slotRow != 0) {
                    gp.getUi().slotRow--;
                }
            }
            if(code == KeyEvent.VK_S || code==KeyEvent.VK_DOWN) {
                if(gp.getUi().slotRow != 3){
                    gp.getUi().slotRow++;
                }
            }
            if(code == KeyEvent.VK_A || code==KeyEvent.VK_LEFT) {
                if(gp.getUi().slotCol != 0 ) {
                    gp.getUi().slotCol--;
                }
            }
            if(code==KeyEvent.VK_D || code==KeyEvent.VK_RIGHT) {
                if(gp.getUi().slotCol != 4) {
                    gp.getUi().slotCol++;
                }
            }
        }
        // USAR ITEM
        if (code == KeyEvent.VK_ENTER && gp.getCharacterState() == GamePanel.CharacterState.Inventario) {
            gp.getUi().usarItemSelecionado();
        }
        if (code == KeyEvent.VK_ENTER && gp.getCharacterState() == GamePanel.CharacterState.Combate) {
            gp.getUi().usarAtaqueSelecionado();
        }

        // TESTE CAPITULOS
        if(code == KeyEvent.VK_F) {
            gp.getEntityManager().getEntities().clear();
            gp.setChapter(GamePanel.Capitulos.chapterFogo);
        }
        if(code == KeyEvent.VK_P) {
            gp.setChapter(GamePanel.Capitulos.Prologo);
        }

        if(code == KeyEvent.VK_L) {
            gp.setChapter(GamePanel.Capitulos.chapterAqua);
        }
        if(code == KeyEvent.VK_T) {
            gp.setChapter(GamePanel.Capitulos.chapterAr);
        }

        if ((code==KeyEvent.VK_M)){
            gp.setChapter(GamePanel.Capitulos.chapterEarth);
        }
        if ((code==KeyEvent.VK_V)){
            gp.setChapter(GamePanel.Capitulos.chapterVoid);
        }



        //COMBATE
        if(gp.getCharacterState() == GamePanel.CharacterState.Combate) {
            if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                if (gp.getUi().selectedOption != 0) {
                    gp.getUi().selectedOption--;
                }
            }
            if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                if (gp.getUi().selectedOption != 2) {
                    gp.getUi().selectedOption++;
                }
            }
        }

        if(gp.getCharacterState().equals(GamePanel.CharacterState.Combate)){
            upPressed = false;
            downPressed = false;
            leftPressed = false;
            rightPressed = false;
        }

        if(code == KeyEvent.VK_X) {
            gp.setCharacterState(GamePanel.CharacterState.Ocioso);
            gp.stopMusic();
        }

    }



    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code==KeyEvent.VK_W || code==KeyEvent.VK_UP) {
            upPressed = false;
        }
        if(code==KeyEvent.VK_A || code==KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if(code==KeyEvent.VK_S || code==KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if(code==KeyEvent.VK_D || code==KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }
}
