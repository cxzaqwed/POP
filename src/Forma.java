import java.awt.*;

public abstract class Forma {
    public abstract void desenhar(Graphics g);
    
    public void desenhaPixel(Graphics g, int x, int y){
        g.drawLine(x, y, x, y);
    }
}
