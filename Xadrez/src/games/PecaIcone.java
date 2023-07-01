package games;
import javax.swing.ImageIcon;

public class PecaIcone {
    private ImageIcon icone;
    private String cor;

    public PecaIcone(ImageIcon icone, String cor) {
        this.icone = icone;
        this.cor = cor;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public String getCor() {
        return cor;
    }
}

