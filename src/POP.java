import javax.swing.JFrame;
public class POP {
   public static void main (String [ ] args) {
      Painel panel = new Painel ();
      JFrame application = new JFrame ();
      application.add ( panel );
      application.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
      application.setSize ( 600, 600 );
      application.setVisible ( true );
      application.setLocationRelativeTo (null);
      application.setResizable (true);
   }
}  