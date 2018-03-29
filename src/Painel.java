import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Painel extends JPanel {
    
    public ArrayList<Forma> formas = new ArrayList<>();
    
    public Painel(){
        formas.add(new Quadrado(new Ponto(0, 0), new Ponto(0, 100), new Ponto(100, 0), new Ponto(100, 100)));
        formas.add(new Circulo(new Ponto(300, 300), 100));
        
        ArrayList<Ponto> pts = new ArrayList<>();
        pts.add(new Ponto(100, 100));
        pts.add(new Ponto(100, 130));
        pts.add(new Ponto(220, 50));
        pts.add(new Ponto(40, 100));
        pts.add(new Ponto(300, 200));

        
        formas.add(new PoliLinha(pts));
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

