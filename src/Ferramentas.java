import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ferramentas extends JPanel {
    private Painel painel;
    
    private JButton botaoReta;
    private JButton botaoQuadrado;
    private JButton botaoCirculo;
    private JButton botaoPoligono;
    private JButton botaoPolilinha;
    
    public Ferramentas(Painel p){
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        
        painel = p;
        
        botaoReta = new JButton("Reta");
        super.add(botaoReta);
        
        botaoQuadrado = new JButton("Quadrado");
        super.add(botaoQuadrado);
        
        botaoCirculo = new JButton("Circulo");
        super.add(botaoCirculo);
        
        botaoPoligono = new JButton("Poligono");
        super.add(botaoPoligono);
        
        botaoPolilinha = new JButton("Polilinha");
        super.add(botaoPolilinha);
        
        ButtonHandler handler = new ButtonHandler();
        botaoReta.addActionListener(handler);
        botaoQuadrado.addActionListener(handler);
        botaoCirculo.addActionListener(handler);
        botaoPoligono.addActionListener(handler);
        botaoPolilinha.addActionListener(handler);
    }
    
    public Painel getPainel(){
        return this.painel;
    }
    
    private class ButtonHandler implements ActionListener{
        public void actionPerformed( ActionEvent event ){
            if(event.getActionCommand().equals("Reta")){
                painel.setModo("Reta");
            }
            else if(event.getActionCommand().equals("Quadrado")){
                painel.setModo("Quadrado");
            }
            else if(event.getActionCommand().equals("Circulo")){
                painel.setModo("Circulo");
            }
            else if(event.getActionCommand().equals("Poligono")){
                painel.setModo("Poligono");
            }
            else if(event.getActionCommand().equals("Polilinha")){
                painel.setModo("Polilinha");
            }
        } 
    }
}

