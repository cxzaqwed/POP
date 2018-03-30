import java.awt.*;
import java.lang.Math;

public class Reta extends Forma{
    private Ponto pontoInicial;
    private Ponto pontoFinal;
    
    
    public Reta(Ponto pi, Ponto pf, Color cor){
        super.setCor(cor);
        this.pontoInicial = pi;
        this.pontoFinal = pf;
    }
    
    public void desenhar(Graphics g){
        g.setColor(super.getCor()); // remover quando devolver a primitiva manual
        g.drawLine(this.pontoInicial.getX(), this.pontoInicial.getY(), this.pontoFinal.getX(), this.pontoFinal.getY());
        /*if (this.pontoInicial.getX() == this.pontoFinal.getX()){
            DDA(g);
        } else {
            // A ideia era usar esse mas n deu muito certo
            //Bresenham(g); 
            algoritmoNadaAVerLentoParaDesenharRetasQueEuSoFizPqOBresenhamNaoFuncionaPraTodosOsCasos(g);
        } */
    }
    
    public void DDA(Graphics g){
        float x = (float) this.pontoInicial.getX();
        float y = (float) this.pontoInicial.getY();
        
        int dx = this.pontoFinal.getX() - this.pontoInicial.getX();
        int dy = this.pontoFinal.getY() - this.pontoInicial.getY();
        
        int passos = 0;
        
        if (dx > dy){
            passos = Math.abs(dx);
        } else {
            passos = Math.abs(dy);
        }
        
        float incrementoX = (float) dx / passos;
        float incrementoY = (float) dy / passos;
        
        for (int i = 0; i < passos; i++){
            x += incrementoX;
            y += incrementoY;
            
            super.desenhaPixel(g, (int) x, (int) y);
        }
    }
    
    public void Bresenham(Graphics g){
        int dx, dy, incrE, incrNE, p, x, y, x2, y2, passoY;
        
        dx = Math.abs(this.pontoFinal.getX() - this.pontoInicial.getX());
        dy = Math.abs(this.pontoFinal.getY() - this.pontoInicial.getY());
        
        x = this.pontoInicial.getX();
        y = this.pontoInicial.getY();
        x2 = this.pontoFinal.getX();
        y2 = this.pontoFinal.getY();
        
        p = 2 * (dy - dx);
        
        incrE = 2 * dy;
        incrNE = 2 * dy - 2 * dx;
        
        if (y2 - y < 0){
            passoY = -1;
        } else {
            passoY = 1;
        }
        
        super.desenhaPixel(g, x, y);
        while(x < x2){
            x++;
            
            if (p < 0){
                p += incrE;
            } else {
                y += passoY;
                p += incrNE;
            }
            
            super.desenhaPixel(g, x, y);
        }
    }
    
    public void algoritmoNadaAVerLentoParaDesenharRetasQueEuSoFizPqOBresenhamNaoFuncionaPraTodosOsCasos(Graphics g){
        int x, y, x2, y2;
        if (this.pontoInicial.getX() > this.pontoFinal.getX()){
            x2 = this.pontoInicial.getX();
            y2 = this.pontoInicial.getY();
            x = this.pontoFinal.getX();
            y = this.pontoFinal.getY();
        } else {
            x = this.pontoInicial.getX();
            y = this.pontoInicial.getY();
            x2 = this.pontoFinal.getX();
            y2 = this.pontoFinal.getY();
        }
        
        int dx = x2 - x;
        int dy = y2 - y;
        
        int incrX = (x2 > x) ? 1 : -1;
        int incrY = (y2 > y) ? 1 : -1;
        
        float proporcao = (dy > dx) ? Math.abs((float) dy / (float) dx) : Math.abs((float) dx / (float) dy);
        float erro = 0.0f;
        
        super.desenhaPixel(g, x, y);
        while (x < x2){
            if (erro < 0.5f){
                x += incrX;
                y += incrY;
                erro += proporcao - 1.0f;
            } else if (Math.abs(dy) > Math.abs(dx)){
                y += incrY;
                erro -= 1.0f;
            } else {
                x += incrX;
                erro -= 1.0f;
            }
            
            super.desenhaPixel(g, x, y);
        }
    }
    
    public String getNome(){
        return "Reta";
    }
}
