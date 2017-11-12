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
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author juanm
 */
public class Panel_5 extends JPanel {

    JButton REGRESAR = new JButton("REGRESAR");
    JLabel texto = new JLabel("PROXIMAMENTE!!!");
    public Panel_5() {
        this.add(this.REGRESAR);
        this.add(this.texto);
        texto.setSize(300,200);
        texto.setLocation(300,300);
         texto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        texto.setForeground(new java.awt.Color(255, 255, 255));       
        REGRESAR.setSize(200, 100);
        REGRESAR.setLocation(300, 300);
        REGRESAR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        REGRESAR.setForeground(new java.awt.Color(255, 255, 255));
        REGRESAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        REGRESAR.setContentAreaFilled(false);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = loadImage("panel_online.png");
        g.drawImage(fondo, 0, 0, null);
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
