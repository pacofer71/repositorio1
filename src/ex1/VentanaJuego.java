/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

/**
 *
 * @author pacofer71
 */
public class VentanaJuego extends JFrame{
    final static int DIM=8;
    PanelMinas pj;
    PanelRight pr;
    TMinas campo;
    Semaforo testigo;
    Control miControl;
   
    public VentanaJuego(){
        iniciaComponentes();
    }
    
    public void iniciaComponentes(){
        campo=new TMinas();
        testigo = new Semaforo(true);
        pj=new PanelMinas();
        pr=new PanelRight();
        
        Container lienzo = this.getContentPane();
        GroupLayout gl = new GroupLayout(lienzo);
        lienzo.setLayout(gl);
        
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        
        gl.setHorizontalGroup(
                gl.createSequentialGroup()
                    .addComponent(pj)
                    .addComponent(pr)
        );
        
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                    .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(pj)
                        .addComponent(pr)
                    
                    )
        );
        gl.linkSize(SwingConstants.VERTICAL, pj, pr);
        //----------------------------------------------------------------------
        miControl = new Control(this);
        iniciaBotones();
        //----------------------------------------------------------------------
        pack();
    }
    //--------------------------------------------------------------------------
    public void iniciaBotones(){
        for(int i=0; i<DIM; i++){
            for(int j=0; j<DIM; j++){
                pj.getBotones()[i][j].addActionListener(miControl);
            }
        }
        pr.getBtnPausa().addActionListener(miControl);
        pr.getBtnSalir().addActionListener(miControl);
        pr.getBtnStart().addActionListener(miControl);
    }
    //--------------------------------------------------------------------------
}
