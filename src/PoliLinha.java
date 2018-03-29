import java.awt.*;
import java.util.*;

public class PoliLinha extends Forma {
    private ArrayList<Ponto> pontos;
    
    public PoliLinha(ArrayList<Ponto> pts){
        this.pontos = pts;
    }
    
    public void desenhar(Graphics g){
        int i = 0;
        
        // Polilinha com 2 pontos é exatamente uma reta
        if (pontos.size() == 2){
            new Reta(pontos.get(0), pontos.get(1)).desenhar(g);
        } 
        // Polilinha com menos de 3 pontos não é desenhada, com 3 ou mais pontos é desenhada
        else {
            while (i < pontos.size() - 1){
                new Reta(pontos.get(i), pontos.get(i + 1)).desenhar(g);
                i++;
            }
            // o último ponto é ligado ao primeiro
            new Reta(pontos.get(i), pontos.get(0)).desenhar(g);
        }
    }
    
    public void adicionarPonto(Ponto p){
        this.pontos.add(p);
    }
    
    public void removerPonto(Ponto p){
        this.pontos.remove(p);
    }
}