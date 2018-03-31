import java.lang.Math;

public class Ponto {
    private int x;
    private int y;
    
    
    public Ponto(){
        this.x = 0;
        this.y = 0;
    }
    
    public Ponto(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public float distancia(Ponto p){
        return (float) Math.sqrt((Math.pow(x - p.getX(), 2)) + (Math.pow(y - p.getY(), 2)));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
