package games;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
public class TabuleiroXadrez extends JFrame {
    private static final int TAMANHO_CASA = 60;
    private static final int TAMANHO_TABULEIRO = 8 * TAMANHO_CASA;
    private static final int ESPACO_SUPERIOR = 80;
    private static final int ESPACO_LATERAL = 50;
    private PecaIcone[][] tabuleiro;
    
    public TabuleiroXadrez() {
        setTitle("Tabuleiro de Xadrez");
        setSize(TAMANHO_TABULEIRO + 50, TAMANHO_TABULEIRO + ESPACO_SUPERIOR + 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        // Carrega os ícones de peças da web
        //peças brancas
        //peão
        ImageIcon peaoBrancaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/37/759/png-transparent-chess-figure-white-pawn.png");
        peaoBrancaIcone = redimensionarIcone(peaoBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA -20);
        //Torre
        ImageIcon torreBrancaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/634/135/png-transparent-chess-piece-rook-pawn-king-tour-white-furniture-king.png");
        torreBrancaIcone = redimensionarIcone(torreBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA -20);
        //Cavalo
        ImageIcon cavaloBrancaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/655/557/png-transparent-chess-piece-xiangqi-chessboard-knight-chess-game-king-text.png");
        cavaloBrancaIcone = redimensionarIcone(cavaloBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA -20);
        //Bispo
        ImageIcon bispoBrancaIcone = carregarIconeDaWeb("https://w1.pngwing.com/pngs/710/927/png-transparent-knight-chess-bishop-chess-piece-king-queen-bishop-and-knight-checkmate-rook.png");
        bispoBrancaIcone = redimensionarIcone(bispoBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA -20);
        //Rei
        ImageIcon reiBrancaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/941/572/png-transparent-chess-piece-chessboard-knight-chess-king-queen-sports.png");
        reiBrancaIcone = redimensionarIcone(reiBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA -20);
        //Rainha
        ImageIcon rainhaBrancaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/141/495/png-transparent-chess-piece-queen-king-pin-ajedrez-king-pin-queen.png");
        rainhaBrancaIcone = redimensionarIcone(rainhaBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA -20);
        
        //Carrega os ícones de peças da web
        //peças brancas
        //peão
        ImageIcon peaoPretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/812/57/png-transparent-chess-titans-king-chess-piece-pawn-chess-game-king-pin.png");
        peaoPretaIcone = redimensionarIcone(peaoPretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        //Torre
        ImageIcon torrePretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/830/666/png-transparent-chess-t-shirt-rook-drawing-chess-black-sports-silhouette.png");
        torrePretaIcone = redimensionarIcone(torrePretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA -20);
        //Cavalo
        ImageIcon cavaloPretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/124/1/png-transparent-chess-piece-knight-bishop-queen-cheess-horse-mammal-king.png");
        cavaloPretaIcone = redimensionarIcone(cavaloPretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA -20);
        //Bispo
        ImageIcon bispoPretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/984/47/png-transparent-chess-piece-bishop-pawn-queen-chess-game-king-sports.png");
        bispoPretaIcone = redimensionarIcone(bispoPretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA -20);
        //Rei
        ImageIcon reiPretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/172/558/png-transparent-chess-piece-king-queen-knight-chess-king-queen-sports.png");
        reiPretaIcone = redimensionarIcone(reiPretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA -20);
        //Rainha
        ImageIcon rainhaPretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/264/915/png-transparent-chess-piece-queen-bishop-white-and-black-in-chess-chess-king-hand-queen.png");
        rainhaPretaIcone = redimensionarIcone(rainhaPretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA -20);
        
        tabuleiro = new PecaIcone[8][8];
        // Posiciona as peças brancas na parte superior do tabuleiro
        tabuleiro[0][0] = new PecaIcone(torreBrancaIcone, "branca");
        tabuleiro[0][1] = new PecaIcone(cavaloBrancaIcone, "branca");
        tabuleiro[0][2] = new PecaIcone(bispoBrancaIcone, "branca");
        tabuleiro[0][3] = new PecaIcone(reiBrancaIcone, "branca");
        tabuleiro[0][4] = new PecaIcone(rainhaBrancaIcone, "branca");
        tabuleiro[0][5] = new PecaIcone(bispoBrancaIcone, "branca");
        tabuleiro[0][6] = new PecaIcone(cavaloBrancaIcone, "branca");
        tabuleiro[0][7] = new PecaIcone(torreBrancaIcone, "branca");
        //peões 
        tabuleiro[1][0] = new PecaIcone(peaoBrancaIcone, "branca");
        tabuleiro[1][1] = new PecaIcone(peaoBrancaIcone, "branca");
        tabuleiro[1][2] = new PecaIcone(peaoBrancaIcone, "branca");
        tabuleiro[1][3] = new PecaIcone(peaoBrancaIcone, "branca");
        tabuleiro[1][4] = new PecaIcone(peaoBrancaIcone, "branca");
        tabuleiro[1][5] = new PecaIcone(peaoBrancaIcone, "branca");
        tabuleiro[1][6] = new PecaIcone(peaoBrancaIcone, "branca");
        tabuleiro[1][7] = new PecaIcone(peaoBrancaIcone, "branca");
        
        // Posiciona as peças pretas na parte inferior do tabuleiro
        //peões 
        tabuleiro[6][0] = new PecaIcone(peaoPretaIcone, "preta");
        tabuleiro[6][1] = new PecaIcone(peaoPretaIcone, "preta");
        tabuleiro[6][2] = new PecaIcone(peaoPretaIcone, "preta");
        tabuleiro[6][3] = new PecaIcone(peaoPretaIcone, "preta");
        tabuleiro[6][4] = new PecaIcone(peaoPretaIcone, "preta");
        tabuleiro[6][5] = new PecaIcone(peaoPretaIcone, "preta");
        tabuleiro[6][6] = new PecaIcone(peaoPretaIcone, "preta");
        tabuleiro[6][7] = new PecaIcone(peaoPretaIcone, "preta");
        
        tabuleiro[7][0] = new PecaIcone(torrePretaIcone, "preta");
        tabuleiro[7][1] = new PecaIcone(cavaloPretaIcone, "preta");
        tabuleiro[7][2] = new PecaIcone(bispoPretaIcone, "preta");
        tabuleiro[7][3] = new PecaIcone(reiPretaIcone, "preta");
        tabuleiro[7][4] = new PecaIcone(rainhaPretaIcone, "preta");
        tabuleiro[7][5] = new PecaIcone(bispoPretaIcone, "preta");
        tabuleiro[7][6] = new PecaIcone(cavaloPretaIcone, "preta");
        tabuleiro[7][7] = new PecaIcone(torrePretaIcone, "preta");
    }

    public void paint(Graphics g) {
        super.paint(g);
        int x = 50; // Iniciando a partir de 50 para deixar espaço para as letras
        int y = ESPACO_SUPERIOR; // Iniciando a partir do espaço superior

        // Desenha as casas do tabuleiro
        x = 50; // Reinicia a posição x
        y = ESPACO_SUPERIOR; // Reinicia a posição y
        boolean corBranca = true; // Variável para alternar a cor das casas
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (corBranca) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(x, y, TAMANHO_CASA, TAMANHO_CASA);

                x += TAMANHO_CASA;
                corBranca = !corBranca; // Alterna a cor das casas
            }
            x = 50; // Reinicia a posição x
            y += TAMANHO_CASA;
            corBranca = !corBranca; // Alterna a cor das casas
        }

        // Desenha as letras na parte superior
        x = 50 + TAMANHO_CASA / 2 - 5; // Centraliza a letra na casa
        y = ESPACO_SUPERIOR - 20; // Posição acima do tabuleiro
        for (char c = 'A'; c <= 'H'; c++) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString(String.valueOf(c), x, y);
            x += TAMANHO_CASA;
        }

