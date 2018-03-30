import java.awt.*;
import javax.swing.*;

public class Camadas extends JPanel {
    private JButton botaoReta;
    
    public Camadas(){
        super.setBackground(Color.BLACK);
        
        botaoReta = new JButton("Reta");
        super.add(botaoReta);
        
        
    }
    
}
