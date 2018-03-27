import java.awt.*;
import java.lang.Math.*;

public class Circulo extends Forma {
    private int x_centro;
    private int y_centro;
    private int raio;
    
    public Circulo(int xc, int yc, int r){
        this.x_centro = xc;
        this.y_centro = yc;
        this.raio = r;
    }
    
    @Override
    public void desenhar(Graphics g){
        
        for (Double angulo = 0.0; angulo < 90.0; angulo += 0.5){
            Double dx = Math.sin(Math.toRadians(angulo)) * raio;
            Double dy = Math.cos(Math.toRadians(angulo)) * raio;
            
            super.desenhaPixel(g, (int) (x_centro + dx), (int) (y_centro + dy));
            super.desenhaPixel(g, (int) (x_centro + dx), (int) (y_centro - dy));
            super.desenhaPixel(g, (int) (x_centro - dx), (int) (y_centro + dy));
            super.desenhaPixel(g, (int) (x_centro - dx), (int) (y_centro - dy));
        }
    }
}
