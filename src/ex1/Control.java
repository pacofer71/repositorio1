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
     if(e.getSource()==vj.pr.btnStart){
         vj.pr.getBtnPausa().setEnabled(true);
         vj.pr.getBtnStart().setEnabled(false);
         activaBotones();
         vj.campo=new TMinas();
     }
     //-------------------------------------------------------------------------
    }
    //--------------------------------------------------------------------------
    public void activaBotones(){
        for(int i=0; i<vj.DIM; i++){
            for(int j=0; j<vj.DIM; j++){
                vj.pj.getBotones()[i][j].setEnabled(true);
                
            }
        }
    }
    //-----------------------------------------------------------------------
}
