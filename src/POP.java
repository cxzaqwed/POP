import javax.swing.JFrame;
public class POP {
   public static void main (String [ ] args) {
      Painel painel = new Painel();
      JFrame janela = new JFrame();
      //application.setBackground(Color.yellow);
      janela.add(painel);
      janela.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      janela.setSize(600, 600);
      janela.setVisible(true);
      janela.setLocationRelativeTo(null);
      janela.setResizable(true);
   }
}  