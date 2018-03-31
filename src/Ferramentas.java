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
    private JButton botaoRotacao;
    
    public Ferramentas(Painel p){
        super.setBackground(Color.yellow);
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        ButtonHandler handler = new ButtonHandler();
          
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
        
        botaoRotacao = new JButton("Rotacao");
        super.add(botaoRotacao);
        
        botaoReta.addActionListener(handler);
        botaoQuadrado.addActionListener(handler);
        botaoCirculo.addActionListener(handler);
        botaoPoligono.addActionListener(handler);
        botaoPolilinha.addActionListener(handler);
        botaoRotacao.addActionListener(handler);
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
            else if(event.getActionCommand().equals("Rotacao")){
                painel.setModo("Nenhum");
                
                try{
                    painel.rotacionarForma(Float.parseFloat(JOptionPane.showInputDialog(getParent(),"Digite a rotação desejada", null)));
                }catch (Exception e){}
            }
        } 
    }
}

