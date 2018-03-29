import java.awt.*;

public class Circulo extends Forma {
    private Ponto pontoCentro;
    private int raio;
    
    public Circulo(Ponto pC, int r){
        this.pontoCentro = pC;
        this.raio = r;
    }
    
    @Override
    public void desenhar(Graphics g){
        g.drawOval(this.pontoCentro.getX() - raio, this.pontoCentro.getY() - raio, raio * 2, raio * 2);
    }
}