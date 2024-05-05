package UI;

import main.GamePanel;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class UI {

    Graphics2D g2;
    Font maruMonica;
    GamePanel gamePanel;
    int fontSize; // Adicionando o tamanho da fonte como uma variável
    int opacity; // Variável para controlar a opacidade do texto do prólogo
    boolean fadingOut; // Flag para indicar se o texto está desaparecendo
    long startTime; // Tempo de início da exibição do título
    long duration; // Duração que o título fica na tela antes de começar a desaparecer

    public UI(GamePanel gamePanel, int fontSize){
        this.gamePanel = gamePanel;
        this.fontSize = fontSize; // Definindo o tamanho da fonte
        this.opacity = 0; // Começa com opacidade mínima
        this.fadingOut = false; // Começa sem desaparecer
        this.startTime = System.currentTimeMillis(); // Registra o tempo de início da exibição do título
        this.duration = 3000; // Define a duração em milissegundos (por exemplo, 3000 milissegundos = 3 segundos)
        InputStream is = getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
        try {
            maruMonica = Font.createFont(Font.TRUETYPE_FONT,is).deriveFont(Font.PLAIN, fontSize);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(maruMonica);
        g2.setColor(new Color(255, 255, 255, opacity)); // Define a cor com base na opacidade atual
        if(gamePanel.currentCapitulo.equals(GamePanel.Capitulos.Prologo)) {
            printarPrologo();
        }
    }

    public void update() {
        // Calcula quanto tempo o título já ficou na tela
        long elapsedTime = System.currentTimeMillis() - startTime;

        // Se o tempo excedeu a duração e o título não começou a desaparecer ainda
        if (elapsedTime >= duration && !fadingOut) {
            iniciarDesaparecimento(); // Inicia o desaparecimento do título
        }

        // Se o título já começou a desaparecer
        if (fadingOut) {
            opacity -= 5; // Diminui a opacidade gradualmente
            if (opacity <= 0) {
                opacity = 0; // Limita a opacidade mínima a 0
            }
        } else {
            // Se o título ainda não começou a desaparecer, aumenta gradualmente a opacidade
            if (opacity < 255) {
                opacity += 5; // Aumenta a opacidade gradualmente
                if (opacity >= 255) {
                    opacity = 255; // Limita a opacidade máxima a 255
                }
            }
        }
    }

    public void printarPrologo() {
        String text = "PROLOGO";
        int x = textoCentralizadoX(text);
        int y = gamePanel.alturaTela/2;
        g2.drawString(text, x, y);
    }

    public int textoCentralizadoX(String text) {
        int x;
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        x = gamePanel.larguraTela/2 - length/2;
        return x;
    }

    // Método para iniciar o desaparecimento do texto
    public void iniciarDesaparecimento() {
        fadingOut = true;
    }

    // Método para verificar se o texto do prólogo desapareceu completamente
    public boolean isPrologoDesaparecido() {
        return opacity == 0;
    }
}
