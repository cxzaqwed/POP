import java.awt.*;
import javax.swing.*;

public class POP {
   public static void main (String [ ] args) {
      JFrame janela = new JFrame();

      janela.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      janela.setSize(800, 600);
      janela.setVisible(true);
      janela.setLocationRelativeTo(null);
      janela.setResizable(true);

      Camadas camadas = new Camadas();
      Painel painel = new Painel(camadas);
      Ferramentas ferramentas = new Ferramentas(painel);   
      
      janela.add(ferramentas, BorderLayout.WEST);
      janela.add(painel, BorderLayout.CENTER);
      janela.add(camadas, BorderLayout.EAST);
      
      janela.repaint();
   }
}  