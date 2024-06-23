package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class KeyHandler implements KeyListener {

    public boolean upPressed , downPressed , leftPressed , rightPressed;
    private GamePanel gp;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();

            if(code==KeyEvent.VK_W || code==KeyEvent.VK_UP) {
            upPressed = true;
            }
            if(code==KeyEvent.VK_A || code==KeyEvent.VK_LEFT) {
            leftPressed = true;
            }
           if(code==KeyEvent.VK_S || code==KeyEvent.VK_DOWN) {
            downPressed = true;
             }
           if(code==KeyEvent.VK_D || code==KeyEvent.VK_RIGHT) {
            rightPressed = true;
             }
        if (code == KeyEvent.VK_I && gp.getGameState() == GamePanel.GameState.Jogando) {
            gp.setCharacterState(GamePanel.CharacterState.Inventario);
        }
        if(code == KeyEvent.VK_X) {
            gp.setGameState(GamePanel.GameState.Jogando);
            gp.setCharacterState(GamePanel.CharacterState.Ocioso);
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
