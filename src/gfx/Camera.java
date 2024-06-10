package gfx;

import entity.Entity;
import main.GamePanel;
import mapas.Maps;
import tile.Tile;

public class Camera {

    private float xOffSet, yOffSet;
    private GamePanel gp;


    public Camera (GamePanel gp,float xOffSet, float yOffSet) {
        this.gp = gp;
        this.xOffSet = xOffSet;
        this.yOffSet = yOffSet;

    }

    public void checkVoidSpace(){
        if(xOffSet<0){
            xOffSet = 0;
        } else if (xOffSet>gp.getCurrentMap().getWidth()* Tile.tileWidth - gp.larguraTela) {
            xOffSet = gp.getCurrentMap().getWidth()* Tile.tileWidth - gp.larguraTela;
        }
        if(yOffSet<0) {
            yOffSet = 0;
        } else if (yOffSet>gp.getCurrentMap().getHeight()*Tile.tileHeight- gp.alturaTela) {
            yOffSet = gp.getCurrentMap().getHeight()*Tile.tileHeight- gp.alturaTela;
        }
    }

    public void centerOnEntity(Entity e) {
        xOffSet = e.x -  gp.larguraTela / 2 ;
        yOffSet = e.y -  gp.alturaTela / 2 ;
        checkVoidSpace();
    }

    public void move(float xAmt, float yAmt) {
        xOffSet = xOffSet + xAmt;
        yOffSet = yOffSet + yAmt;
        checkVoidSpace();
    }

    public float getxOffSet() {
        return xOffSet;
    }

    public void setxOffSet(float xOffSet) {
        this.xOffSet = xOffSet;
    }

    public float getyOffSet() {
        return yOffSet;
    }

    public void setyOffSet(float yOffSet) {
        this.yOffSet = yOffSet;
    }
}
