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
        //g.setColor(super.getCor()); // remover quando devolver a primitiva manual
        //g.drawLine(this.pontoInicial.getX(), this.pontoInicial.getY(), this.pontoFinal.getX(), this.pontoFinal.getY());
        
        // DDA deixa buracos na reta
        // Bresenham só funciona no primeiro octante
        Lucas(g); // ¯\_(ツ)_/¯
    }
    
    public void rasterizar(Tela t){
        Lucas(t);
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

    public void Lucas (Graphics g){ // algoritmo temporário
        // delta x e y
        int dx = pontoFinal.getX() - pontoInicial.getX();
        int dy = pontoFinal.getY() - pontoInicial.getY();
        
        // início do loop
        int x = pontoInicial.getX();
        int y = pontoInicial.getY();
        
        // define a direção dos incrementos
        int incx = 0;
        if (dx > 0)
            incx = 1;
        else if (dx < 0)
            incx = -1;
        
        // define a direção dos incrementos
        int incy = 0;
        if (dy > 0)
            incy = 1;
        else if (dy < 0)
            incy = -1;
        
        // faz os deltas serem positivos (para o loop funcionar)
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        
        // calcula a proporção entre os deltas (a inclinação da reta)
        float dxdy = Math.abs((float) dx / (float) dy);
        
        // desenha o primeiro pixel
        super.desenhaPixel(g, x, y);
        
        // repete enquanto existir diferença entre o x,y atual e x,y final
        while (dx > 0 || dy > 0){
            // caso a proporção atual seja menor que a inicial (reta inclinada demais no eixo x)
            if ((float) dx / (float) dy < dxdy){
                // anda no eixo y, decrementa o delta y restante
                y += incy;
                dy--;
            } else { // caso contrário
                // anda no eixo x, decrementa o delta x restante
                x += incx;
                dx--;
            }
            
            // desenha o pixel no local calculado
            super.desenhaPixel(g, x, y);
        }
    }
    
    public void Lucas (Tela t){ // algoritmo temporário
        // delta x e y
        int dx = pontoFinal.getX() - pontoInicial.getX();
        int dy = pontoFinal.getY() - pontoInicial.getY();
        
        // início do loop
        int x = pontoInicial.getX();
        int y = pontoInicial.getY();
        
        // define a direção dos incrementos
        int incx = 0;
        if (dx > 0)
            incx = 1;
        else if (dx < 0)
            incx = -1;
        
        // define a direção dos incrementos
        int incy = 0;
        if (dy > 0)
            incy = 1;
        else if (dy < 0)
            incy = -1;
        
        // faz os deltas serem positivos (para o loop funcionar)
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        
        // calcula a proporção entre os deltas (a inclinação da reta)
        float dxdy = Math.abs((float) dx / (float) dy);
        
        // desenha o primeiro pixel
        t.desenhaPixel(x, y, super.getCor());
        
        // repete enquanto existir diferença entre o x,y atual e x,y final
        while (dx > 0 || dy > 0){
            // caso a proporção atual seja menor que a inicial (reta inclinada demais no eixo x)
            if ((float) dx / (float) dy < dxdy){
                // anda no eixo y, decrementa o delta y restante
                y += incy;
                dy--;
            } else { // caso contrário
                // anda no eixo x, decrementa o delta x restante
                x += incx;
                dx--;
            }
            
            // desenha o pixel no local calculado
            t.desenhaPixel(x, y, super.getCor());
        }
    }
    
    public String getNome(){
        return "Reta";
    }
    
    public void transladar(Ponto delta){
        pontoInicial.setX(pontoInicial.getX() + delta.getX());
        pontoInicial.setY(pontoInicial.getY() + delta.getY());
        pontoFinal.setX(pontoFinal.getX() + delta.getX());
        pontoFinal.setY(pontoFinal.getY() + delta.getY());
    }
    
    public void rotacionar(float angulo){
        Double ang = Math.toRadians(angulo);
        Ponto centro = getCentro();
        
        Ponto pontoInicialNovo = new Ponto();
        Ponto pontoFinalNovo = new Ponto();

        transladar(centro.getReverso());
                
        pontoInicialNovo.setX((int) (pontoInicial.getX() * Math.cos(ang) - pontoInicial.getY() * Math.sin(ang)));
        pontoInicialNovo.setY(((int) (pontoInicial.getY() * Math.cos(ang) + pontoInicial.getX() * Math.sin(ang))));
        pontoFinalNovo.setX((int) (pontoFinal.getX() * Math.cos(ang) - pontoFinal.getY() * Math.sin(ang)));
        pontoFinalNovo.setY(((int) (pontoFinal.getY() * Math.cos(ang) + pontoFinal.getX() * Math.sin(ang))));
        
        this.pontoInicial = pontoInicialNovo;
        this.pontoFinal = pontoFinalNovo;

        transladar(centro);
    }
    
    public Ponto getCentro(){
        return new Ponto(pontoInicial.getX() + (pontoFinal.getX() - pontoInicial.getX()) / 2, pontoInicial.getY() + (pontoFinal.getY() - pontoInicial.getY()) / 2);
    }
    
    public void escalar(float proporcao){
        Ponto centro = getCentro();
        
        Ponto pontoInicialNovo = new Ponto();
        Ponto pontoFinalNovo = new Ponto();

        transladar(centro.getReverso());
                
        pontoInicialNovo.setX((int) (pontoInicial.getX() * proporcao));
        pontoInicialNovo.setY(((int) (pontoInicial.getY() * proporcao)));
        pontoFinalNovo.setX((int) (pontoFinal.getX() * proporcao));
        pontoFinalNovo.setY(((int) (pontoFinal.getY() * proporcao)));
        
        this.pontoInicial = pontoInicialNovo;
        this.pontoFinal = pontoFinalNovo;

        transladar(centro);
    }
}
