import java.awt.*;
import java.lang.Math;

public class Reta extends Forma{
    private Ponto pontoInicial;
    private Ponto pontoFinal;
    
    
    public Reta(Ponto pi, Ponto pf){
        this.pontoInicial = pi;
        this.pontoFinal = pf;
    }
    
    public void desenhar(Graphics g){
        g.drawLine(this.pontoInicial.getX(), this.pontoInicial.getY(), this.pontoFinal.getX(), this.pontoFinal.getY());
    }
}
