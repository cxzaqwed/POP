import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Painel extends JPanel {
    
    public ArrayList<Forma> formas = new ArrayList<>();
    
    public Painel(){
        //formas.add(new Quadrado(new Ponto(0, 0), new Ponto(0, 100), new Ponto(100, 0), new Ponto(100, 100)));
        //formas.add(new Quadrado(new Ponto(100, 100), new Ponto(100, 200), new Ponto(200, 100), new Ponto(250, 250)));
        
        //formas.add(new Reta(new Ponto(0, 0), new Ponto(0, 120)));
        //formas.add(new Reta(new Ponto(0, 520), new Ponto(100, 100)));
        formas.add(new Reta(new Ponto(0, 0), new Ponto(100, 300)));
        formas.add(new Reta(new Ponto(0, 0), new Ponto(100, 400)));
        formas.add(new Reta(new Ponto(0, 0), new Ponto(123, 19)));
        formas.add(new Reta(new Ponto(100, 300), new Ponto(400, 0)));
        formas.add(new Reta(new Ponto(50, 300), new Ponto(0, 0)));
        formas.add(new Reta(new Ponto(300, 300), new Ponto(200, 400)));
        formas.add(new Reta(new Ponto(300, 300), new Ponto(300, 500)));
        formas.add(new Reta(new Ponto(300, 300), new Ponto(500, 300)));
        
        formas.add(new Circulo(new Ponto(300, 300), 100));
        
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
    }
    
    public void adicionarForma(Forma f){
        formas.add(f);
    }
    
    public void removerForma(int indice){
        formas.remove(formas.get(indice));
    }
}

