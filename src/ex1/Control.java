/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author paco
 */
public class Control implements ActionListener {
    VentanaJuego vj;
    public Control(VentanaJuego v){
        vj=v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==vj.pr.getBtnSalir()){
         System.exit(0);
     } 
     //-------------------------------------------------------------------------
     if(e.getSource()==vj.pr.getBtnPausa()){
        if("PAUSE".equals(vj.pr.getBtnPausa().getText())){
            vj.pr.getBtnPausa().setText("CONTINUE");
        }
        else{
            vj.pr.getBtnPausa().setText("PAUSE");
        }
        
     }
     //-------------------------------------------------------------------------
    }
    
    
}
