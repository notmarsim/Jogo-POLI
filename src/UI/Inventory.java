package UI;

import main.GamePanel;

public class Inventory extends UI {

    public int slotRow = 0;
    public int slotCol = 0;

    public Inventory(GamePanel gamePanel, int fontSize) {
        super(gamePanel, fontSize);
    }

    public void drawInventory() {
        int frameX = gamePanel.tamanhoJanela*9;
        int frameY = gamePanel.tamanhoJanela;
        int frameWidth = gamePanel.tamanhoJanela*6;
        int frameHeight = gamePanel.tamanhoJanela*5;

        // slots
        final int slotXstart = frameX + 20;
        final int slotYstart = frameY +20;
        int slotX = slotXstart;
        int slotY = slotYstart;

        int cursorX = slotXstart+gamePanel.tamanhoJanela*slotRow;
        int cursorY = slotYstart+gamePanel.tamanhoJanela*slotCol;
        int cursorWidth = gamePanel.tamanhoJanela;
        int cursorHeight = gamePanel.tamanhoJanela;
    }
}
