import java.awt.*;

public class Quadrado extends Forma {
    private Ponto pontoII;
    private Ponto pontoIF;
    private Ponto pontoFI;
    private Ponto pontoFF;
    
    public Quadrado(Ponto pII, Ponto pIF, Ponto pFI, Ponto pFF){
        this.pontoII = pII;
        this.pontoIF = pIF;
        this.pontoFI = pFI;
        this.pontoFF = pFF;
    }
    
    public void desenhar(Graphics g){
        new Reta(this.pontoII, this.pontoIF).desenhar(g);
        new Reta(this.pontoFI, this.pontoFF).desenhar(g);
        new Reta(this.pontoII, this.pontoFI).desenhar(g);
        new Reta(this.pontoIF, this.pontoFF).desenhar(g);
    }
    
    public String getNome(){
        return "Quadrado";
    }
}
