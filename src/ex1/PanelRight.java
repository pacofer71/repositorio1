/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author pacofer71
 */
public class PanelRight extends JPanel {
    private JLabel band, reloj;
    private JTextField tband, treloj;
    JButton btnStart, btnSalir, btnPausa;
    
    public PanelRight(){
        iniciaComponentes();
    }
    public void iniciaComponentes(){
        
        ImageIcon iconoBand = new ImageIcon(getClass().getResource("/img/bandera.jpg"));
        ImageIcon iconoReloj = new ImageIcon(getClass().getResource("/img/reloj1.jpg"));
        
        band=new JLabel("");
        band.setPreferredSize(new Dimension(30,30));
        band.setIcon(iconoBand);
        
        reloj=new JLabel("");
        reloj.setPreferredSize(new Dimension(30,30));
        reloj.setIcon(iconoReloj);
        
        tband=new JTextField("00/00");
        tband.setEditable(false);
        tband.setFont(new Font("Serif", Font.PLAIN, 14));
        tband.setForeground(Color.green);
        tband.setBackground(Color.gray);
        tband.setPreferredSize(new Dimension(60,25));
        tband.setMaximumSize(new Dimension(60,25));
        tband.setHorizontalAlignment(JTextField.CENTER);
        
        treloj=new JTextField("00:00");
        treloj.setEditable(false);
        treloj.setFont(new Font("Serif", Font.PLAIN, 14));
        treloj.setForeground(Color.green);
        treloj.setBackground(Color.gray);
        treloj.setHorizontalAlignment(JTextField.CENTER);
        treloj.setPreferredSize(new Dimension(60,25));
        treloj.setMaximumSize(new Dimension(60,25));
        
        btnStart=new JButton("START");
        btnStart.setPreferredSize(new Dimension(80, 35));
        btnStart.setMaximumSize(new Dimension(95, 35));
        btnStart.setMargin(new Insets(0,0,0,0));
        btnSalir=new JButton("EXIT");
        btnSalir.setPreferredSize(new Dimension(80, 35));
        btnSalir.setMaximumSize(new Dimension(95, 35));
        btnSalir.setMargin(new Insets(0,0,0,0));
        btnSalir.setBackground(Color.LIGHT_GRAY);
        btnSalir.setForeground(Color.red);
        btnPausa=new JButton("PAUSE");
        btnPausa.setEnabled(false);
        btnPausa.setPreferredSize(new Dimension(80, 35));
        btnPausa.setMaximumSize(new Dimension(95, 35));
        btnPausa.setMargin(new Insets(0,0,0,0));
        //-------------
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        
        GroupLayout gl = new GroupLayout(this);
        this.setLayout(gl);
        
        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);
        
        gl.setHorizontalGroup(
                gl.createSequentialGroup()
                    .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(band)
                            .addComponent(tband)
                            .addComponent(reloj)
                            .addComponent(treloj)
                            
                            .addComponent(this.btnStart)
                            .addComponent(this.btnPausa)
                            .addComponent(this.btnSalir)
                    
                    )
        );
        gl.linkSize(SwingConstants.HORIZONTAL, btnStart, btnPausa, btnSalir);
        gl.linkSize(SwingConstants.HORIZONTAL, tband, treloj);
        gl.linkSize(SwingConstants.HORIZONTAL, band, reloj);
        //------------------------
        gl.setVerticalGroup(
            gl.createSequentialGroup()
                .addComponent(band)
                .addGap(10, 10, 10)    
                .addComponent(tband)
                .addGap(15, 15, 15)  
                .addComponent(reloj)
                .addGap(10, 10, 10)      
                .addComponent(treloj)
                .addGap(90, 90, 90)
                .addComponent(this.btnStart)
                .addComponent(this.btnPausa)
                .addComponent(this.btnSalir)
                );
        
            
        
}

    public JTextField getTband() {
        return tband;
    }

    public JTextField getTreloj() {
        return treloj;
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JButton getBtnPausa() {
        return btnPausa;
    }
    
}    










