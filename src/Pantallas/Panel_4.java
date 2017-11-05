/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author juanm
 */
public class Panel_4 extends JPanel implements MouseListener {

        @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarEscenario(g);   

    }
       private void dibujarEscenario(Graphics g) {
        Graphics2D c = (Graphics2D) g; 
        Image fondo = loadImage("fondo_partida.jpg");
        c.drawImage(fondo, 0, 0, null);
        
       }
        public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
     
    }

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
    
}
