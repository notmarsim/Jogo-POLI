import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setTitle("Guardiões das Lendas Antigas");



        GamePanel meuPainelJogo = new GamePanel();
        janela.add(meuPainelJogo);
        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        meuPainelJogo.iniciargameThread();
    }
}
