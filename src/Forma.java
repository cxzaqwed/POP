import java.awt.*;

public abstract class Forma {
    private Color cor = Color.BLACK;
    
    public abstract String getNome();
    
    public abstract void desenhar(Graphics g);
    
    public abstract void transladar(Ponto delta);
    
    public abstract void escalar(float proporcao);
    
    public abstract void rotacionar(float angulo);
    
    public abstract void rasterizar(Tela t);
    
    public abstract Ponto getCentro();
    
    public void desenhaPixel(Graphics g, int x, int y){
        g.setColor(cor);
        g.drawLine(x, y, x, y);
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }
}
