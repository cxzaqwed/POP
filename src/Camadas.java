import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Camadas extends JPanel {
    private JList lista;
    private DefaultListModel modelo;
    
    private int selecionado = 0;
    
    public Camadas(){
        super.setBackground(Color.yellow);
        ListHandler handler = new ListHandler();
        
        setFocusable(false);
        
        modelo = new DefaultListModel();
        lista = new JList(modelo);
        lista.setVisibleRowCount(10);
        lista.addListSelectionListener(handler);
        lista.setFocusable(false);
        
        add(lista);
    }
    
    public void adicionarCamada(String texto){
        this.modelo.addElement(texto);
        
        if(this.modelo.getSize() > 0){
            this.selecionado = this.modelo.getSize() - 1;
            this.lista.setSelectedIndex(this.selecionado);
        }
        
        super.getParent().repaint();
    }
    
    public void removerCamada(int indice){
        if(modelo.getSize() > 0){
            modelo.remove(indice);
            lista.setSelectedIndex(modelo.getSize() - 1);
            selecionado = modelo.getSize() - 1;
        }
        
        super.getParent().repaint();
    }
    
    public int getSelecionado(){
        return this.selecionado;
    }
    
    private class ListHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent lse) {
            selecionado = lista.getSelectedIndex();
        }
    }
}
