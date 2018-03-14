
import java.awt.Color;
import javax.swing.*;

public class editorMain {

    public static void main(String[] args) {

        JFrame janela = new JFrame("POP");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
        janela.setLocationRelativeTo(janela);
        janela.setSize(800, 600);
        janela.getContentPane().setBackground(Color.CYAN);

    }

}