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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author paco
 */
public class Control implements ActionListener, MouseListener {
    
    VentanaJuego vj;
    static final int DIM=8;
    static final int MINAS=10;
    int contBanderas;
    int contAciertos;
    public Control(VentanaJuego v){
        vj=v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vj.pr.getBtnSalir()){
            System.exit(0);
        } 
    //------------------  BOTON PAUSA -------------------------------------------
    
        if(e.getSource()==vj.pr.getBtnPausa()){
            if("PAUSE".equals(vj.pr.getBtnPausa().getText())){
                vj.pr.getBtnPausa().setText("CONTINUE");
                vj.testigo.setPausado(true);
                muestraBotones(false);
               
            }
            else{ 
                vj.pr.getBtnPausa().setText("PAUSE");
                vj.testigo.setPausado(false);
                muestraBotones(true);
             
            }
        }
    //----------------    BOTON START   -------------------------------------------
    
        if(e.getSource()==vj.pr.btnStart){
            vj.pr.getBtnPausa().setEnabled(true);
            vj.pr.getBtnStart().setEnabled(false);
            limpiarBotones();
            activaBotones(true);
            vj.pr.getTband().setText("00/"+MINAS);
            //inicializo las minas
            vj.campo=new TMinas();
            Thread hilo = new Thread(vj.miHilo);
            vj.testigo.setStop(false);
            vj.testigo.setPausado(false);
            if(!hilo.isAlive()) hilo.start();
            contBanderas=0;
            contAciertos=0;
        }
     //-------------------------------------------------------------------------
       
    //------------------     BOTONES MINAS        -----------------------------------------
    
        for(int f=0; f<vj.DIM; f++){
            for(int c=0; c<vj.DIM; c++){
              if(e.getSource()==vj.pj.getBotones()[f][c]){
                
                //Hemos Pisado una mina!!!!  
                 if(vj.campo.getCampoMinas()[f][c]==9){
                     activaBotones(false);
                     vj.pj.getBotones()[f][c].setIcon(new ImageIcon(getClass().getResource("/img/minasexpult.png")));
                     JOptionPane.showMessageDialog(vj, "Perdiste!!!!!");
                     vj.testigo.setStop(true);
                     pintarMinas(f,c);
                     vj.pr.btnStart.setEnabled(true);
                     return;
                 }
                 //No hemos dado con ninguna MIna 
                 vj.pj.getBotones()[f][c].setEnabled(false);
                 if(vj.campo.getCampoMinas()[f][c]!=0) vj.pj.getBotones()[f][c].setText(""+vj.campo.getCampoMinas()[f][c]);
                 descubrir(f,c);
              }  
            }
        } 
    }
    //-------------------------------------------------------------------------------
    public void descubrir(int fil, int col){
        //
        for(int i=maximo(0, fil-1); i<=minimo(vj.DIM-1, fil+1); i++){
            for(int j=maximo(0, col-1); j<=minimo(vj.DIM-1, col+1); j++){
                if(i==fil && j==col) break;
               // if(!vj.pj.getBotones()[i][j].isEnabled()) break;
                if(vj.campo.getCampoMinas()[i][j]!=9 && vj.pj.getBotones()[i][j].isEnabled()){
                    if(vj.campo.getCampoMinas()[i][j]==0){
                        vj.pj.getBotones()[i][j].setEnabled(false);
                        descubrir(i,j);
                    }
                    else{
                        vj.pj.getBotones()[i][j].setText(""+vj.campo.getCampoMinas()[i][j]);
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
    public void limpiarBotones(){
        for(int i=0; i<vj.DIM; i++){
            for(int j=0; j<vj.DIM; j++){
                vj.pj.getBotones()[i][j].setIcon(null);
                vj.pj.getBotones()[i][j].setText("");
            }
        }
    }
    //---------------------------------------------------------------------------
    public void muestraBotones(Boolean b){
        for(int i=0; i<vj.DIM; i++){
            for(int j=0; j<vj.DIM; j++){
                vj.pj.getBotones()[i][j].setVisible(b);
               
            }
        }
    }
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
        
        for(int i=0; i<vj.DIM; i++){
            for(int j=0; j<vj.DIM; j++){
                if(e.getSource()==vj.pj.getBotones()[i][j]){
                    if(e.getButton()==MouseEvent.BUTTON3){
                        ponBanderas(i,j);
                        
                       
                    }
                }
            }    
        }
    }
    //---------------------------------------------------------------------------
    public void ponBanderas(int f, int c ){
        Icon bandera1=new ImageIcon(getClass().getResource("/img/bandera.jpg"));
        Icon bandera2 =new ImageIcon(getClass().getResource("/img/bandera2.jpg"));
        Icon icono =  (ImageIcon)vj.pj.getBotones()[f][c].getIcon();
        System.out.println("boton["+f+"]["+c+"]"+""+icono);
        System.out.println("bandera1= "+ bandera1);
        System.out.println("bandera2= "+ bandera2);
        if(icono==null){
            vj.pj.getBotones()[f][c].setIcon(bandera1);
            contBanderas++;
            if(vj.campo.getCampoMinas()[f][c]==9){
                contAciertos++;
            }
            vj.pr.getTband().setText(""+contBanderas+"/"+MINAS);
            if(contAciertos==MINAS){
                ganar();
            }
        }
        else if((""+icono).equals(""+bandera1)){
            vj.pj.getBotones()[f][c].setIcon(bandera2);
        }
        else{
            vj.pj.getBotones()[f][c].setIcon(null);
            if(vj.campo.getCampoMinas()[f][c]==9) contAciertos--;
            contBanderas--;
        }
        
    }
    //--------------------------------------------------------------------------
        public void ganar(){
            JOptionPane.showMessageDialog(vj, "## GANASTE, FELICIDADES ##");
            vj.testigo.setStop(true);
            vj.pr.btnStart.setEnabled(true);
            return;
        }
    //--------------------------------------------------------------------------
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    //--------------------------------------------------------------------------
   
}
