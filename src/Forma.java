import java.awt.*;

public abstract class Forma {
    private Color cor = Color.BLACK;
    
    public abstract void desenhar(Graphics g);
    
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
