import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ferramentas extends JPanel {
    private Painel painel;
    
    private ButtonGroup grupo;
    
    private JToggleButton botaoReta;
    private JToggleButton botaoQuadrado;
    private JToggleButton botaoCirculo;
    private JToggleButton botaoPoligono;
    private JToggleButton botaoPolilinha;
    private JToggleButton botaoRotacao;
    private JToggleButton botaoTranslacao;
    
    public Ferramentas(Painel p){
        super.setBackground(Color.yellow);
        super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
        ButtonHandler handler = new ButtonHandler();
          
        painel = p;
        grupo = new ButtonGroup();
        
        
        botaoReta = new JToggleButton("Reta");
        grupo.add(botaoReta);
        super.add(botaoReta);
        
        botaoQuadrado = new JToggleButton("Quadrado");
        grupo.add(botaoQuadrado);
        super.add(botaoQuadrado);
        
        botaoCirculo = new JToggleButton("Circulo");
        grupo.add(botaoCirculo);
        super.add(botaoCirculo);
        
        botaoPoligono = new JToggleButton("Poligono");
        grupo.add(botaoPoligono);
        super.add(botaoPoligono);
        
        botaoPolilinha = new JToggleButton("Polilinha");
        grupo.add(botaoPolilinha);
        super.add(botaoPolilinha);
        
        botaoRotacao = new JToggleButton("Rotacao");
        grupo.add(botaoRotacao);
        super.add(botaoRotacao);
        
        botaoTranslacao = new JToggleButton("Translacao");
        grupo.add(botaoTranslacao);
        super.add(botaoTranslacao);
        
        botaoReta.addActionListener(handler);
        botaoQuadrado.addActionListener(handler);
        botaoCirculo.addActionListener(handler);
        botaoPoligono.addActionListener(handler);
        botaoPolilinha.addActionListener(handler);
        botaoRotacao.addActionListener(handler);
        botaoTranslacao.addActionListener(handler);
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
                painel.setModo("Rotacao");
                try{
                    painel.rotacionarForma(Float.parseFloat(JOptionPane.showInputDialog(getParent(),"Digite a rotação desejada", null)));
                }catch (Exception e){}
            }
            else if(event.getActionCommand().equals("Translacao")){
                painel.setModo("Translacao");
            }
        } 
    }
}

