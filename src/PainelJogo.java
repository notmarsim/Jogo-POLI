import javax.swing.*;
import java.awt.*;

public class PainelJogo extends JPanel { // subclasse jframe , config de tela

    final int tamanhooriginalJanela = 16; // bloco / janela = 16x16
    final int escala = 3;
    final int tamanhoJanela = tamanhooriginalJanela*escala; // 48x48 cada janela
    final int tamanhomaxX = 16;
    final int tamanhomaxY = 12;
    final int larguraTela = tamanhomaxX*tamanhoJanela; // 768px
    final int alturaTela = tamanhomaxY*tamanhoJanela;

    public PainelJogo() {
        this.setPreferredSize(new Dimension(larguraTela,alturaTela));
        this.setBackground(Color.BLACK);

    }

}

