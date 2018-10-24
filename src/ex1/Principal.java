/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import javax.swing.JFrame;
import static javax.swing.SwingUtilities.invokeLater;

/**
 *
 * @author paco
 */
public class Principal {
    public static void mostrar(){
        VentanaJuego mv=new VentanaJuego();
        mv.setVisible(true);
        mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mv.setTitle("Busca Minas");
        mv.setResizable(false);
    }
    
    public static void main(String [] args){
        invokeLater(new Runnable(){
            @Override
            public void run(){
                mostrar();
            }
        });
        
    }
    
}
