package games;
import javax.swing.ImageIcon;

public class PecaIcone {
    private ImageIcon icone;
     private Peca peca;

    public PecaIcone(ImageIcon icone, Peca peca) {
        this.icone = icone;
        this.peca = peca;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public Peca getPeca() {
        return peca;
    }
}

