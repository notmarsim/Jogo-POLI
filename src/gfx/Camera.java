package gfx;

import entity.Entity;
import main.GamePanel;

public class Camera {

    private float xOffSet, yOffSet;
    private GamePanel gp;


    public Camera (GamePanel gp,float xOffSet, float yOffSet) {
        this.gp = gp;
        this.xOffSet = xOffSet;
        this.yOffSet = yOffSet;
    }

    public void centerOnEntity(Entity e) {
        xOffSet = e.x -  gp.larguraTela / 2 ;
        yOffSet = e.y -  gp.alturaTela / 2 ;
    }

    public void move(float xAmt, float yAmt) {
        xOffSet = xOffSet + xAmt;
        yOffSet = yOffSet + yAmt;
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
