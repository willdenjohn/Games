package games;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class TabuleiroXadrez extends JFrame {

    private static final int TAMANHO_CASA = 60;
    private static final int TAMANHO_TABULEIRO = 8 * TAMANHO_CASA;
    private static final int ESPACO_SUPERIOR = 80;
    private static final int ESPACO_LATERAL = 50;
    private String turno = "branca";

    private PecaIcone[][] tabuleiro;

    public TabuleiroXadrez() {
        setTitle("Tabuleiro de Xadrez");
        setSize(TAMANHO_TABULEIRO + 50, TAMANHO_TABULEIRO + ESPACO_SUPERIOR + 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        //Carrega os ícones de peças da web
        //peças brancas
        //peão
        ImageIcon peaoBrancaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/37/759/png-transparent-chess-figure-white-pawn.png");
        peaoBrancaIcone = redimensionarIcone(peaoBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca peaoBranca = new Peca("peao", "branca");
        //Torre
        ImageIcon torreBrancaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/634/135/png-transparent-chess-piece-rook-pawn-king-tour-white-furniture-king.png");
        torreBrancaIcone = redimensionarIcone(torreBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca torreBranca = new Peca("torre", "branca");
        //Cavalo
        ImageIcon cavaloBrancaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/655/557/png-transparent-chess-piece-xiangqi-chessboard-knight-chess-game-king-text.png");
        cavaloBrancaIcone = redimensionarIcone(cavaloBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca cavaloBranca = new Peca("cavalo", "branca");
        //Bispo
        ImageIcon bispoBrancaIcone = carregarIconeDaWeb("https://w1.pngwing.com/pngs/710/927/png-transparent-knight-chess-bishop-chess-piece-king-queen-bishop-and-knight-checkmate-rook.png");
        bispoBrancaIcone = redimensionarIcone(bispoBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca bispoBranca = new Peca("cavalo", "branca");
        //Rei
        ImageIcon reiBrancaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/941/572/png-transparent-chess-piece-chessboard-knight-chess-king-queen-sports.png");
        reiBrancaIcone = redimensionarIcone(reiBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca reiBranca = new Peca("cavalo", "branca");
        //Rainha
        ImageIcon rainhaBrancaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/141/495/png-transparent-chess-piece-queen-king-pin-ajedrez-king-pin-queen.png");
        rainhaBrancaIcone = redimensionarIcone(rainhaBrancaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca rainhaBranca = new Peca("cavalo", "branca");

        //Carrega os ícones de peças da web
        //peças brancas
        //peão
        ImageIcon peaoPretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/812/57/png-transparent-chess-titans-king-chess-piece-pawn-chess-game-king-pin.png");
        peaoPretaIcone = redimensionarIcone(peaoPretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca peaoPreta = new Peca("peao", "preta");
        //Torre
        ImageIcon torrePretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/830/666/png-transparent-chess-t-shirt-rook-drawing-chess-black-sports-silhouette.png");
        torrePretaIcone = redimensionarIcone(torrePretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca torrePreta = new Peca("torre", "preta");
        //Cavalo
        ImageIcon cavaloPretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/124/1/png-transparent-chess-piece-knight-bishop-queen-cheess-horse-mammal-king.png");
        cavaloPretaIcone = redimensionarIcone(cavaloPretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca cavaloPreta = new Peca("cavalo", "preta");
        //Bispo
        ImageIcon bispoPretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/984/47/png-transparent-chess-piece-bishop-pawn-queen-chess-game-king-sports.png");
        bispoPretaIcone = redimensionarIcone(bispoPretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca bispoPreta = new Peca("bispo", "preta");
        //Rei
        ImageIcon reiPretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/172/558/png-transparent-chess-piece-king-queen-knight-chess-king-queen-sports.png");
        reiPretaIcone = redimensionarIcone(reiPretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca reiPreta = new Peca("rei", "preta");
        //Rainha
        ImageIcon rainhaPretaIcone = carregarIconeDaWeb("https://w7.pngwing.com/pngs/264/915/png-transparent-chess-piece-queen-bishop-white-and-black-in-chess-chess-king-hand-queen.png");
        rainhaPretaIcone = redimensionarIcone(rainhaPretaIcone, TAMANHO_CASA - 20, TAMANHO_CASA - 20);
        Peca rainhaPreta = new Peca("rainha", "preta");

        tabuleiro = new PecaIcone[8][8];

        // Posiciona as peças brancas na parte superior do tabuleiro
        tabuleiro[0][0] = new PecaIcone(torreBrancaIcone, torreBranca);
        tabuleiro[0][1] = new PecaIcone(cavaloBrancaIcone, cavaloBranca);
        tabuleiro[0][2] = new PecaIcone(bispoBrancaIcone, bispoBranca);
        tabuleiro[0][3] = new PecaIcone(reiBrancaIcone, reiBranca);
        tabuleiro[0][4] = new PecaIcone(rainhaBrancaIcone, rainhaBranca);
        tabuleiro[0][5] = new PecaIcone(bispoBrancaIcone, bispoBranca);
        tabuleiro[0][6] = new PecaIcone(cavaloBrancaIcone, cavaloBranca);
        tabuleiro[0][7] = new PecaIcone(torreBrancaIcone, torreBranca);
        //peões 
        tabuleiro[1][0] = new PecaIcone(peaoBrancaIcone, peaoBranca);
        tabuleiro[1][1] = new PecaIcone(peaoBrancaIcone, peaoBranca);
        tabuleiro[1][2] = new PecaIcone(peaoBrancaIcone, peaoBranca);
        tabuleiro[1][3] = new PecaIcone(peaoBrancaIcone, peaoBranca);
        tabuleiro[1][4] = new PecaIcone(peaoBrancaIcone, peaoBranca);
        tabuleiro[1][5] = new PecaIcone(peaoBrancaIcone, peaoBranca);
        tabuleiro[1][6] = new PecaIcone(peaoBrancaIcone, peaoBranca);
        tabuleiro[1][7] = new PecaIcone(peaoBrancaIcone, peaoBranca);

        // Posiciona as peças pretas na parte inferior do tabuleiro
        //peões 
        tabuleiro[6][0] = new PecaIcone(peaoPretaIcone, peaoPreta);
        tabuleiro[6][1] = new PecaIcone(peaoPretaIcone, peaoPreta);
        tabuleiro[6][2] = new PecaIcone(peaoPretaIcone, peaoPreta);
        tabuleiro[6][3] = new PecaIcone(peaoPretaIcone, peaoPreta);
        tabuleiro[6][4] = new PecaIcone(peaoPretaIcone, peaoPreta);
        tabuleiro[6][5] = new PecaIcone(peaoPretaIcone, peaoPreta);
        tabuleiro[6][6] = new PecaIcone(peaoPretaIcone, peaoPreta);
        tabuleiro[6][7] = new PecaIcone(peaoPretaIcone, peaoPreta);

        tabuleiro[7][0] = new PecaIcone(torrePretaIcone, torrePreta);
        tabuleiro[7][1] = new PecaIcone(cavaloPretaIcone, cavaloPreta);
        tabuleiro[7][2] = new PecaIcone(bispoPretaIcone, bispoPreta);
        tabuleiro[7][3] = new PecaIcone(reiPretaIcone, reiPreta);
        tabuleiro[7][4] = new PecaIcone(rainhaPretaIcone, rainhaPreta);
        tabuleiro[7][5] = new PecaIcone(bispoPretaIcone, bispoPreta);
        tabuleiro[7][6] = new PecaIcone(cavaloPretaIcone, cavaloPreta);
        tabuleiro[7][7] = new PecaIcone(torrePretaIcone, torrePreta);

    }

    private void moverPeca(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        PecaIcone pecaOrigem = tabuleiro[linhaOrigem][colunaOrigem];
        if (pecaOrigem != null && pecaOrigem.equals("torre") && pecaOrigem.getPeca().getCor().equals(getTurnoAtual())) {
            // Verifica se o movimento é válido para a Torre
            if (linhaOrigem == linhaDestino || colunaOrigem == colunaDestino) {
                // Verifica se não há nenhuma peça obstruindo o caminho
                if (verificarCaminhoLivre(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino)) {
                    // Realiza o movimento
                    tabuleiro[linhaDestino][colunaDestino] = pecaOrigem;
                    tabuleiro[linhaOrigem][colunaOrigem] = null;
                    turno = (turno.equals("branca")) ? "preta" : "branca";
                } else {
                    // Caminho obstruído, tratamento necessário
                }
            } else {
                // Movimento inválido para a Torre
            }
        } else {
            // Peça inválida ou fora do turno
        }
    }

    private boolean verificarCaminhoLivre(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        // Verifica se o caminho está livre de peças
        if (linhaOrigem == linhaDestino) {
            int colunaInicio = Math.min(colunaOrigem, colunaDestino);
            int colunaFim = Math.max(colunaOrigem, colunaDestino);
            for (int coluna = colunaInicio + 1; coluna < colunaFim; coluna++) {
                if (tabuleiro[linhaOrigem][coluna] != null) {
                    return false; // Caminho obstruído
                }
            }
        } else if (colunaOrigem == colunaDestino) {
            int linhaInicio = Math.min(linhaOrigem, linhaDestino);
            int linhaFim = Math.max(linhaOrigem, linhaDestino);
            for (int linha = linhaInicio + 1; linha < linhaFim; linha++) {
                if (tabuleiro[linha][colunaOrigem] != null) {
                    return false; // Caminho obstruído
                }
            }
        }
        return true; // Caminho livre
    }

    public void paint(Graphics g) {
        super.paint(g);
        // Desenha o tabuleiro
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int xPos = ESPACO_LATERAL + j * TAMANHO_CASA;
                int yPos = ESPACO_SUPERIOR + i * TAMANHO_CASA;

                // Altere a cor das casas alternadamente
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }

                g.fillRect(xPos, yPos, TAMANHO_CASA, TAMANHO_CASA);

                // Desenha as peças
                PecaIcone peca = tabuleiro[i][j];

                if (peca != null) {
                    int xPeca = xPos + (TAMANHO_CASA - peca.getIcone().getIconWidth()) / 2;
                    int yPeca = yPos + (TAMANHO_CASA - peca.getIcone().getIconHeight()) / 2;
                    ImageIcon icone = peca.getIcone();
                    Image imagem = icone.getImage();
                    g.drawImage(imagem, xPeca, yPeca, null);

                    // Identifica a peça
                    Peca pecaObj = peca.getPeca();
                    String tipoPeca = obterIdentificadorPeca(pecaObj);
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Arial", Font.PLAIN, 12));
                    g.drawString(tipoPeca, xPeca, yPeca + TAMANHO_CASA);
                }
            }
        }

        // Desenha as letras na parte superior
        int x = ESPACO_LATERAL + TAMANHO_CASA / 2 - 5;
        int y = ESPACO_SUPERIOR - 20;
        for (char c = 'A'; c <= 'H'; c++) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 16));
            g.drawString(String.valueOf(c), x, y);
            x += TAMANHO_CASA;
        }

        // Desenha os números nas laterais
        for (int linha = 0; linha < 8; linha++) {
            int numero = 8 - linha;
            int xNumero = ESPACO_LATERAL - 20;
            int yNumero = ESPACO_SUPERIOR + linha * TAMANHO_CASA + TAMANHO_CASA / 2 + 5;
            g.drawString(String.valueOf(numero), xNumero, yNumero);
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

    private String getTurnoAtual() {
        if (turno.equals("branca")) {
            return "Branca";
        } else {
            return "Preta";
        }
    }

    private String obterIdentificadorPeca(Peca peca) {
        if (peca instanceof Peao) {
            return "peao";
        } else if (peca instanceof Torre) {
            return "torre";
        } else if (peca instanceof Cavalo) {
            return "cavalo";
        } else if (peca instanceof Bispo) {
            return "bispo";
        } else if (peca instanceof Rainha) {
            return "rainha";
        } else if (peca instanceof Rei) {
            return "rei";
        } else {
            return "";
        }
    }

}
