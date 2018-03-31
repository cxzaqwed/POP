import java.awt.*;
import java.lang.Math;

public class Quadrado extends Forma {
    private Ponto pontoII;
    private Ponto pontoIF;
    private Ponto pontoFI;
    private Ponto pontoFF;
    
    public Quadrado(Ponto pII, Ponto pIF, Ponto pFI, Ponto pFF, Color cor){
        super.setCor(cor);
        this.pontoII = pII;
        this.pontoIF = pIF;
        this.pontoFI = pFI;
        this.pontoFF = pFF;
    }
    
    public void desenhar(Graphics g){
        new Reta(this.pontoII, this.pontoIF, super.getCor()).desenhar(g);
        new Reta(this.pontoFI, this.pontoFF, super.getCor()).desenhar(g);
        new Reta(this.pontoII, this.pontoFI, super.getCor()).desenhar(g);
        new Reta(this.pontoIF, this.pontoFF, super.getCor()).desenhar(g);
    }
    
    public String getNome(){
        return "Quadrado";
    }
    
    public void transladar(Ponto delta){
        pontoII.setX(pontoII.getX() + delta.getX());
        pontoII.setY(pontoII.getY() + delta.getY());
        pontoIF.setX(pontoIF.getX() + delta.getX());
        pontoIF.setY(pontoIF.getY() + delta.getY());
        pontoFI.setX(pontoFI.getX() + delta.getX());
        pontoFI.setY(pontoFI.getY() + delta.getY());
        pontoFF.setX(pontoFF.getX() + delta.getX());
        pontoFF.setY(pontoFF.getY() + delta.getY());
    }
    
    public void rotacionar(float angulo){
        Double ang = Math.toRadians(angulo);
        Ponto centro = getCentro();
        
        Ponto pontoIINovo = new Ponto();
        Ponto pontoIFNovo = new Ponto();
        Ponto pontoFINovo = new Ponto();
        Ponto pontoFFNovo = new Ponto();
        
        transladar(centro.getReverso());
                
        pontoIINovo.setX((int) (pontoII.getX() * Math.cos(ang) - pontoII.getY() * Math.sin(ang)));
        pontoIINovo.setY(((int) (pontoII.getY() * Math.cos(ang) + pontoII.getX() * Math.sin(ang))));
        pontoIFNovo.setX((int) (pontoIF.getX() * Math.cos(ang) - pontoIF.getY() * Math.sin(ang)));
        pontoIFNovo.setY(((int) (pontoIF.getY() * Math.cos(ang) + pontoIF.getX() * Math.sin(ang))));
        pontoFINovo.setX((int) (pontoFI.getX() * Math.cos(ang) - pontoFI.getY() * Math.sin(ang)));
        pontoFINovo.setY(((int) (pontoFI.getY() * Math.cos(ang) + pontoFI.getX() * Math.sin(ang))));
        pontoFFNovo.setX((int) (pontoFF.getX() * Math.cos(ang) - pontoFF.getY() * Math.sin(ang)));
        pontoFFNovo.setY(((int) (pontoFF.getY() * Math.cos(ang) + pontoFF.getX() * Math.sin(ang))));
        
        this.pontoII = pontoIINovo;
        this.pontoIF = pontoIFNovo;
        this.pontoFI = pontoFINovo;
        this.pontoFF = pontoFFNovo;
        
        transladar(centro);
    }
    
    public Ponto getCentro(){
        return new Ponto(pontoII.getX() + (pontoFF.getX() - pontoII.getX()) / 2, pontoII.getY() + (pontoFF.getY() - pontoII.getY()) / 2);
    }
}
