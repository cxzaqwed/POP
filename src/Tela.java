import java.awt.*;

public class Tela {
    private Color[][] matriz;
    
    public Tela(){
        matriz = new Color[600][600];
        
        for(int i = 0; i < 600; i++){
            for(int j = 0; j < 600; j++){
                matriz[i][j] = Color.white;
            }
        }
    }

    public void desenhar(Graphics g) {
        for(int i = 0; i < 600; i++){
            for(int j = 0; j < 600; j++){
                g.setColor(matriz[i][j]);
                g.drawLine(i, j, i, j);
            }
        }
    }
    
    public void desenhaPixel(int x, int y, Color cor){
        try{
            matriz[x][y] = cor;
        } catch (Exception e){}
    }
    
    public void preencherCor(int x, int y, Color cor){
        if ((x < 600 && x >= 0) && (y < 600 && y >= 0)){
            floodfill(x, y, matriz[x][y], cor);
        }
    }
    
    public void floodfill(int x, int y, Color orig, Color sub){
        if ((x < 600 && x >= 0) && (y < 600 && y >= 0)){
            if (matriz[x][y] == orig){
                matriz[x][y] = sub;
                
                floodfill(x + 1, y, orig, sub);
                floodfill(x - 1, y, orig, sub);
                floodfill(x, y + 1, orig, sub);
                floodfill(x, y - 1, orig, sub);             
            }
        }
    }
}
