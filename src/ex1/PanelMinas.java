/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author pacofer71
 */
public class PanelMinas extends JPanel {
    final static int DIM=8;
    JButton [][] botones;
     public PanelMinas(){
         iniciaComponentes();
     }
     public void iniciaComponentes(){
         botones = new JButton[DIM][DIM];
         GridLayout grl = new GridLayout(DIM, DIM, 4,4);
         this.setLayout(grl);
         
         this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
         for(int i=0; i<DIM; i++){
             for(int j=0; j<DIM; j++){
                 botones[i][j]=new JButton(" ");
                 //botones[i][j].setOpaque(false);
                 botones[i][j].setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
                 botones[i][j].setMaximumSize(new Dimension(40,40));
                 botones[i][j].setPreferredSize(new Dimension(40,40));
                 botones[i][j].setMargin(new Insets(0,0,0,0));
                 botones[i][j].setBackground(new Color(17, 221, 205));
                 botones[i][j].setEnabled(false);
                 this.add(botones[i][j]);
             }
         }
         
         
         
     }

    public JButton[][] getBotones() {
        return botones;
    }
}
