/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author paco
 */
public class HiloHora implements Runnable {
    JTextField panel;
    Semaforo testigo;
    public HiloHora(JTextField txt, Semaforo sem){
        panel=txt;
        testigo=sem;
    }
    @Override
    public void run() {
        String tiempo="";
        int min=0;
        int seg=0;
        String cadSeg="";
        String cadMin="";
        while(!testigo.isStop()){
            //System.out.println("Entro en while infinito!!!");
            while(testigo.isPausado()){
               // System.out.println("Estoy pausado!!!");
                panel.setText(tiempo);
                parar(500);
                panel.setText("  :  ");
                parar(500);
            }
            parar(1000);
            seg++;
            if(seg==59){
                seg=0;
                min++;
            }
            if(seg<10) cadSeg="0"+seg;
            else cadSeg=""+seg;
            if(min<10) cadMin="0"+min;
            else cadMin=""+min;
            tiempo=cadMin+" : "+cadSeg;
            panel.setText(tiempo);
        }
    }
    //--------------------------------------------------------------------------
    public void parar(long t){
        try {
            sleep(t);
        } catch (InterruptedException ex) {}
                
    }
    //--------------------------------------------------------------------------
    
}
