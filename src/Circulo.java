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
    
    public void rasterizar(Tela t){
        Bresenham(t, this.pontoCentro.getX(), this.pontoCentro.getY(), raio);
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
    
    void Bresenham(Tela t, int x_centro, int y_centro, int r)
    {
        // começa do ponto p=(0,r)
        int x = 0, y = r;
        // condição de decisão (se vai escrever o ponto p1=(x+1, y+1) ou o ponto p2=(x+1, y))
        int decisao = 3 - (2 * r);
        
        // repete para o primeiro octante (quando x = y)
        while (y >= x)
        {   // desenha o pixel correspondente em cada octante
            desenhaEspelhoOctantes(t, x_centro, y_centro, x, y);
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
    
    void desenhaEspelhoOctantes(Tela t, int x_centro , int y_centro, int x, int y)
    {
        // desenha um pixel em cada octante, dado o centro e as coordenadas relativas ao centro
        t.desenhaPixel(x_centro + x, y_centro + y, super.getCor());
        t.desenhaPixel(x_centro - x, y_centro + y, super.getCor());
        t.desenhaPixel(x_centro + x, y_centro - y, super.getCor());
        t.desenhaPixel(x_centro - x, y_centro - y, super.getCor());
        t.desenhaPixel(x_centro + y, y_centro + x, super.getCor());
        t.desenhaPixel(x_centro - y, y_centro + x, super.getCor());
        t.desenhaPixel(x_centro + y, y_centro - x, super.getCor());
        t.desenhaPixel(x_centro - y, y_centro - x, super.getCor());
    }
    
    public String getNome(){
        return "Circulo";
    }
    
    public Ponto getCentro(){
        return new Ponto(pontoCentro);
    }
    
    public void transladar(Ponto delta){
        pontoCentro.setX(pontoCentro.getX() + delta.getX());
        pontoCentro.setY(pontoCentro.getY() + delta.getY());
    }
    
    public void rotacionar(float angulo){} // rotação de círculo não faz sentido :p
    
    public void escalar(float proporcao){
        raio *= proporcao;
    }
}