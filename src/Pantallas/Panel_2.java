/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author juanm
 */
public class Panel_2 extends JPanel {
    
     JButton vsCOM = new JButton("PARTIDA VS COM");
     JButton VSLOCAL = new JButton("PARTIDA LOCAL");
     JButton ONLINE = new JButton("PARTIDA ONLINE");
     JButton REGRESAR = new JButton("REGRESAR");
    public Panel_2() {
        
        REGRESAR.setSize(200, 100);
        REGRESAR.setLocation(300,300);
        REGRESAR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        REGRESAR.setForeground(new java.awt.Color(255, 255, 255));
        REGRESAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        REGRESAR.setContentAreaFilled(false);
        
        vsCOM.setSize(200, 100);
        vsCOM.setLocation(300,300);
        vsCOM.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        vsCOM.setForeground(new java.awt.Color(255, 255, 255));
        vsCOM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        vsCOM.setContentAreaFilled(false);
        
        VSLOCAL.setSize(200, 100);
        VSLOCAL.setLocation(300,300);
        VSLOCAL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        VSLOCAL.setForeground(new java.awt.Color(255, 255, 255));
        VSLOCAL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        VSLOCAL.setContentAreaFilled(false);
        
        ONLINE.setSize(200, 100);
        ONLINE.setLocation(300,300);
        ONLINE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ONLINE.setForeground(new java.awt.Color(255, 255, 255));
        ONLINE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ONLINE.setContentAreaFilled(false);
        
    }
      
    
    
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = loadImage("eleccion_partida.png");
        g.drawImage(fondo, 0, 0, null);
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
