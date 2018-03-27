import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Painel extends JPanel {
    
    public ArrayList<Forma> formas = new ArrayList<>();
    
    public Painel(){
        formas.add(new Quadrado(0, 0, 100, 100));
        formas.add(new Quadrado(50, 50, 100, 100));
        formas.add(new Circulo(300, 300, 200));
        formas.add(new Circulo(300, 300, 50));
    }

    @Override
    public void paintComponent(Graphics g) {
        for(Forma f: formas){
            f.desenhar(g);
        }
    }
    
    public void removerForma(int indice){
        formas.remove(formas.get(indice));
    }
    
    public void adicionarForma(Forma f){
        formas.add(f);
    }
}

