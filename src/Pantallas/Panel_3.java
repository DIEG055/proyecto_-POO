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
import javax.swing.JButton;
import javax.swing.JPanel;
import programa.Coordenada;

/**
 *
 * @author juanm
 */
public class Panel_3 extends JPanel implements MouseListener {

    private  int xref=370;
    private  int yref=100;
    private  int tam_cuadrado=30;
    private boolean orientacion;
    private int xx,yy;
    private int tam=3;
    private Coordenada c;
    JButton REGRESAR = new JButton("REGRESAR");


    public Panel_3() {
        REGRESAR.setSize(200, 100);
        REGRESAR.setLocation(300,300);
        REGRESAR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        REGRESAR.setForeground(new java.awt.Color(255, 255, 255));
        REGRESAR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        REGRESAR.setContentAreaFilled(false);
        this.addMouseListener(this);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarEscenario(g);   
    }
       private void dibujarEscenario(Graphics g) {
        Graphics2D c = (Graphics2D) g; 
        Image fondo = loadImage("fondo_partida.jpg");
        c.drawImage(fondo, 0, 0, null);
        c.setColor(Color.WHITE);
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){ 
                c.drawRect(xref+(i*this.tam_cuadrado),yref+(j*this.tam_cuadrado), this.tam_cuadrado, this.tam_cuadrado);  
            }
        }
        for(int i=0;i<this.tam;i++){
            if(orientacion){
                c.setColor(Color.red);
                c.fillRect(xx+(i*this.tam_cuadrado), yy, this.tam_cuadrado, this.tam_cuadrado);
            }else{
                c.fillRect(xx, yy+(i*this.tam_cuadrado), this.tam_cuadrado, this.tam_cuadrado);
            }
        }
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