        // Desenha os números nas laterais
        x = 30; // Posição à esquerda do tabuleiro
        y = ESPACO_SUPERIOR + TAMANHO_CASA / 2 + 5; // Centraliza o número na casa
        for (int i = 8; i >= 1; i--) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString(String.valueOf(i), x, y);
            y += TAMANHO_CASA;
        }
        
        // Desenha as peças
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                PecaIcone peca = tabuleiro[i][j];
                if (peca != null) {
                    int xPos = ESPACO_LATERAL + j * TAMANHO_CASA + (TAMANHO_CASA - peca.getIcone().getIconWidth()) / 2;
                    int yPos = ESPACO_SUPERIOR + i * TAMANHO_CASA + (TAMANHO_CASA - peca.getIcone().getIconHeight()) / 2;
                    ImageIcon icone = peca.getIcone();
                    Image imagem = icone.getImage();
                    g.drawImage(imagem, xPos, yPos, null);
                }
            }
        }
    }
    
    private ImageIcon carregarIconeDaWeb(String url) {
        try {
            URL urlIcone = new URL(url);
            return new ImageIcon(urlIcone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    private ImageIcon redimensionarIcone(ImageIcon icone, int largura, int altura) {
        Image imagem = icone.getImage();
        Image imagemRedimensionada = imagem.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(imagemRedimensionada);
    }
}
