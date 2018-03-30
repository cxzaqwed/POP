import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Painel extends JPanel {
    private Camadas camadas;
    
    private ArrayList<Forma> formas = new ArrayList<>();
    private ArrayList<Ponto> pontos = new ArrayList<>();
    private String modo = "Reta";
    
    
    public Painel(Camadas c){
        this.camadas = c;
        
        MouseHandler mousehandler = new MouseHandler();
        addMouseListener(mousehandler);
        
        KeyHandler keyhandler = new KeyHandler();
        addKeyListener(keyhandler);
        
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        for(Forma f: formas){
            f.desenhar(g);
        }
        
        for(Ponto p: pontos){
            new Circulo(p, 3).desenhar(g);
        }
    }
    
    public void adicionarPonto(Ponto p){
        this.pontos.add(p);
        
        super.getParent().repaint();
    }
    
    public void removerPonto(){
        if(this.pontos.size() > 0){
            pontos.remove(pontos.get(pontos.size() - 1));
        }
        
        super.getParent().repaint();
    }
    
    public void adicionarForma(Forma f){
        formas.add(f);
        camadas.adicionarCamada(f.getNome());
        
        super.getParent().repaint();
    }
    
    public void removerForma(int indice){
        if(this.formas.size() > 0){
            formas.remove(formas.get(indice));
            camadas.removerCamada(indice);
        }
        
        super.getParent().repaint();
    }
    
    public void setModo(String m){
        this.modo = m;
        pontos.clear();
    }
    
    public ArrayList getFormas(){
        return this.formas;
    }
    
    private class MouseHandler implements MouseListener {
        public void mousePressed(MouseEvent me) {}

        public void mouseReleased(MouseEvent me) {
            if (modo.equals("Reta")){
                adicionarPonto(new Ponto(me.getX(), me.getY()));
                
                if (pontos.size() >= 2){
                    adicionarForma(new Reta(pontos.get(0), pontos.get(1)));
                    pontos.clear();
                }
            }
            
            else if (modo.equals("Quadrado")){
                adicionarPonto(new Ponto(me.getX(), me.getY()));
                
                if (pontos.size() >= 2){
                    adicionarForma(new Quadrado(pontos.get(0), new Ponto(pontos.get(0).getX(), pontos.get(1).getY()), new Ponto(pontos.get(1).getX(), pontos.get(0).getY()), pontos.get(1)));
                    pontos.clear();
                }
            }
            
            else if (modo.equals("Circulo")){
                adicionarPonto(new Ponto(me.getX(), me.getY()));
                
                if (pontos.size() >= 2){
                    adicionarForma(new Circulo(pontos.get(0), (int) pontos.get(0).distancia(pontos.get(1))));
                    pontos.clear();
                }
            }
            
            else if (modo.equals("Polilinha")){
                adicionarPonto(new Ponto(me.getX(), me.getY()));
            }
            
            else if (modo.equals("Poligono")){
                adicionarPonto(new Ponto(me.getX(), me.getY()));
            }
        }

        public void mouseEntered(MouseEvent me) {
            requestFocus();
        }

        public void mouseExited(MouseEvent me) {}

        public void mouseClicked(MouseEvent me) {}
    }
    
    private class KeyHandler implements KeyListener {
        public void keyTyped(KeyEvent ke) {}

        public void keyPressed(KeyEvent ke) {}

        public void keyReleased(KeyEvent ke) {
            // tecla enter
            if(ke.getKeyCode() == 10){
                if(modo.equals("Polilinha")){
                    adicionarForma(new Polilinha(new ArrayList(pontos)));
                    pontos.clear();
                }
                
                else if(modo.equals("Poligono")){
                    adicionarForma(new Poligono(new ArrayList(pontos)));
                    pontos.clear();
                }
            }
            
            
            
            // tecla delete
            else if(ke.getKeyCode() == KeyEvent.VK_DELETE){
                removerForma(camadas.getSelecionado());
                pontos.clear();              
            };
        }   
    }
}

