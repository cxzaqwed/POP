import java.awt.*;

public class Circulo extends Forma {
    private Ponto pontoCentro;
    private int raio;
    
    public Circulo(Ponto pC, int r, Color cor){
        super.setCor(cor);
        this.pontoCentro = pC;
        this.raio = r;
    }
    
    @Override
    public void desenhar(Graphics g){
        Bresenham(g, this.pontoCentro.getX(), this.pontoCentro.getY(), raio);
        
    }
    // https://www.geeksforgeeks.org/bresenhams-circle-drawing-algorithm/
    void Bresenham(Graphics g, int x_centro, int y_centro, int r)
    {
        // começa do ponto p=(0,r)
        int x = 0, y = r;
        // condição de decisão (se vai escrever o ponto p1=(x+1, y+1) ou o ponto p2=(x+1, y))
        int decisao = 3 - (2 * r);
        
        // repete para o primeiro octante (quando x = y)
        while (y >= x)
        {   // desenha o pixel correspondente em cada octante
            desenhaEspelhoOctantes(g, x_centro, y_centro, x, y);
            // incrementa x
            x++;
            // decisao > 0 desenha o pixel acima e à direita
            if (decisao > 0)
            {   // sobe um pixel
                y--;              
                // atualiza a condição de decisão
                decisao += 4 * (x - y) + 10;
            } else { // desenha somente o pixel à direita
                // atualiza a condição de decisão
                decisao += 4 * x + 6;
            }
        }
    }
    
    void desenhaEspelhoOctantes(Graphics g, int x_centro , int y_centro, int x, int y)
    {
        // desenha um pixel em cada octante, dado o centro e as coordenadas relativas ao centro
        super.desenhaPixel(g, x_centro + x, y_centro + y);
        super.desenhaPixel(g, x_centro - x, y_centro + y);
        super.desenhaPixel(g, x_centro + x, y_centro - y);
        super.desenhaPixel(g, x_centro - x, y_centro - y);
        super.desenhaPixel(g, x_centro + y, y_centro + x);
        super.desenhaPixel(g, x_centro - y, y_centro + x);
        super.desenhaPixel(g, x_centro + y, y_centro - x);
        super.desenhaPixel(g, x_centro - y, y_centro - x);
    }
    
    public String getNome(){
        return "Circulo";
    }
    
    public void rotacionar(float angulo){}
}