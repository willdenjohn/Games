package games;
import javax.swing.*;
import java.awt.*;
public class TabuleiroXadrez extends JFrame {
    private static final int TAMANHO_CASA = 60;
    private static final int TAMANHO_TABULEIRO = 8 * TAMANHO_CASA;
    private static final String[] LETRAS = {"a", "b", "c", "d", "e", "f", "g", "h"};
    private static final String[] NUMEROS = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private static final int ESPACO_SUPERIOR = 80;

    public TabuleiroXadrez() {
        setTitle("Tabuleiro de Xadrez");
        setSize(TAMANHO_TABULEIRO + 50, TAMANHO_TABULEIRO + ESPACO_SUPERIOR + 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        int x = 50; // Iniciando a partir de 50 para deixar espaço para as letras
        int y = ESPACO_SUPERIOR; // Iniciando a partir do espaço superior

        // Desenha as letras na parte superior
        for (int i = 0; i < 8; i++) {
            g.drawString(LETRAS[i], x + TAMANHO_CASA / 2 - 5, y - 10); // Desenha as letras acima do tabuleiro
            x += TAMANHO_CASA;
        }

        // Desenha os números na lateral
        x = 25; // Reinicia a posição x
        y = ESPACO_SUPERIOR; // Reinicia a posição y
        for (int i = 0; i < 8; i++) {
            g.drawString(NUMEROS[i], 10, y + TAMANHO_CASA / 2 + 5); // Desenha os números à esquerda do tabuleiro
            y += TAMANHO_CASA;
        }

        // Desenha as casas do tabuleiro
        x = 50; // Reinicia a posição x
        y = ESPACO_SUPERIOR; // Reinicia a posição y
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(x, y, TAMANHO_CASA, TAMANHO_CASA);
                x += TAMANHO_CASA;
            }
            x = 50; // Reinicia a posição x
            y += TAMANHO_CASA;
        }
    }
}
