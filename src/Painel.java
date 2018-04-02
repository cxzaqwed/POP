
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Painel extends JPanel {

    private Camadas camadas;

    private Tela tela = new Tela();
    private ArrayList<Forma> formas = new ArrayList<>();
    private ArrayList<Ponto> pontos = new ArrayList<>();

    private Color cor = Color.black;
    private String modo = "Reta";

    public Painel(Camadas c) {
        this.camadas = c;

        MouseHandler mousehandler = new MouseHandler();
        addMouseListener(mousehandler);

        KeyHandler keyhandler = new KeyHandler();
        addKeyListener(keyhandler);

        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        tela.desenhar(g);
        
        for (Forma f : formas) {
            f.desenhar(g);
        }

        // desenha os pontos onde o usuário clicou para ajudar a desenhar
        for (Ponto p : pontos) {
            new Circulo(p, 3, Color.black).desenhar(g);
            new Circulo(p, 5, Color.white).desenhar(g);
        }
    }
    
    public void setCor(Color c){
        cor = c;
    }

    public void adicionarPonto(Ponto p) {
        this.pontos.add(p);

        super.getParent().repaint();
    }

    public void removerPonto() {
        if (this.pontos.size() > 0) {
            pontos.remove(pontos.get(pontos.size() - 1));
        }

        super.getParent().repaint();
    }

    public void adicionarForma(Forma f) {
        formas.add(f);
        camadas.adicionarCamada(f.getNome());

        super.getParent().repaint();
    }

    public void removerForma(int indice) {
        if (this.formas.size() > 0) {
            formas.remove(formas.get(indice));
            camadas.removerCamada(indice);
        }

        super.getParent().repaint();
    }

    public void setModo(String m) {
        this.modo = m;
        pontos.clear();
    }

    public String getModo() {
        return this.modo;
    }

    public void setFormas(ArrayList<Forma> f) {
        this.formas = f;
    }

    public ArrayList getFormas() {
        return this.formas;
    }

    public void transladarForma(Ponto novoCentro) {
        formas.get(camadas.getSelecionado()).transladar(novoCentro.subtracao(formas.get(camadas.getSelecionado()).getCentro()));
        super.getParent().repaint();
    }

    public void rotacionarForma(float angulo) {
        this.formas.get(this.camadas.getSelecionado()).rotacionar(angulo);
        super.getParent().repaint();
    }
    
    public void escalarForma(float proporcao){
        formas.get(camadas.getSelecionado()).escalar(proporcao);
        super.getParent().repaint();
    }
    
    public void rasterizarForma(){
        formas.get(camadas.getSelecionado()).rasterizar(tela);
        formas.remove(camadas.getSelecionado());
        camadas.removerCamada(camadas.getSelecionado());
        super.getParent().repaint();
    }

    public void colorir(Color cor) {
        this.formas.get(this.camadas.getSelecionado()).setCor(cor);
        super.getParent().repaint();

    }
    
    public void preencherCor(int x, int y){
        tela.preencherCor(x, y, cor);
        super.getParent().repaint();
    }

    private class MouseHandler implements MouseListener {

        public void mousePressed(MouseEvent me) {
        }

        public void mouseReleased(MouseEvent me) {
            if (modo.equals("Reta")) {
                adicionarPonto(new Ponto(me.getX(), me.getY()));

                if (pontos.size() >= 2) {
                    adicionarForma(new Reta(pontos.get(0), pontos.get(1), cor));
                    pontos.clear();
                }
            } else if (modo.equals("Quadrado")) {
                adicionarPonto(new Ponto(me.getX(), me.getY()));

                if (pontos.size() >= 2) {
                    adicionarForma(new Quadrado(pontos.get(0), new Ponto(pontos.get(0).getX(), pontos.get(1).getY()), new Ponto(pontos.get(1).getX(), pontos.get(0).getY()), pontos.get(1), cor));
                    pontos.clear();
                }
            } else if (modo.equals("Circulo")) {
                adicionarPonto(new Ponto(me.getX(), me.getY()));

                if (pontos.size() >= 2) {
                    adicionarForma(new Circulo(pontos.get(0), (int) pontos.get(0).distancia(pontos.get(1)), cor));
                    pontos.clear();
                }
            } else if (modo.equals("Polilinha")) {
                adicionarPonto(new Ponto(me.getX(), me.getY()));
            } else if (modo.equals("Poligono")) {
                adicionarPonto(new Ponto(me.getX(), me.getY()));
            } else if (modo.equals("Translacao")) {
                transladarForma(new Ponto(me.getX(), me.getY()));
            } else if (modo.equals("Preencher")) {
                preencherCor(me.getX(), me.getY());
            }
        }

        public void mouseEntered(MouseEvent me) {
            requestFocus();
        }

        public void mouseExited(MouseEvent me) {
        }

        public void mouseClicked(MouseEvent me) {
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {

        public void mouseDragged(MouseEvent me) {
        }

        public void mouseMoved(MouseEvent me) {
        }
    }

    private class KeyHandler implements KeyListener {

        public void keyTyped(KeyEvent ke) {
        }

        public void keyPressed(KeyEvent ke) {
        }

        public void keyReleased(KeyEvent ke) {
            // tecla enter
            if (ke.getKeyCode() == 10) {
                if (modo.equals("Polilinha")) {
                    adicionarForma(new Polilinha(new ArrayList(pontos), cor));
                    pontos.clear();
                } else if (modo.equals("Poligono")) {
                    adicionarForma(new Poligono(new ArrayList(pontos), cor));
                    pontos.clear();
                }
            } // tecla delete
            else if (ke.getKeyCode() == KeyEvent.VK_DELETE) {
                removerForma(camadas.getSelecionado());
                pontos.clear();
            };
        }
    }
}
