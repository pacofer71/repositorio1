/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author paco
 */
public class Control implements ActionListener, MouseListener {
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
                vj.testigo.setPausado(true);
                activaBotones(false);
               
            }
            else{ 
                vj.pr.getBtnPausa().setText("PAUSE");
                vj.testigo.setPausado(false);
                activaBotones(true);
             
            }
        }
    //-------------------------------------------------------------------------
        if(e.getSource()==vj.pr.btnStart){
            vj.pr.getBtnPausa().setEnabled(true);
            vj.pr.getBtnStart().setEnabled(false);
            activaBotones(true);
            //inicializo las minas
            vj.campo=new TMinas();
            Thread hilo = new Thread(vj.miHilo);
            vj.testigo.setStop(false);
            vj.testigo.setPausado(false);
            if(!hilo.isAlive()) hilo.start();
        }
     //-------------------------------------------------------------------------
        for(int f=0; f<vj.DIM; f++){
            for(int c=0; c<vj.DIM; c++){
                if(e.getSource()==vj.pj.getBotones()[f][c]){
                    if ((e.getModifiers() & 4) !=0){
                        JOptionPane.showMessageDialog(vj, "Click derecho en boton :" + f + ", " +c   );
                    }
                }
            }
        }
    //--------------------------------------------------------------------------
        for(int f=0; f<vj.DIM; f++){
            for(int c=0; c<vj.DIM; c++){
              if(e.getSource()==vj.pj.getBotones()[f][c]){
                
                //Hemos Pisado una mina!!!!  
                 if(vj.campo.getCampoMinas()[f][c]==9){
                     activaBotones(false);
                     vj.pj.getBotones()[f][c].setIcon(new ImageIcon(getClass().getResource("/img/minaexpb.png")));
                     JOptionPane.showMessageDialog(vj, "Perdiste!!!!!");
                     vj.testigo.setStop(true);
                     pintarMinas(f,c);
                     return;
                 }
                 //No hemos dado con ninguna MIna 
                 vj.pj.getBotones()[f][c].setEnabled(false);
                 descubrir(f,c);
              }  
            }
        } 
        
     //-------------------------------------------------------------------------
     //-------------------------------------------------------------------------
    }
    public void descubrir(int fil, int col){
        //
        for(int i=maximo(0, fil-1); i<=minimo(vj.DIM-1, fil+1); i++){
            for(int j=maximo(0, col-1); j<=minimo(vj.DIM-1, col+1); j++){
                if(i==fil && j==col) break;
               // if(!vj.pj.getBotones()[i][j].isEnabled()) break;
                if(vj.campo.getCampoMinas()[i][j]!=9){
                    if(vj.campo.getCampoMinas()[i][j]==0){
                        vj.pj.getBotones()[i][j].setEnabled(false);
                        if(vj.pj.getBotones()[i][j].isEnabled()) descubrir(i,j);
                    }
                    else{
                        vj.pj.getBotones()[i][j].setText(" "+vj.campo.getCampoMinas()[i][j]);
                        vj.pj.getBotones()[i][j].setEnabled(false);
                    }
                }
            }
        }
    }
    //--------------------------------------------------------------------------
    public void pintarMinas(int m, int n){
        for(int f=0; f<vj.DIM; f++){
            for(int c=0; c<vj.DIM; c++){
                if(f==m && c==n) break;
               // vj.pj.getBotones()[f][c].setText("");
                if(vj.campo.getCampoMinas()[f][c]==9){
                     vj.pj.getBotones()[f][c].setIcon(new ImageIcon(getClass().getResource("/img/minanoexp.png")));
                }
            }
        }
    }
    //--------------------------------------------------------------------------
    public void activaBotones(Boolean b){
        for(int i=0; i<vj.DIM; i++){
            for(int j=0; j<vj.DIM; j++){
                vj.pj.getBotones()[i][j].setEnabled(b);
               
            }
        }
    }
    //--------------------------------------------------------------------------
    public int maximo(int a, int b){
        if(a>=b) return a;
        return b;
    }
    public int minimo(int a, int b){
        if(a>=b) return b;
        return a;
    }
    //--------------------------------------------------------------------------

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
