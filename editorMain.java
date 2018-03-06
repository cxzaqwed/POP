/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gusta
 */
import java.awt.Color;
import javax.swing.*;

public class editorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        JFrame janela = new JFrame("POP");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
        janela.setLocationRelativeTo(janela);
        janela.setSize(800, 600);
        janela.getContentPane().setBackground(Color.CYAN);

    }

}