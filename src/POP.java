import java.awt.*;
import javax.swing.*;

public class POP {
   public static void main (String [ ] args) {
      JFrame janela = new JFrame();
      janela.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      janela.setSize(600, 600);
      janela.setVisible(true);
      janela.setLocationRelativeTo(null);
      janela.setResizable(true);
      
      Painel painel = new Painel();
      Ferramentas ferramentas = new Ferramentas(painel);
      Camadas camadas = new Camadas();
      
      janela.add(ferramentas, BorderLayout.WEST);
      janela.add(painel, BorderLayout.CENTER);
      janela.add(camadas, BorderLayout.EAST);
   }
}  