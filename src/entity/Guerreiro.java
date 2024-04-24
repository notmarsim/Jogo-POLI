package entity;
import main.GamePanel;
import main.KeyHandler;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Guerreiro extends Player {

    public Guerreiro(GamePanel gp, KeyHandler keyH) {
        super(gp, keyH);
        loadSprites();
    }

    private void loadSprites() {
        try {
            idle = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreiroidle.png"));
            idle2 = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreiroidle2.png"));
            idle3 = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreiroidle3.png"));
            idle4 = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreiroidle4.png"));
            run = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreirorun.png"));
            run2 = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreirorun2.png"));
            run3 = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreirorun3.png"));
            run4 = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreirorun4.png"));
            run5 = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreirorun6.png"));
            costas = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreirorunback.png"));
            costas2 = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreirorun2back.png"));
            costas3 = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreirorun3back.png"));
            costas4 = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreirorun4back.png"));
            costas5 = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreirorun5back.png"));
            idleback = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreiroidleback.png"));
            idle2back = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreiroidleback2.png"));
            idle3back = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreiroidleback3.png"));
            idle4back = ImageIO.read(getClass().getResourceAsStream("/player/Guerreiro/guerreiroidleback4.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}