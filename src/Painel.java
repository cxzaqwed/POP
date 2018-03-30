import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

public class Painel extends JPanel {
    private ArrayList<Forma> formas = new ArrayList<>();
    private ArrayList<Ponto> pontos = new ArrayList<>();
    private String modo = "Reta";
    
    
    public Painel(){
        MouseHandler mousehandler = new MouseHandler();
        addMouseListener(mousehandler);
        
        KeyHandler keyhandler = new KeyHandler();
        addKeyListener(keyhandler);
        
        setFocusable(true);
        
        
        formas.add(new Quadrado(new Ponto(100, 100), new Ponto(100, 200), new Ponto(200, 100), new Ponto(250, 250)));
        formas.add(new Reta(new Ponto(0, 0), new Ponto(0, 120)));
        formas.add(new Reta(new Ponto(500, 500), new Ponto(0, 600)));
        formas.add(new Reta(new Ponto(0, 520), new Ponto(100, 100)));
        formas.add(new Reta(new Ponto(0, 0), new Ponto(100, 300)));
        formas.add(new Reta(new Ponto(0, 0), new Ponto(100, 400)));
        formas.add(new Reta(new Ponto(0, 0), new Ponto(123, 19)));
        formas.add(new Reta(new Ponto(100, 300), new Ponto(400, 0)));
        formas.add(new Reta(new Ponto(50, 300), new Ponto(0, 0)));
        formas.add(new Reta(new Ponto(300, 300), new Ponto(200, 400)));
        formas.add(new Reta(new Ponto(300, 300), new Ponto(300, 500)));
        formas.add(new Reta(new Ponto(300, 300), new Ponto(500, 300)));
        //formas.add(new Circulo(new Ponto(300, 300), 100));
        
        ArrayList<Ponto> pts = new ArrayList<>();
        pts.add(new Ponto(100, 100));
        pts.add(new Ponto(100, 130));
        pts.add(new Ponto(220, 50));
        pts.add(new Ponto(40, 100));
        pts.add(new Ponto(300, 200));

        
        formas.add(new Polilinha(pts));
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
    
    public void adicionarForma(Forma f){
        formas.add(f);
    }
    
    public void removerForma(int indice){
        formas.remove(formas.get(indice));
    }
    
    public void setModo(String m){
        this.modo = m;
        pontos.clear();
    }
    
    private class MouseHandler implements MouseListener {
        public void mousePressed(MouseEvent me) {}

        public void mouseReleased(MouseEvent me) {
            if (modo.equals("Reta")){
                pontos.add(new Ponto(me.getX(), me.getY()));
                
                if (pontos.size() >= 2){
                    formas.add(new Reta(pontos.get(0), pontos.get(1)));
                    pontos.clear();
                }
            }
            
            else if (modo.equals("Quadrado")){
                pontos.add(new Ponto(me.getX(), me.getY()));
                
                if (pontos.size() >= 2){
                    formas.add(new Quadrado(pontos.get(0), new Ponto(pontos.get(0).getX(), pontos.get(1).getY()), new Ponto(pontos.get(1).getX(), pontos.get(0).getY()), pontos.get(1)));
                    pontos.clear();
                }
            }
            
            else if (modo.equals("Circulo")){
                pontos.add(new Ponto(me.getX(), me.getY()));
                
                if (pontos.size() >= 2){
                    formas.add(new Circulo(pontos.get(0), (int) pontos.get(0).distancia(pontos.get(1))));
                    pontos.clear();
                }
            }
            
            else if (modo.equals("Polilinha")){
                pontos.add(new Ponto(me.getX(), me.getY()));
            }
            
            else if (modo.equals("Poligono")){
                pontos.add(new Ponto(me.getX(), me.getY()));
                
                if (pontos.size() >= 2){
                    formas.add(new Reta(pontos.get(0), pontos.get(1)));
                    pontos.clear();
                }
            }
            
            getParent().repaint();
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
            System.out.println("asda");
            formas.add(new Polilinha(new ArrayList(pontos)));
            pontos.clear();
            
            getParent().repaint();
        }
        
    }
}

