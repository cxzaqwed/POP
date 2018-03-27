import java.awt.*;

public class Quadrado extends Forma {
    private int x_inicial;
    private int y_inicial;
    private int x_final;
    private int y_final;
    
    public Quadrado(int xi, int yi, int xf, int yf){
        this.x_inicial = xi;
        this.y_inicial = yi;
        this.x_final = xf;
        this.y_final = yf;
    }
    
    public void desenhar(Graphics g){
        for(int i = x_inicial; i <= x_final; i++){
            super.desenhaPixel(g, i, y_inicial);
            super.desenhaPixel(g, i, y_final);
        }
        for(int i = y_inicial; i <= y_final; i++){
            super.desenhaPixel(g, x_inicial, i);
            super.desenhaPixel(g, x_final, i);
        }
    }
}
