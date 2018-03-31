import java.awt.*;
import java.util.*;

public class Poligono extends Forma {
    private ArrayList<Ponto> pontos;
    
    public Poligono(ArrayList<Ponto> pts, Color cor){
        super.setCor(cor);
        this.pontos = pts;
    }
    
    public void desenhar(Graphics g){
        int i = 0;
        
        // Poligono com 2 pontos é exatamente uma reta
        if (pontos.size() == 2){
            new Reta(pontos.get(0), pontos.get(1), super.getCor()).desenhar(g);
        } 
        // Poligono com menos de 3 pontos não é desenhada, com 3 ou mais pontos é desenhada
        else {
            while (i < pontos.size() - 1){
                new Reta(pontos.get(i), pontos.get(i + 1), super.getCor()).desenhar(g);
                i++;
            }
            // o último ponto é ligado ao primeiro
            new Reta(pontos.get(i), pontos.get(0), super.getCor()).desenhar(g);
        }
    }
    
    public String getNome(){
        return "Poligono";
    }
    
    public void adicionarPonto(Ponto p){
        this.pontos.add(p);
    }
    
    public void removerPonto(Ponto p){
        this.pontos.remove(p);
    }
    
    public void transladar(Ponto delta){
        for(Ponto p: pontos){
            p.setX(p.getX() + delta.getX());
            p.setY(p.getY() + delta.getY());
        }
    }
    
    public void rotacionar(float angulo){
        Double ang = Math.toRadians(angulo);
        
        ArrayList<Ponto> pontosNovos = new ArrayList<>();
        
        int menor_x = pontos.get(0).getX(), menor_y = pontos.get(0).getY(), maior_x = pontos.get(0).getX(), maior_y = pontos.get(0).getX();
        for(Ponto p: pontos){
            menor_x = (p.getX() < menor_x) ? p.getX() : menor_x;
            maior_x = (p.getX() > maior_x) ? p.getX() : maior_x;
            menor_y = (p.getY() < menor_y) ? p.getY() : menor_y;
            maior_y = (p.getY() > maior_y) ? p.getY() : maior_y;
        }
        
        
        int x_central = menor_x + (maior_x - menor_x) / 2;
        int y_central = menor_y + (maior_y - menor_y) / 2;
        
        transladar(new Ponto(-x_central, -y_central));
        
        for(Ponto p: pontos){
            pontosNovos.add(new Ponto((int) (p.getX() * Math.cos(ang) - p.getY() * Math.sin(ang)), ((int) (p.getY() * Math.cos(ang) + p.getX() * Math.sin(ang)))));
        }
        
        pontos = pontosNovos;
        
        transladar(new Ponto(x_central, y_central));
    }
}
