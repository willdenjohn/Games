package games;
import javax.swing.*;
import java.awt.*;
public class Games {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TabuleiroXadrez();
            }
        });
    }
    
}
