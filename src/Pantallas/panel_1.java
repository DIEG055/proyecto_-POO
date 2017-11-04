/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author juanm
 */
public class panel_1 extends JPanel {
   
    JButton iniciar= new JButton("INICIAR");
    JButton configuracion= new JButton("CONFIGURACION");
    public panel_1() {
        
        iniciar.setSize(200, 100);
        Point p= new Point(300,300);
        iniciar.setLocation(300,300);
        iniciar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        iniciar.setForeground(new java.awt.Color(255, 255, 255));
        iniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        iniciar.setContentAreaFilled(false);
        
        configuracion.setSize(200, 100);
        configuracion.setLocation(300,300);
        configuracion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        configuracion.setForeground(new java.awt.Color(255, 255, 255));
        configuracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        configuracion.setContentAreaFilled(false);
    }
    
    
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image fondo = loadImage("pantalla_inicio.png");
        g.drawImage(fondo, 0, 0, null);
    }

    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }

}
