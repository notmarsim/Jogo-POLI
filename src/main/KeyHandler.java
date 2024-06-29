package main;

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

            if(code==KeyEvent.VK_W && gp.getCharacterState() == GamePanel.CharacterState.Ocioso || code==KeyEvent.VK_UP && gp.getCharacterState() == GamePanel.CharacterState.Ocioso) {
            upPressed = true;

            }
            if(code==KeyEvent.VK_A && gp.getCharacterState() == GamePanel.CharacterState.Ocioso || code==KeyEvent.VK_LEFT && gp.getCharacterState() == GamePanel.CharacterState.Ocioso) {
            leftPressed = true;
            }
           if(code==KeyEvent.VK_S && gp.getCharacterState() == GamePanel.CharacterState.Ocioso || code==KeyEvent.VK_DOWN && gp.getCharacterState() == GamePanel.CharacterState.Ocioso) {
            downPressed = true;
             }
           if(code==KeyEvent.VK_D && gp.getCharacterState() == GamePanel.CharacterState.Ocioso || code==KeyEvent.VK_RIGHT && gp.getCharacterState() == GamePanel.CharacterState.Ocioso) {
            rightPressed = true;
             }
        if (code == KeyEvent.VK_I && gp.getGameState() == GamePanel.GameState.Jogando) {
            // Verifica se o jogo está no estado Jogando e o inventário está fechado
            if (gp.getCharacterState() != GamePanel.CharacterState.Inventario) {
                gp.setCharacterState(GamePanel.CharacterState.Inventario);
            } else {

                gp.setGameState(GamePanel.GameState.Jogando);
                gp.setCharacterState(GamePanel.CharacterState.Ocioso);
            }
        }
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
        if (code == KeyEvent.VK_ENTER) {
            gp.getUi().usarItemSelecionado();
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
