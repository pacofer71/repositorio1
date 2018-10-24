/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
        btnSalir=new JButton("EXIT");
        btnPausa=new JButton("PAUSE");
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
}    










